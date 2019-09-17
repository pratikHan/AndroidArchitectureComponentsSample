package com.bu.architecturecomp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {

        public static final String EXTRA_TITLE = "com.bu.architecturecom.TITLE";
        public static final String EXTRA_DESCRIPTION = "com.bu.architecturecom.DESCRIPTION";
        public static final String EXTRA_PRIORITY = "com.bu.architecturecom.PRIORITY";


    EditText editTextTitle;
    EditText editTextDescription;
    NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);


        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription= findViewById(R.id.edit_text_description);
        numberPicker = findViewById(R.id.number_picker1);


        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Added Note");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return true;


    }

    public void saveNote(){
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        int priority = numberPicker.getValue();


        if(title.trim().isEmpty() | description.trim().isEmpty() ){
            Toast.makeText(this,"Please insert the values",Toast.LENGTH_SHORT).show();

        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE,title);
        data.putExtra(EXTRA_DESCRIPTION,description);
        data.putExtra(EXTRA_PRIORITY,priority);

        setResult(RESULT_OK,data);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.menu_save:
                saveNote();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
