package com.example.non_jid.tabapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class ListActivity extends AppCompatActivity {

    //Explicit
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Bind Widget
        listView = (ListView) findViewById(R.id.lvShop);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, NewAddMap.class);
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Test List View

//        String[] testStrings = new String[]{"test1", "test2", "test3", "test4", "test5"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, testStrings);
//        listView.setAdapter(adapter);

        //Call AsyncTask
        SynShopCenter synShopCenter = new SynShopCenter(this, listView);
        synShopCenter.execute();


    }   // Main Method

    private class SynShopCenter extends AsyncTask<Void, Void, String> {

        //Explicit
        private Context context;
        private ListView synListView;
        private String[] shopStrings, addressStrings, promoteStrings,
                phoneStrings, latStrings, lngStrings;
        private static final String urlJSON = "http://swiftcodingthai.com/non/getdata_shop.php";

        public SynShopCenter(Context context,
                             ListView synListView) {
            this.context = context;
            this.synListView = synListView;
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlJSON).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();


            } catch (Exception e) {
                return null;
            }

        }   // doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("22JulyV1", "JSON ==> " + s);

            try {

                JSONArray jsonArray = new JSONArray(s);

                shopStrings = new String[jsonArray.length()];
                addressStrings = new String[jsonArray.length()];
                promoteStrings = new String[jsonArray.length()];
                phoneStrings = new String[jsonArray.length()];
                latStrings = new String[jsonArray.length()];
                lngStrings = new String[jsonArray.length()];

                for (int i=0;i<jsonArray.length();i+=1) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    shopStrings[i] = jsonObject.getString("Shop");
                    addressStrings[i] = jsonObject.getString("Address");
                    promoteStrings[i] = jsonObject.getString("Promote");
                    phoneStrings[i] = jsonObject.getString("Phone");
                    latStrings[i] = jsonObject.getString("Lat");
                    lngStrings[i] = jsonObject.getString("Lng");

                }   // for

                //Create ListView
                MyAdapter myAdapter = new MyAdapter(context,
                        shopStrings, phoneStrings, promoteStrings);
                synListView.setAdapter(myAdapter);


                synListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(ListActivity.this, ShowDetailActivity.class);
                        intent.putExtra("Shop", shopStrings[position]);
                        intent.putExtra("Address", addressStrings[position]);
                        intent.putExtra("Phone", phoneStrings[position]);
                        intent.putExtra("Promote", promoteStrings[position]);
                        intent.putExtra("Lat", latStrings[position]);
                        intent.putExtra("Lng", lngStrings[position]);
                        startActivity(intent);

                    }// onItemClick
                });


            } catch (Exception e) {
                e.printStackTrace();
            }

        }   // onPost

    }   // SynShopCenter Class

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_listview, menu);
        return super.onCreateOptionsMenu(menu);
    }
}   // Main Class