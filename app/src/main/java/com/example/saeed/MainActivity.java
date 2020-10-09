package com.example.saeed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.saeed.Model.MovieFactory;
import com.example.saeed.Model.iMovie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner geners;
    CheckBox CB1, CB2, CB3;
    EditText ed1, ed2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        geners = findViewById(R.id.spinner);
        CB1 = findViewById(R.id.checkBox);
        CB2 = findViewById(R.id.checkBox2);
        CB3 = findViewById(R.id.checkBox3);
        ed1 = findViewById(R.id.editName);
        ed2 = findViewById(R.id.editTextNumber);
        tv = findViewById(R.id.textView);
        MovieFactory MF = new MovieFactory();
        iMovie Movie = MF.getModel();
        String[] g = Movie.getGeners();
        ArrayAdapter<String> GA = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, g);
        geners.setAdapter(GA);
    }

    public void cb1OnClick(View view) {
        CB2.setChecked(false);
        CB3.setChecked(false);
    }

    public void cb2OnClick(View view) {
        CB1.setChecked(false);
        CB3.setChecked(false);
    }

    public void cb3OnClick(View view) {
        CB2.setChecked(false);
        CB1.setChecked(false);
    }

    public void searchOnClick(View view) {
        MovieFactory MF = new MovieFactory();
        iMovie Movie = MF.getModel();
        String results;
        if (CB1.isChecked()) {
            results = Movie.SearchByTitle(ed1.getText().toString());
            tv.setText(results);
        } else if (CB2.isChecked()) {
            results = Movie.SearchBYYear(Integer.parseInt(ed2.getText().toString()));
            tv.setText(results);
        } else if (CB3.isChecked()) {
            results = Movie.SearchByGeners(geners.getSelectedItem().toString());
            tv.setText(results);
        }
        else {
            tv.setText("Please check a search method");
        }
    }
}