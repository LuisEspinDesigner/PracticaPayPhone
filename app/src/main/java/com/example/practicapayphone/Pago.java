package com.example.practicapayphone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practicapayphone.Model.Regions;
import com.example.practicapayphone.callApi.Sales;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Pago extends AppCompatActivity {
    TextInputEditText phoneNumber, countryCode, clientUserId, reference, responseUrl, amount, amountWithTax, amountWithoutTax, tax;
    Button generaPago;
    String AccessToken = "bYccJDpxigaaloMB1xgBFB_hPskGOkla28bYKlJZS4BqrfkutZS734iNNZYK2yO21jNDF_dCa4qL6Hn30wmmwj3ZW8gZUPy8XltRojXc-ILFQo9AFN-jdzAARLGrkufl_qHdX85yuJmDYby5SnW92S-4A0tyiLYkQLyuPbdAT1tPWaJnopEdFqzNI_6CCumCGRJZNcR0fZyr2nuDX9yAokdF8Qt1FShEs_Uk0YFY-2vwSfLjwkxV4wU-nRZW2g9Q1xnhqZQKpP5TnZbXFh1jAJcYXv1PBAx_I7ayEHCCQimDSDvKEcDsOINzjY_GaY8iTGCaEKJrAia8POoRiCzpnbSGQv0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);
        ArrayList<Regions> regions = new ArrayList<Regions>();
        phoneNumber = findViewById(R.id.txtphoneNumber);
        generaPago = findViewById(R.id.btnpagar);
        Sales sales = new Sales(this,AccessToken);
        generaPago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json="" +
                        "";
                sales.salesPost(json);
            }
        });

    }
}