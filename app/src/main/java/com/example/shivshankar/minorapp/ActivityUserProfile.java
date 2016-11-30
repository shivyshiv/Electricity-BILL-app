package com.example.shivshankar.minorapp;

/**
 * Created by shivshankar on 28-09-2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public  class ActivityUserProfile extends AppCompatActivity implements View.OnClickListener {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private Button buttonPay;
    private Button buttonUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofile);

        textView1 = (TextView) findViewById(R.id.textViewUsername);
        textView2 = (TextView) findViewById(R.id.textViewBill);
        textView3 = (TextView) findViewById(R.id.textViewDue);
        textView4 = (TextView) findViewById(R.id.textViewDischarge);

        Intent intent = getIntent();

        textView1.setText("Welcome User " + intent.getStringExtra(LoginActivity.KEY_USERNAME));

        textView2.setText("Rs.1852 ");
        textView3.setText("10/0/2016");
        textView4.setText("20/10/2016");



        buttonPay = (Button) findViewById(R.id.Pay);
        buttonUpdate = (Button) findViewById(R.id.Update);
        buttonPay.setOnClickListener(this);
        buttonUpdate.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v == buttonUpdate){
            startActivity(new Intent(this,UpdateActivity.class));
        }
        if(v == buttonPay){
            startActivity(new Intent(this,Paypalpayment.class));
        }
    }




}