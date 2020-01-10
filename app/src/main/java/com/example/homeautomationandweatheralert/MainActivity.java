package com.example.homeautomationandweatheralert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button lightButton,fanButton,doorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightButton = findViewById(R.id.light_button);
        fanButton = findViewById(R.id.fan_button);
        doorButton = findViewById( R.id.door_button);
        lightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String status=lightButton.getText().toString();
                final int light = status.equalsIgnoreCase("ON")?0:1;
                if(light==0)
                {
                    lightButton.setText("OFF");
                }
                else
                {
                    lightButton.setText("ON");
                }
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url = "https://avijit666666.000webhostapp.com/HAW/api.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //light==0?lightButton.setText("OFF"):lightButton.setText("ON");

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {


                            }
                        })
                {
                    protected Map<String,String> getParams()
                    {
                        Map<String,String> params = new HashMap<>();
                        params.put("apiKey","1999");
                        params.put("light",light+"");
                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap headers= new HashMap();
                        headers.put("Content-Type","application/json");
                        headers.put("Content-Type","application/x-www-form-urlencoded");
                        return headers;
                    }
                };
                queue.add(stringRequest);
            }
        });

        fanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String status=fanButton.getText().toString();
                final int fan = status.equalsIgnoreCase("ON")?0:1;
                if(fan==0)
                {
                    fanButton.setText("OFF");
                }
                else
                {
                    fanButton.setText("ON");
                }
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url = "https://avijit666666.000webhostapp.com/HAW/api.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //light==0?lightButton.setText("OFF"):lightButton.setText("ON");

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {


                            }
                        })
                {
                    protected Map<String,String> getParams()
                    {
                        Map<String,String> params = new HashMap<>();
                        params.put("apiKey","1999");
                        params.put("fan",fan+"");
                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap headers= new HashMap();
                        headers.put("Content-Type","application/json");
                        headers.put("Content-Type","application/x-www-form-urlencoded");
                        return headers;
                    }
                };
                queue.add(stringRequest);
            }
        });

        doorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String status=doorButton.getText().toString();
                final int door = status.equalsIgnoreCase("ON")?0:1;
                if(door==0)
                {
                    doorButton.setText("OFF");
                }
                else
                {
                    doorButton.setText("ON");
                }
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url = "https://avijit666666.000webhostapp.com/HAW/api.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //light==0?lightButton.setText("OFF"):lightButton.setText("ON");

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {


                            }
                        })
                {
                    protected Map<String,String> getParams()
                    {
                        Map<String,String> params = new HashMap<>();
                        params.put("apiKey","1999");
                        params.put("door",door+"");
                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap headers= new HashMap();
                        headers.put("Content-Type","application/json");
                        headers.put("Content-Type","application/x-www-form-urlencoded");
                        return headers;
                    }
                };
                queue.add(stringRequest);
            }
        });

    }
}
