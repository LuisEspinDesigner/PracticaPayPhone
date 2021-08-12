package com.example.practicapayphone;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.practicapayphone.Model.Regions;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pago extends AppCompatActivity {
    TextInputEditText phoneNumber,countryCode,clientUserId,reference,responseUrl,amount,amountWithTax,amountWithoutTax,tax;

    String AccessToken = "bYccJDpxigaaloMB1xgBFB_hPskGOkla28bYKlJZS4BqrfkutZS734iNNZYK2yO21jNDF_dCa4qL6Hn30wmmwj3ZW8gZUPy8XltRojXc-ILFQo9AFN-jdzAARLGrkufl_qHdX85yuJmDYby5SnW92S-4A0tyiLYkQLyuPbdAT1tPWaJnopEdFqzNI_6CCumCGRJZNcR0fZyr2nuDX9yAokdF8Qt1FShEs_Uk0YFY-2vwSfLjwkxV4wU-nRZW2g9Q1xnhqZQKpP5TnZbXFh1jAJcYXv1PBAx_I7ayEHCCQimDSDvKEcDsOINzjY_GaY8iTGCaEKJrAia8POoRiCzpnbSGQv0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);
        ArrayList<Regions> regions = new ArrayList<Regions>();
        phoneNumber = findViewById(R.id.txtphoneNumber);

    }
}