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

public class kecepatan extends AppCompatActivity {
    private Button btnhsl, btnsave;
    private EditText jarak, waktu ;
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
        setContentView(R.layout.activity_kecepatan);

        btnhsl = (Button)findViewById(R.id.hitungBTN);
        jarak = (EditText)findViewById(R.id.jarakField);
        waktu = (EditText)findViewById(R.id.waktuField);
        hasil = (TextView) findViewById(R.id.hasilField);
        simpan = (TextView) findViewById(R.id.simpanField);
        btnsave = (Button) findViewById(R.id.saveBTN);
        switch1 = (Switch) findViewById(R.id.switch1);

        btnhsl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jarak.getText().toString().equals("") || waktu.getText().toString().equals(""))
                {
                    Toast.makeText(kecepatan.this, "Mohon isi kolom terlebih dahulu!", Toast.LENGTH_SHORT).show();
                }
                else {
                    jarak.getText().toString();
                    waktu.getText().toString();
                    double s= Double.valueOf(jarak.getText().toString());
                    double t= Double.valueOf(waktu.getText().toString());
                    double kec;
                    kec=s/t;
                    hasil.setText(String.valueOf(kec));
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