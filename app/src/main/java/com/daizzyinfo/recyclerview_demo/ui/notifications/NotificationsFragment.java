package com.daizzyinfo.recyclerview_demo.ui.notifications;

import android.Manifest;
import android.Manifest.permission;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.daizzyinfo.recyclerview_demo.Activity_Order_Details;
import com.daizzyinfo.recyclerview_demo.Change_Password;
import com.daizzyinfo.recyclerview_demo.Contact_Us;
import com.daizzyinfo.recyclerview_demo.CustomAlertDialog;
import com.daizzyinfo.recyclerview_demo.R;
import com.daizzyinfo.recyclerview_demo.activit.Profile;
import com.daizzyinfo.recyclerview_demo.databinding.FragmentNotificationsBinding;
import com.daizzyinfo.recyclerview_demo.utils.Constant;

public class NotificationsFragment extends Fragment {

    RelativeLayout LogBt;

    private FragmentNotificationsBinding binding;
    ImageView imageView2;

    ImageView ImgCamera,update_igNxt;

    TextView con_with_us;

    TextView changepassword;

    private static final int pic_id = 123;
//   private static final int priaction_pick=150;
    private static final int CAMERA_PERMISSION_CODE = 100;
//    private static final int GALLERY_PERMISSION_CODE = 200;


    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //LogOutDialog();
        View view =  inflater.inflate(R.layout.fragment_notifications, container, false);

        changepassword= view.findViewById(R.id.changepassword);
        update_igNxt=view.findViewById(R.id.update_igNxt);
        changepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), Change_Password.class);
                startActivity(intent);
            }
        });


        con_with_us=view.findViewById(R.id.con_with_us);
        con_with_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Contact_Us.class);
                startActivity(intent);
            }
        });




        View view1 = inflater.inflate(R.layout.fragment_notifications, container,false);

        ImgCamera= view.findViewById(R.id.ImgCamera);
        ImgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkPermission(permission.CAMERA, CAMERA_PERMISSION_CODE);
            }
        });
        LogBt=view.findViewById(R.id.LogBt);

        upDateProfileScNext();
        return view;





    }










     /* binding.imageView2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              checkPermission(permission.CAMERA, GALLERY_PERMISSION_CODE);
          }
      });

        return binding.getRoot();
    }*/





    // Function to check and request permission
    public void checkPermission(String permission, int requestCode)
    {
        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(getActivity(), permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(getActivity(), new String[] { permission }, requestCode);
        }
        else {


            Toast.makeText(getActivity(), "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }






    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode,
                permissions,
                grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getActivity(), "Camera Permission Granted", Toast.LENGTH_SHORT) .show();
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,pic_id);
            }
            else {
                Toast.makeText(getActivity(), "Camera Permission Denied", Toast.LENGTH_SHORT) .show();
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_id) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            binding.ImgCamera.setImageBitmap(photo);
        }
}


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void upDateProfileScNext(){

        update_igNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Profile.class);
                startActivity(intent);
                
            }
        });





    }

 /*   public void LogOutDialog() {
        LogBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomAlertDialog dialogFragment = new CustomAlertDialog();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = getFragmentManager().beginTransaction();

              dialogFragment.show(ft,"dialog");

                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                //  ft.addToBackStack(null);





            }
        });


    }*/


}




/*
public void checkPermission(String permission, int requestCode) {
    if (ContextCompat.checkSelfPermission(getActivity(), permission) == PackageManager.PERMISSION_DENIED) {

        // Requesting the permission
        ActivityCompat.requestPermissions(getActivity(), new String[]{permission}, requestCode);
    } else {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, pic_id);
        Toast.makeText(getActivity(), "Permission already granted", Toast.LENGTH_SHORT).show();

    }

}*/
/*

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode,
                permissions,
                grantResults);

        if (requestCode == GALLERY_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getActivity(), "Camera Permission Granted", Toast.LENGTH_SHORT) .show();
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,pic_id);
            }
            else {
                Toast.makeText(getActivity(), "Camera Permission Denied", Toast.LENGTH_SHORT) .show();
            }
        }
    }

        public Void onActivityResult(int requestCode,int resultCode,Intent data);
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == priaction_pick){
                Bitmap photo=(Bitmap)data.getExtras().get("data");
                binding.imageView2.setImageBitmap(photo);

                }

*/




