package com.siddevlops.asynctest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new TaskUpdateis_live().execute();
                doStuff();
            }
        });
    }


    class TaskUpdateis_live extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                JSONObject jsonBody = new JSONObject();
                jsonBody.put("userId","43");

                Log.i("jsonbodyy",jsonBody+"");
                JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST,
                        "https://app.careerguide.com/api/main/"+"updateislive"
                        /*sids created api*/,jsonBody, response -> {
                    try {
                        JSONObject jsonObject = new JSONObject(response+"");
                        Log.i("response->",jsonObject+"");
                        boolean status = jsonObject.optBoolean("status");
                        if (status) {
                            Log.i("is_online","is_online in Database");
                        } else {
                            Log.i("is_online","is_online called failed");

                            Toast.makeText(getApplicationContext(), "Something went wrong.", Toast.LENGTH_LONG).show();
                        }
                        //pb_loading.setVisibility(View.GONE);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
                    // pb_loading.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), VoleyErrorHelper.getMessage(error, getApplicationContext()), Toast.LENGTH_LONG).show();

                    Log.e("is_online", "is_online error");

                    error.printStackTrace();
                }) {
                    @Override
                    public Map<String, String> getHeaders() {
                        HashMap<String, String> headers = new HashMap<>();
                        headers.put("Content-Type", "application/json");
                        headers.put("Authorization",
                                "Basic ZTg1YWQyZjg3Mzc0NDc5ZWE5ZjZhMTE0MmY5NTRjZjc6YjdiZTUxM2Q4ZDI0NGFiNWFlYWU0ZWQxNWYwZDIyNWM=");
                        return headers;
                    }
                };
                VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }

    private void doStuff(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                // first work(w1)     //

                try {
                    JSONObject jsonBody = new JSONObject();
                    jsonBody.put("userId","43");

                    Log.i("jsonbodyy",jsonBody+"");
                    JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST,
                            "https://app.careerguide.com/api/main/"+"updateislive"
                            /*sids created api*/,jsonBody, response -> {
                        try {
                            JSONObject jsonObject = new JSONObject(response+"");
                            Log.i("response->",jsonObject+"");
                            boolean status = jsonObject.optBoolean("status");
                            if (status) {
                                Log.i("is_online","is_online in Database");
                            } else {
                                Log.i("is_online","is_online called failed");

                                Toast.makeText(getApplicationContext(), "Something went wrong.", Toast.LENGTH_LONG).show();
                            }
                            //pb_loading.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }, error -> {
                        // pb_loading.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), VoleyErrorHelper.getMessage(error, getApplicationContext()), Toast.LENGTH_LONG).show();

                        Log.e("is_online", "is_online error");

                        error.printStackTrace();
                    }) {
                        @Override
                        public Map<String, String> getHeaders() {
                            HashMap<String, String> headers = new HashMap<>();
                            headers.put("Content-Type", "application/json");
                            headers.put("Authorization",
                                    "Basic ZTg1YWQyZjg3Mzc0NDc5ZWE5ZjZhMTE0MmY5NTRjZjc6YjdiZTUxM2Q4ZDI0NGFiNWFlYWU0ZWQxNWYwZDIyNWM=");
                            return headers;
                        }
                    };
                    VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

                }catch (Exception e){
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // doing job after w1 is finished //
                        Toast.makeText(getApplicationContext(),"work is completed of w2",Toast.LENGTH_SHORT).show();

                        /**try {
                            JSONObject jsonBody = new JSONObject();
                            jsonBody.put("userId","43");

                            Log.i("jsonbodyy",jsonBody+"");
                            JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST,
                                    "https://app.careerguide.com/api/main/"+"updateislive"
                                    /*sids created api,jsonBody, response -> {
                                try {
                                    JSONObject jsonObject = new JSONObject(response+"");
                                    Log.i("response->",jsonObject+"");
                                    boolean status = jsonObject.optBoolean("status");
                                    if (status) {
                                        Log.i("is_online","is_online in Database");
                                    } else {
                                        Log.i("is_online","is_online called failed");

                                        Toast.makeText(getApplicationContext(), "Something went wrong.", Toast.LENGTH_LONG).show();
                                    }
                                    //pb_loading.setVisibility(View.GONE);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }, error -> {
                                // pb_loading.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(), VoleyErrorHelper.getMessage(error, getApplicationContext()), Toast.LENGTH_LONG).show();

                                Log.e("is_online", "is_online error");

                                error.printStackTrace();
                            }) {
                                @Override
                                public Map<String, String> getHeaders() {
                                    HashMap<String, String> headers = new HashMap<>();
                                    headers.put("Content-Type", "application/json");
                                    headers.put("Authorization",
                                            "Basic ZTg1YWQyZjg3Mzc0NDc5ZWE5ZjZhMTE0MmY5NTRjZjc6YjdiZTUxM2Q4ZDI0NGFiNWFlYWU0ZWQxNWYwZDIyNWM=");
                                    return headers;
                                }
                            };
                            VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

                        }catch (Exception e){
                            e.printStackTrace();
                        }**/
                    }
                });
            }
        }).start();

    }

}