package com.digiclack.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {

    EditText nameEdt;
    Button btnAdd;
    DatabaseHandler db = new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        btnAdd = findViewById(R.id.save_btn);
        nameEdt = findViewById(R.id.name_edt);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db.addContact(nameEdt.getText().toString());

                Intent i = new Intent(AddContactActivity.this,MainActivity.class);
                startActivity(i);

            }
        });
    }
}
