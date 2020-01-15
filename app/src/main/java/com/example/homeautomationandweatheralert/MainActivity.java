package com.example.homeautomationandweatheralert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.homeautomationandweatheralert.App.CHANNEL_1_ID;

public class MainActivity extends AppCompatActivity {
    Handler mainHandler;
    Button lightButton,fanButton,doorButton;
    TextView temparatureTextView,skyTextView,humidityTextView,airQualityTextView;
    Button graphIntentButton;
    MediaPlayer mediaPlayer;
    NotificationManager notificationManager;
    static boolean not=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainHandler= new Handler();

        /*Intent Buttons */
        graphIntentButton = findViewById(R.id.graph_intent_button);
        /* Audio initialization */
        mediaPlayer = MediaPlayer.create(this,R.raw.s1);


        /* text view initialization */
        temparatureTextView = findViewById(R.id.temperature_text_view);
        skyTextView = findViewById(R.id.sky_text_view);
        humidityTextView = findViewById( R.id.humidity_text_view);
        airQualityTextView = findViewById(R.id.air_quality_text_view);

        /* Button initialization */
        lightButton = findViewById(R.id.light_button);
        fanButton = findViewById(R.id.fan_button);
        doorButton = findViewById( R.id.door_button);
        lightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
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
                        int l=light==0?1:0;
                        Map<String,String> params = new HashMap<>();
                        params.put("apiKey","1999");
                        params.put("light",l+"");
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

        fanButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
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
                        int f=fan==0?1:0;
                        Map<String,String> params = new HashMap<>();
                        params.put("apiKey","1999");
                        params.put("fan",f+"");
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

        doorButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
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
                        int d=door==0?1:0;
                        Map<String,String> params = new HashMap<>();
                        params.put("apiKey","1999");
                        params.put("door",d+"");
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
        mainHandler.postDelayed(runnable,1000);
        graphIntentButton.setOnClickListener(graphIntentButtonListener);

    }
    OnClickListener graphIntentButtonListener = new OnClickListener()
    {

        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(),Graphs.class));
        }
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            updateWeather();
            mainHandler.postDelayed(runnable,1000);
        }
    };
    public void updateWeather()
    {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url =  "https://avijit666666.000webhostapp.com/HAW/api.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            JSONObject data= jsonArray.getJSONObject(jsonArray.length()-1);
                            temparatureTextView.setText(data.getString("temerature")+"°C");
                            if(not)
                            {
                               if(Float.parseFloat(data.getString("temperature"))>30)
                               {
                                   sendOnChannel1("Home","temperature is too high");
                                   not=true;
                               }

                            }
                            else {

                            }
                            String rain=data.getString("raindrop");
                            if((""+rain.charAt(0)).equalsIgnoreCase("0"))
                            {
                                skyTextView.setText("Rainy");
                            }
                            else if((""+rain.charAt(0)).equalsIgnoreCase("1"))
                            {
                                skyTextView.setText("Cloudy");
                            }
                            else if((""+rain.charAt(0)).equalsIgnoreCase("2"))
                            {
                                skyTextView.setText("Sunny");
                            }

                            humidityTextView.setText("Humidity: "+data.getString("humidity")+"%");
                            airQualityTextView.setText("Co2: "+data.getString("co")+"PPM");

                        }catch (Exception e)
                        {

                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        )
        {
            protected Map<String,String> getParams()
            {
                Map<String,String> params = new HashMap<>();
                params.put("apiKey","1999");
                params.put("weather","1");
                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers = new HashMap<>();
                headers.put("Content-Type","application/json");
                headers.put("Content-Type","application/x-www-form-urlencoded");
                return headers;
            }
        };
        requestQueue.add(stringRequest);
    }
    public void sendOnChannel1(String title,String message) {

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);
    }

    @Override
    public void onBackPressed() {
        alertDialog();

    }
    public void alertDialog()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to close this app?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
