package com.example.non_jid.tabapp;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Test ListView

//        String[] testStrings = new String(){"test1","test2","test3","test4","test5"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, testStrings);
//                listView.setAdapter(adapter);


        //Call AsyncTask
        SynShopCenter synShopCenter = new SynShopCenter(this, listView);
        synShopCenter.execute();


    }//Main Method

    private class SynShopCenter extends AsyncTask<Void, Void, String> {

        //Explicit
        private Context context;
        private ListView synListView;
        private String[]shopStrings, addressStrings, promoteStrings, phoneStrings, latStrings, lngStrings;
        private static final String urlJSON = "http://swiftcodingthai.com/non/getdata_shop.php";

        public SynShopCenter(Context context, ListView synListView) {
            this.context = context;
            this.synListView = synListView;
        }

        @Override
        protected String doInBackground(Void... params) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlJSON).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();


            } catch (Exception e) {
                return null;
            }

        }//doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("22JulyV1", "JSON ==> " + s);

        }//onPost

    }//SynShopCenter Class



}//Main class
