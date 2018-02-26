package com.Alatheer.marmy.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.Alatheer.marmy.R;
import com.google.firebase.iid.FirebaseInstanceId;

import me.anwarshahriar.calligrapher.Calligrapher;

public class Login extends AppCompatActivity {
TextView skip;
ImageView login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);
        skip=findViewById(R.id.skip);

        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this,Loogin.class);
                startActivity(i);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this,Register.class);
                startActivity(i);
            }
        });
                skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this,ListMarma.class);
                String refreshedToken = FirebaseInstanceId.getInstance().getToken();
                Toast.makeText(Login.this, ""+refreshedToken, Toast.LENGTH_SHORT).show();
                Log.e("mmm",refreshedToken);
                startActivity(i);
            }
        });
    }
}
