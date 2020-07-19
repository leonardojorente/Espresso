package com.leonardojorente.espressotests;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SelectTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_test);
        Button loginButton = (Button) findViewById(R.id.button_back_login);
        Button galleryButton = (Button) findViewById(R.id.button_gallery_view);
        Button toastButton = (Button) findViewById(R.id.button_toast);
        Button materialDialogButton = (Button) findViewById(R.id.button_dialog);
        Button recyclerViewButton = (Button) findViewById(R.id.button_recycler_view);
        Button cameraButton = (Button) findViewById(R.id.button_camera);
        Button browserButton = (Button) findViewById(R.id.button_browser);
        Button idleButton = (Button) findViewById(R.id.button_idle);

        //Idle button code
        idleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EspressoIdlingResource.increment();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        openDialogEmptyFieldsWarning();
                        EspressoIdlingResource.decrement();
                    }
                },3000);


            }
        });


        //Browser button code
        browserButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                openBrowser(v);

            }
        });

        //Gallery button code
        galleryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                openGallery();

            }
        });

        //camera button code
        cameraButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                openCamera();

            }
        });


        //recycler view button code
        recyclerViewButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openRecyclerView();

            }
        });

        //material dialog button code
        materialDialogButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openDialogEmptyFieldsWarning();

            }
        });


        //toast button code
        toastButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                toastMessageTest("This is a toast test message");

            }
        });

        //back button code
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                onBackPressed();

            }
        });

    }
    public void toastMessageTest (String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();

    }

    public void openDialogEmptyFieldsWarning (){
        DialogSelectTestActivity dialogSelectTestActivityObject = new DialogSelectTestActivity();
        dialogSelectTestActivityObject.show(getSupportFragmentManager(), "Empty fields");
    }

    public void openRecyclerView (){
        Intent intent = new Intent(this,RecyclerViewActivity.class);
        startActivity(intent);
    }

    public void openCamera (){
        Intent callCameraApplicationIntent = new Intent();
        callCameraApplicationIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(callCameraApplicationIntent);

    }

    public void openGallery (){
        Intent intent = new Intent(this,GalleryActivity.class);
        startActivity(intent);

    }

    public void openBrowser (View view){
        Intent intent = new Intent(this,WebViewActivity.class);
        startActivity(intent);
    }
    }

