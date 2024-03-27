package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import android.os.Bundle;

public class clubsViewList extends AppCompatActivity {


    GridView gridView;
    ArrayList<clubv> list;
    clubViewAdapter adapter = null;
    private ActivityResultLauncher<String> galleryLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs_view_list);



        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new clubViewAdapter(this, R.layout.clubs_view, list);
        gridView.setAdapter(adapter);

        galleryLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {
            // Handle the result URI here
            if (uri != null) {
                // Do something with the selected URI
                try {
                    InputStream inputStream = getContentResolver().openInputStream(uri);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    imageViewFood.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        Cursor cursor = addClubsByAdmin.sqLitehelper.getData("SELECT * FROM FOOD");
        list.clear();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            byte[] image = cursor.getBlob(3);
            list.add(new clubv(id, name, price, image));
        }

        adapter.notifyDataSetChanged();

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                CharSequence[] items = {"Update", "Delete"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(clubsViewList.this);

                dialog.setTitle("Choose an action");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (item == 0) {
                            //update

                            Cursor c=addClubsByAdmin.sqLitehelper.getData("SELECT id FROM FOOD");
                            ArrayList<Integer> arrID=new ArrayList<>();
                            while (c.moveToNext())
                            {
                                arrID.add(c.getInt(0));
                            }
                            showDialogUpdate(clubsViewList.this, arrID.get(position));
                        } else {
                            //delete

                            Cursor c=addClubsByAdmin.sqLitehelper.getData("SELECT id FROM FOOD");
                            ArrayList<Integer> arrID=new ArrayList<>();
                            while (c.moveToNext())
                            {
                                arrID.add(c.getInt(0));
                            }

                            showDialogDelete(arrID.get(position));
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });
    }

    ImageView imageViewFood;
    private void showDialogUpdate(Activity activity, int position)
    {
        Dialog dialog=new Dialog(activity);
        dialog.setContentView(R.layout.update_club_activity);
        dialog.setTitle("Update");

        imageViewFood=(ImageView) dialog.findViewById(R.id.imageViewFood);
        final EditText edtName=(EditText) dialog.findViewById(R.id.edtName);
        final EditText edtPrice=(EditText) dialog.findViewById(R.id.edtPrice);
        Button btnUpdate=(Button) dialog.findViewById(R.id.btnUpdate);

        int width=(int) (activity.getResources().getDisplayMetrics().widthPixels*0.95);
        int height=(int) (activity.getResources().getDisplayMetrics().heightPixels*0.7);
        dialog.getWindow().setLayout(width,height);
        dialog.show();

        imageViewFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(clubsViewList.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 888 );
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try
                {
                    addClubsByAdmin.sqLitehelper.updateData(
                            edtName.getText().toString().trim(),
                            edtPrice.getText().toString().trim(),
                            addClubsByAdmin.imageViewToByte(imageViewFood),
                            position
                    );
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Updated successfully!!!",Toast.LENGTH_SHORT).show();
                }
                catch (Exception error)
                {
                    Log.e("Update error: ",error.getMessage());
                }
                updateFoodList();
            }
        });

    }

    private void showDialogDelete(final int idFood)
    {
        AlertDialog.Builder dialogDelete= new AlertDialog.Builder(clubsViewList.this);

        dialogDelete.setTitle("Warning!!");
        dialogDelete.setMessage("Are you sure you want to delete this?");
        dialogDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    addClubsByAdmin.sqLitehelper.deleteData(idFood);
                    Toast.makeText(getApplicationContext(),"Delete Successfully!!!",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Log.e("error", e.getMessage());
                }
                updateFoodList();
            }
        });

        dialogDelete.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogDelete.show();
    }
    private void updateFoodList()
    {
        Cursor cursor = addClubsByAdmin.sqLitehelper.getData("SELECT * FROM FOOD");
        list.clear();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            byte[] image = cursor.getBlob(3);
            list.add(new clubv(id, name, price, image));
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 888)
        {
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
            {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                galleryLauncher.launch("image/*");
            }
            else {
                Toast.makeText(getApplicationContext(),"you don't have permission to access file location!",Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}