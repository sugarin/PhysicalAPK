package com.brigittachesyapricilla.kelompok2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class gaya extends AppCompatActivity {


    private Button btnhsl, btnsave;
    private EditText massa, kec;
    private TextView simpan,hasil ;
    private Switch switch1;


    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String SWITCH1 = "switch1";

    private String text;
    private boolean switchOnOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaya);

        btnhsl = (Button)findViewById(R.id.hitungBTN);
        massa = (EditText)findViewById(R.id.massaField);
        hasil = (TextView) findViewById(R.id.hasilField);
        simpan = (TextView) findViewById(R.id.simpanField);
        btnsave = (Button) findViewById(R.id.saveBTN);
        switch1 = (Switch) findViewById(R.id.switch1);
        kec = (EditText)findViewById(R.id.gayaField);

        btnhsl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (massa.getText().toString().equals("") || kec.getText().toString().equals(""))
                {
                    Toast.makeText(gaya.this, "Mohon isi kolom terlebih dahulu!", Toast.LENGTH_SHORT).show();
                }
                else {
                    massa.getText().toString();
                    kec.getText().toString();
                    double m= Double.valueOf(massa.getText().toString());
                    double a= Double.valueOf(kec.getText().toString());
                    double gaya;
                    gaya=m*a;
                    hasil.setText(String.valueOf(gaya));
                }

            }
        });


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        loadData();
        updateViews();
    }
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, hasil.getText().toString());
        editor.putBoolean(SWITCH1, switch1.isChecked());

        editor.apply();

        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
    }


    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        switchOnOff = sharedPreferences.getBoolean(SWITCH1, false);
    }

    public void updateViews() {
        simpan.setText(text);
        //switch1.setChecked(switchOnOff);
        switch1.setChecked(true);
        switch1.setVisibility(View.GONE);
    }
}