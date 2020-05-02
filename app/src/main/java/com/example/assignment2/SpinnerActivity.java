package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private List<String> sweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        spinner = findViewById(R.id.spinnerSweets);
        setSpinnerSource();
        spinner.setAdapter(getSpinnerAdapter());
        spinner.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    private void setSpinnerSource() {
        sweets = new ArrayList<>();
        sweets.add(getString(R.string.cupcake));
        sweets.add(getString(R.string.donut));
        sweets.add(getString(R.string.eclair));
        sweets.add(getString(R.string.kitkat));
        sweets.add(getString(R.string.pie));
    }

    private ArrayAdapter<String> getSpinnerAdapter() {
        return new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sweets);
    }
}
