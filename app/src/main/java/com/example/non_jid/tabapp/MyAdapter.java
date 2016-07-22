package com.example.non_jid.tabapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Non_jid on 22/7/2559.
 */
public class MyAdapter extends BaseAdapter{

    //Explicit

    private Context context;
    private String [] shopStrings, phoneStrings, promoteStrings;

    public MyAdapter(Context context,
                     String[] shopStrings,
                     String[] phoneStrings,
                     String[] promoteStrings) {
        this.context = context;
        this.shopStrings = shopStrings;
        this.phoneStrings = phoneStrings;
        this.promoteStrings = promoteStrings;
    }

    @Override
    public int getCount() {
        return shopStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.my_listview, parent, false);

        //Bind Widget
        TextView shopTextView = (TextView) view.findViewById(R.id.txShop);
        TextView phoneTextView = (TextView) view.findViewById(R.id.txPhone);
        TextView promoteTextView = (TextView) view.findViewById(R.id.txPromote);

        //Show Text
        shopTextView.setText(shopStrings[position]);
        phoneTextView.setText(phoneStrings[position]);

        String shortPromote = promoteStrings[position].substring(0, 30) + "...";
        promoteTextView.setText(shortPromote);

        return view;
    }
}//Main Class
