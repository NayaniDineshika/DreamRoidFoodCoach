package com.example.foodcoach;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class inputFoodAd extends AppCompatActivity {

    EditText foodname, price, shopname, location, phonenumber;
    Button addimage, save;
    ImageView imageView;

    final int REQUEST_CODE_GALLERY =999;
    public static  SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_food_ad);

        init();

        sqLiteHelper = new SQLiteHelper(this,"foodCoachDB.sqlite",null, 1);

        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS FOOD (Id INTEGER PRIMARY KEY AUTOINCREMENT, foodname VARCHAR, price VARCHAR, shopname VARCHAR, location VARCHAR, phonenumber VARCHAR, image BLOG)");

        addimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        inputFoodAd.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try{
                    sqLiteHelper.insertData(
                            foodname.getText().toString().trim(),
                            price.getText().toString().trim(),
                            shopname.getText().toString().trim(),
                            location.getText().toString().trim(),
                            phonenumber.getText().toString().trim(),
                            imageViewToByte(imageView)
                    );

                    Toast.makeText(getApplicationContext(), "Added successfully!", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }

    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return  byteArray;


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode==REQUEST_CODE_GALLERY){
            if(grantResults.length> 0 && grantResults[0] == PackageManager.PERMISSION_DENIED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
               startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }
            else {
                Toast.makeText(getApplicationContext(),"You don't have permission to access file loaction!", Toast.LENGTH_SHORT).show();
            }
            return;
        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE_GALLERY && requestCode == RESULT_OK && data != null){
            Uri uri= data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);

            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void init(){
        foodname = (EditText) findViewById(R.id.fooditem);
        price = (EditText) findViewById(R.id.price);
        shopname = (EditText) findViewById(R.id.phonenumber);
        location = (EditText) findViewById(R.id.location);
        phonenumber = (EditText) findViewById(R.id.phonenumber);
        imageView = (ImageView) findViewById(R.id.imageView2);
        addimage = (Button) findViewById(R.id.button11);
        save =(Button) findViewById(R.id.button2);
    }
}