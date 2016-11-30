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
public class PaymentActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String PAYMENT_URL ="http://codeforproject.16mb.com/payment.php";
    public static final String KEY_USER = "name";
    public static final String KEY_ACCOUNTNUMBER = "accountnumber";
    public static final String KEY_METERNUMBER = "meternumber";
    public static final String KEY_CARD = "cardnumber";
    public static final String KEY_EMAILADDRESS = "emailaddress";
    public static final String KEY_AMOUNT = "amount";
    public static final String KEY_DATE = "date";




    private EditText editTextuser;
    private EditText editTextAccountnumber;
    private EditText editTextMeternumber;
    private EditText editTextCardnumber;
    private EditText editTextEmailaddress;
    private EditText editTextAmount;
    private EditText editTextDate;

    private Button buttonConfirmpay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_activity);

        editTextuser = (EditText) findViewById(R.id.editTextUser);
        editTextAccountnumber = (EditText) findViewById(R.id.editTextAccountnumber);
        editTextMeternumber = (EditText) findViewById(R.id.editTextMeternumber);
        editTextCardnumber = (EditText) findViewById(R.id.editTextCardnumber);
        editTextEmailaddress = (EditText) findViewById(R.id.editTextEmailaddress);
        editTextAmount = (EditText) findViewById(R.id.editTextAmount);
        editTextDate = (EditText) findViewById(R.id.editTextDate);


        buttonConfirmpay = (Button) findViewById(R.id.buttonConfirmpay);

        buttonConfirmpay.setOnClickListener(this);
    }

    private void payment_User(){
        final String name = editTextuser.getText().toString().trim();
        final String accountnumber = editTextAccountnumber.getText().toString().trim();
        final String meternumber = editTextMeternumber.getText().toString().trim();
        final String cardnumber = editTextCardnumber.getText().toString().trim();
        final String emailaddress = editTextEmailaddress.getText().toString().trim();
        final String amount = editTextAmount.getText().toString().trim();
        final String date = editTextDate.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, PAYMENT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(PaymentActivity.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PaymentActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_USER,name);
                params.put(KEY_ACCOUNTNUMBER,accountnumber);
                params.put(KEY_METERNUMBER,meternumber);
                params.put(KEY_CARD,cardnumber);
                params.put(KEY_EMAILADDRESS,emailaddress);
                params.put(KEY_AMOUNT,amount);
                params.put(KEY_DATE,date);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonConfirmpay){
            payment_User();
        }

    }


}
