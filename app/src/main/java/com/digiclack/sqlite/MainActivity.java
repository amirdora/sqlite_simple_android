package com.digiclack.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    ListView lv;
    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<String> array = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.add_contact_btn);
        lv = findViewById(R.id.listview);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AddContactActivity.class);
                startActivity(i);
            }
        });

        array = db.getAllContacts();

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);

        lv.setAdapter(adapter);


    }
}
