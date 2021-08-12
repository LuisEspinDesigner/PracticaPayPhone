package com.example.practicapayphone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practicapayphone.Model.Regions;
import com.example.practicapayphone.callApi.Sales;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Pago extends AppCompatActivity {
    TextInputEditText phoneNumber, amount, amountWithTax, amountWithoutTax, tax;
    Button generaPago;
    String AccessToken = "bYccJDpxigaaloMB1xgBFB_hPskGOkla28bYKlJZS4BqrfkutZS734iNNZYK2yO21jNDF_dCa4qL6Hn30wmmwj3ZW8gZUPy8XltRojXc-ILFQo9AFN-jdzAARLGrkufl_qHdX85yuJmDYby5SnW92S-4A0tyiLYkQLyuPbdAT1tPWaJnopEdFqzNI_6CCumCGRJZNcR0fZyr2nuDX9yAokdF8Qt1FShEs_Uk0YFY-2vwSfLjwkxV4wU-nRZW2g9Q1xnhqZQKpP5TnZbXFh1jAJcYXv1PBAx_I7ayEHCCQimDSDvKEcDsOINzjY_GaY8iTGCaEKJrAia8POoRiCzpnbSGQv0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);
        ArrayList<Regions> regions = new ArrayList<Regions>();
        phoneNumber = findViewById(R.id.txtphoneNumber);
        generaPago = findViewById(R.id.btnpagar);
        amount= findViewById(R.id.txtamount);
        Sales sales = new Sales(this,AccessToken);
        generaPago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double monto=  Double.parseDouble(String.valueOf(amount.getText()));
                Double iva= monto*0.12;
                Double montoSinIva = monto-iva;
                String json="{\n" +
                        "  \"phoneNumber\":\""+String.valueOf(phoneNumber.getText())+"\",\n" +
                        "  \"countryCode\": \"593\",\n" +
                        "  \"clientUserId\": \""+String.valueOf(phoneNumber.getText())+"\",\n" +
                        "  \"reference\": \"none\",\n" +
                        "  \"responseUrl\": \"http://paystoreCZ.com/confirm.php\",\n" +
                        "  \"amount\": "+ String.valueOf(amount.getText())+",\n" +
                        "  \"amountWithTax\": "+montoSinIva.toString()+",\n" +
                        "  \"amountWithoutTax\": 0,\n" +
                        "  \"tax\": "+iva.toString()+",\n" +
                        "  \"clientTransactionId\": \"12345\"\n" +
                        "}";
                String res=sales.salesPost(json);
                Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
            }
        });

    }
}