package com.avery.thirdapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PhotoActivity extends AppCompatActivity {

    Button btnGallery, btnCamera;
    ImageView imgPhoto;

    ActivityResultLauncher<Intent> resultLauncher;

    String imgFilePath;
    Uri photoUri;

    boolean isCamera = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        btnGallery = findViewById(R.id.btnGallery);
        btnCamera = findViewById(R.id.btnCamera);
        imgPhoto = findViewById(R.id.imgPhoto);


        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                isCamera = false;

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);

//                startActivityForResult(intent, 1234);

                resultLauncher.launch(intent);

            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isCamera = true;

                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

                File photoFile = null;

                try{

                    photoFile = createImageFile();

                }catch(IOException e){

                }

                if(photoFile != null){

                    photoUri = FileProvider.getUriForFile(PhotoActivity.this, getPackageName(), photoFile);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);

                }

                resultLauncher.launch(intent);

            }
        });


        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {

                        if(result.getResultCode() == RESULT_OK){
                            if(isCamera == false) {

                                Uri uri = result.getData().getData();
                                imgPhoto.setImageURI(uri);
                            }else{

                                imgPhoto.setImageURI(photoUri);

                            }
                        }
                    }
                });
    }


    File createImageFile() throws IOException{


        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "TEST_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);

        imgFilePath = image.getAbsolutePath();

        return image;
    }



//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode == 1234){
//            if(resultCode == RESULT_OK){
//
//                Uri uri = data.getData();
//                imgPhoto.setImageURI(uri);
//
//            }
//        }
//    }
}