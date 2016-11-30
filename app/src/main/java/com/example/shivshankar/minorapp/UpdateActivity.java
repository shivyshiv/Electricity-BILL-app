package com.example.shivshankar.minorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

/**
 * Created by shivshankar on 02-10-2016.
 */
public class UpdateActivity extends AppCompatActivity implements View.OnClickListener{


    private static final String UPDATE_URL ="http://codeforproject.16mb.com/update.php";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_NAME = "name";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_STATE = "state";
    public static final String KEY_ACCOUNT = "account";
    public static final String KEY_METER = "meter";
    public static final String KEY_EMAIL = "email";



    private EditText editTextUsername;
    private EditText editTextName;
    private EditText editTextAddress;
    private EditText editTextPhone;
    private EditText editTextState;
    private EditText editTextAccount;
    private EditText editTextMeter;
    private EditText editTextEmail;


    private Button buttonSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_activity);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextState = (EditText) findViewById(R.id.editTextState);
        editTextAccount = (EditText) findViewById(R.id.editTextAccount);
        editTextMeter = (EditText) findViewById(R.id.editTextMeter);
        editTextEmail= (EditText) findViewById(R.id.editTextEmail);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);

        buttonSave = (Button) findViewById(R.id.buttonSave);


        buttonSave.setOnClickListener(this);

    }

    private void Upadte_User(){

        final String username = editTextUsername.getText().toString().trim();
        final String name = editTextName.getText().toString().trim();
        final String address = editTextAddress.getText().toString().trim();
        final String phone = editTextPhone.getText().toString().trim();
        final String state = editTextState.getText().toString().trim();
        final String account = editTextAccount.getText().toString().trim();
        final String meter = editTextMeter.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, UPDATE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(UpdateActivity.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateActivity.this,error.toString(),Toast.LENGTH_LONG).show();
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
                params.put(KEY_EMAIL, email);
                params.put(KEY_USERNAME,username );
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonSave){
            Upadte_User();
        }

    }




}
