package com.example.ice.myfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ICE on 2/3/2560.
 */
    //Activity
    public class Myadpter extends BaseAdapter {
    //Explicit
    private Context context ;
    private int[] ints;
    private String [] titleStrings,detailStrings;

   public Myadpter (Context context, int[] ints,String[]titleStrings,String[]detailStrings ){
       this.context = context;
       this.ints = ints;
       this.titleStrings = titleStrings;
       this.detailStrings = detailStrings;
   }

    @Override
    public int getCount() {
        return ints.length;
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
        View View = layoutInflater.inflate(R.layout.my_listview,parent,false);
        //Initial View
        ImageView imageView = (ImageView)   View.findViewById(R.id.imvIcon);
        TextView titleTextView = (TextView) View.findViewById(R.id.txtTitleLiv);
        TextView detalTextView = (TextView) View.findViewById(R.id.txtDetaiLiv);
        //show view

        imageView.setImageResource(ints[position]);
        titleTextView.setText(titleStrings[position]);
        detalTextView.setText(detailStrings[position]);






        return View;
    }
}//Main class


