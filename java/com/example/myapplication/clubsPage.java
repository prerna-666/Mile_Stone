package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class clubsPage extends AppCompatActivity {


    GridView gridView;
    ArrayList<clubv> list;
    clubViewAdapter adapter = null;
    public static SQLitehelper sqLitehelper;
    private ActivityResultLauncher<String> galleryLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs_page);

        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new clubViewAdapter(this, R.layout.clubs_view, list);
        gridView.setAdapter(adapter);




        sqLitehelper = new SQLitehelper(this, "FoodDB.sqlite", null, 1);

        // Create the FOOD table if it doesn't exist
        sqLitehelper.queryData("CREATE TABLE IF NOT EXISTS FOOD (Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price VARCHAR, image BLOB)");

        Cursor cursor = sqLitehelper.getData("SELECT * FROM FOOD");
        list.clear();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            byte[] image = cursor.getBlob(3);
            list.add(new clubv(id, name, price, image));
        }

        adapter.notifyDataSetChanged();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                clubv selectedClub = list.get(position);
                Intent registrationIntent = new Intent(getApplicationContext(), RegistrationsForClubs.class);
                registrationIntent.putExtra("clubName", selectedClub.getName());

                startActivity(registrationIntent);

            }
        });
    }
}