package com.logicshore.sqlitelistview;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button submit;
    ListView listitem;

    DataHandler db;
    ArrayList<ListPojo> listarray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        submit=(Button)findViewById(R.id.submit);
        listitem=(ListView)findViewById(R.id.listitem);
        db = new DataHandler(this);
        listarray= new ArrayList<>();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db.insert(1,username.getText().toString(),password.getText().toString());

                Cursor c= db.getAllContacts();
                while (c.moveToNext()){
                    Log.d("Username",c.getString(1));
                    ListPojo listpojo= new ListPojo();// Base Adaptor
                    listpojo.setUsername(c.getString(1));
                    listpojo.setPassword(c.getString(2));
                    listarray.add(listpojo);

                   // CustomListAdapter cla= new CustomListAdapter(MainActivity.this,listarray);// this is for Base Adaptor
                    CustomListAdapter cla= new CustomListAdapter(MainActivity.this,c);// used for Cursor Adaptor
                    listitem.setAdapter(cla);
                }

            }
        });
    }
}
