package com.logicshore.sqlitelistview;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by admin on 19-01-2018.
 */

//class CustomListAdapter extends BaseAdapter {
//    Context context;
//    ArrayList<ListPojo> listPojos;
//    public CustomListAdapter(MainActivity mainActivity, ArrayList<ListPojo> listarray) {
//        context=mainActivity;
//        listPojos=listarray;
//    }
//
//    @Override
//    public int getCount() {
//        return listPojos.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return listPojos.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int i, View convertView, ViewGroup viewGroup) {
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.listadadapter, viewGroup, false);
//        }
//
//        // get current item to be displayed
//        ListPojo currentItem = (ListPojo) getItem(i);
//
//        // get the TextView for item name and item description
//        TextView textViewItemName = (TextView) convertView.findViewById(R.id.usernametext);
//        TextView textViewItemDescription = (TextView) convertView.findViewById(R.id.passwordtext);
//
//        //sets the text for item name and item description from the current item object
//        textViewItemName.setText(currentItem.getUsername());
//        textViewItemDescription.setText(currentItem.getPassword());
//
//        // returns the view for the current row
//        return convertView;
//    }
//    }

public class CustomListAdapter extends CursorAdapter{


    public CustomListAdapter(Context context, Cursor c) {
        super(context, c,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.listadadapter, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textViewItemName = (TextView) view.findViewById(R.id.usernametext);
        TextView textViewItemDescription = (TextView) view.findViewById(R.id.passwordtext);

        //sets the text for item name and item description from the current item object
        textViewItemName.setText(cursor.getString(1));
        textViewItemDescription.setText(cursor.getString(2));


    }
}

