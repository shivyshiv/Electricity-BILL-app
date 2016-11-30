package com.example.shivshankar.minorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRegister1;
    private Button buttonLogin1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRegister1 = (Button) findViewById(R.id.buttonRegister1);
        buttonLogin1 = (Button) findViewById(R.id.buttonLogin1);

        buttonRegister1.setOnClickListener(this);
        buttonLogin1.setOnClickListener(this);

    }



    public void onClick(View v) {
        if(v == buttonRegister1){
            startActivity(new Intent(this,Regactivty.class));
        }
       else if(v == buttonLogin1){
            startActivity(new Intent(this,LoginActivity.class));
        }
    }
}