package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText etItem2;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem2 = findViewById(R.id.etItem2);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("edit item");

        etItem2.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));
        // clicked when user is finished editing
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create intent w/ the result
                Intent intent = new Intent();
                // pass results back to MainActivity
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etItem2.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                // set results of intent
                setResult(RESULT_OK, intent);
                // finish activity; return to main
                finish();
            }
        });
    }
}