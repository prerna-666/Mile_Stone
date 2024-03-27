// Generated by view binder compiler. Do not edit!
package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAddEventsByAdminBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button btnAdd;

  @NonNull
  public final Button btnChoose;

  @NonNull
  public final Button btnList;

  @NonNull
  public final EditText edtName;

  @NonNull
  public final EditText edtPrice;

  @NonNull
  public final ImageView imageView;

  private ActivityAddEventsByAdminBinding(@NonNull RelativeLayout rootView, @NonNull Button btnAdd,
      @NonNull Button btnChoose, @NonNull Button btnList, @NonNull EditText edtName,
      @NonNull EditText edtPrice, @NonNull ImageView imageView) {
    this.rootView = rootView;
    this.btnAdd = btnAdd;
    this.btnChoose = btnChoose;
    this.btnList = btnList;
    this.edtName = edtName;
    this.edtPrice = edtPrice;
    this.imageView = imageView;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddEventsByAdminBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddEventsByAdminBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add_events_by_admin, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddEventsByAdminBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAdd;
      Button btnAdd = ViewBindings.findChildViewById(rootView, id);
      if (btnAdd == null) {
        break missingId;
      }

      id = R.id.btnChoose;
      Button btnChoose = ViewBindings.findChildViewById(rootView, id);
      if (btnChoose == null) {
        break missingId;
      }

      id = R.id.btnList;
      Button btnList = ViewBindings.findChildViewById(rootView, id);
      if (btnList == null) {
        break missingId;
      }

      id = R.id.edtName;
      EditText edtName = ViewBindings.findChildViewById(rootView, id);
      if (edtName == null) {
        break missingId;
      }

      id = R.id.edtPrice;
      EditText edtPrice = ViewBindings.findChildViewById(rootView, id);
      if (edtPrice == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      return new ActivityAddEventsByAdminBinding((RelativeLayout) rootView, btnAdd, btnChoose,
          btnList, edtName, edtPrice, imageView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
