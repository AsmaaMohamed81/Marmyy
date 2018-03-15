package com.Alatheer.marmy.UI;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.Alatheer.marmy.API.Service.APIClient;
import com.Alatheer.marmy.API.Service.Services;
import com.Alatheer.marmy.Model.MSG;
import com.Alatheer.marmy.Model.MessageResponse;
import com.Alatheer.marmy.R;
import com.google.firebase.iid.FirebaseInstanceId;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class mandopRequest extends Activity {
ImageView profileimge,cardimge;
Button endm;

EditText reason;

    byte[] photo;
    private Bitmap bp1,bp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandop_request);

        profileimge=findViewById(R.id.profileimg);
        cardimge=findViewById(R.id.cardimg);
        endm=findViewById(R.id.endam);
        reason=findViewById(R.id.reson);

        profileimge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK
                        ,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 2);

            }
        });

        cardimge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK
                        ,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 3);

            }
        });

        endm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveToServerDB();

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case 2:
                if(resultCode == RESULT_OK){
                    Uri choosenImage1 = data.getData();

                    if(choosenImage1 !=null){

                        bp1=decodeUri(choosenImage1, 200);
                        profileimge.setImageBitmap(bp1);
                    }
                }
                break;
            case 3:
                if(resultCode == RESULT_OK){
                    Uri choosenImage2 = data.getData();

                    if(choosenImage2 !=null){

                        bp2=decodeUri(choosenImage2, 200);
                        cardimge.setImageBitmap(bp2);
                    }
                }
                break;
        }
    }
    protected Bitmap decodeUri(Uri selectedImage, int REQUIRED_SIZE) {

        try {

            // Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage), null, o);

            // The new size we want to scale to
            // final int REQUIRED_SIZE =  size;

            // Find the correct scale value. It should be the power of 2.
            int width_tmp = o.outWidth, height_tmp = o.outHeight;
            int scale = 1;
            while (true) {
                if (width_tmp / 2 < REQUIRED_SIZE
                        || height_tmp / 2 < REQUIRED_SIZE) {
                    break;
                }
                width_tmp /= 2;
                height_tmp /= 2;
                scale *= 2;
            }

            // Decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage),
                    null, o2);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    protected  String encode(Bitmap bitmap)
    {


        ByteArrayOutputStream outputStream= new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,90,outputStream);
        byte[] bytes=outputStream.toByteArray();
        return Base64.encodeToString(bytes,Base64.DEFAULT);


    }
    private void saveToServerDB() {
//        pDialog = new ProgressDialog(Register.this);
//        pDialog.setIndeterminate(true);
//        pDialog.setMessage("Creating Account...");
//        pDialog.setCancelable(false);

      //  showpDialog();
        String Reson = reason.getText().toString();
        String profile = encode(bp1);
        String card = encode(bp2);
        String id = "2";


        Log.e("dataaaaaaaaaaaaaaaaa",Reson+"\n"+profile+"\n \n \n"+card+"\n"+id);

        Log.e("image2","\n \n \n"+card+"\n");

        Log.e("idddddddddddddddd",id);


        Services service = APIClient.getClient().create(Services.class);


        Call<MessageResponse> userCall = service.mandopRequest(id, profile,card, Reson);
        // startActivity(new Intent(Register.this, Home.class));

        userCall.enqueue(new Callback<MessageResponse>() {
            @Override
            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                //hidepDialog();
                //onSignupSuccess();
                //   Log.d("onResponse", "" + response.body().getMessage());


                if (response.isSuccessful()) {
                    Intent i=new Intent(mandopRequest.this, MainActivity.class);
                    startActivity(i);
                    finish();
                } else {
                     Toast.makeText(mandopRequest.this, "response error" , Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t) {
             //   hidepDialog();
                Log.d("onFailure", t.toString());
            }
        });
    }
}
