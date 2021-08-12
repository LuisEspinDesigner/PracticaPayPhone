package com.example.practicapayphone.callApi;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class Sales {
    Context ctn;
    public Sales(Context context) {
        this.ctn=context;
    }

    public String salesPost(String AccessToken, String jsonModel){
        String UrlRegions = "https://pay.payphonetodoesposible.com/api/Sale";
        StringRequest llamado = new StringRequest(Request.Method.POST, UrlRegions, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    try {
                        JSONArray ArrayJson = new JSONArray(response);
                        Log.i("res", ArrayJson.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error is ", "" + error);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Authorization", "Bearer " + AccessToken);
                return params;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("model",jsonModel);
                return params;
            }
        };
        RequestQueue ejecVolley = Volley.newRequestQueue(ctn);
        ejecVolley.add(llamado);
        return "";
    }
}
