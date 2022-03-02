package com.example.sqlitetutorial.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sqlitetutorial.R;
import com.example.sqlitetutorial.database.DatabaseHelper;
import com.example.sqlitetutorial.model.Note;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        databaseHelper = new DatabaseHelper(this);

        Button btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.insertNote("PDP Academy");
                List<Note> notes = databaseHelper.getAllNotes();
                Log.d("@@@", "onClick:" + notes);
            }
        });
    }
}
