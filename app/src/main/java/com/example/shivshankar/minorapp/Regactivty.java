package com.example.shivshankar.minorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Regactivty extends AppCompatActivity implements View.OnClickListener {

    private static final String REGISTER_URL ="http://codeforproject.16mb.com/volleyregister.php";
    public static final String KEY_NAME = "name";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_STATE = "state";
    public static final String KEY_ACCOUNT = "account";
    public static final String KEY_METER = "meter";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";


    private EditText editTextName;
    private EditText editTextAddress;
    private EditText editTextPhone;
    private EditText editTextState;
    private EditText editTextAccount;
    private EditText editTextMeter;
    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPassword;

    private Button buttonRegister2;
    private Button buttonLogin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regactivty);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextState = (EditText) findViewById(R.id.editTextState);
        editTextAccount = (EditText) findViewById(R.id.editTextAccount);
        editTextMeter = (EditText) findViewById(R.id.editTextMeter);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextEmail= (EditText) findViewById(R.id.editTextEmail);

        buttonRegister2 = (Button) findViewById(R.id.buttonRegister2);
        buttonLogin2 = (Button) findViewById(R.id.buttonLogin2);

        buttonRegister2.setOnClickListener(this);
        buttonLogin2.setOnClickListener(this);
    }

    private void registerUser(){
        final String name = editTextName.getText().toString().trim();
        final String address = editTextAddress.getText().toString().trim();
        final String phone = editTextPhone.getText().toString().trim();
        final String state = editTextState.getText().toString().trim();
        final String account = editTextAccount.getText().toString().trim();
        final String meter = editTextMeter.getText().toString().trim();
        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Regactivty.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Regactivty.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_NAME,name);
                params.put(KEY_ADDRESS,address);
                params.put(KEY_PHONE,phone);
                params.put(KEY_STATE,state);
                params.put(KEY_ACCOUNT,account);
                params.put(KEY_METER,meter);
                params.put(KEY_USERNAME,username);
                params.put(KEY_PASSWORD,password);
                params.put(KEY_EMAIL, email);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    @Override
    public void onClick(View v) {
        if(v == buttonRegister2){
            registerUser();
        }
        if(v == buttonLogin2){
            startActivity(new Intent(this,LoginActivity.class));
        }
    }



}
