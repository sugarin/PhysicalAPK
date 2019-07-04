package com.brigittachesyapricilla.kelompok2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button menuKec, menuGay, menuPer, Exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuKec = (Button) findViewById(R.id.KecepatanID);
        menuGay = (Button) findViewById(R.id.GayaID);
        menuPer = (Button) findViewById(R.id.PercepatanID);
        Exit = (Button) findViewById(R.id.Exit) ;

        menuKec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kecepatan();
            }
        });

        menuGay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Gaya();
            }
        });
//
        menuPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Percepatan();
            }
        });

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
            }
        });
    }
    public void Kecepatan(){
        Intent intent = new Intent(this, kecepatan.class);
        startActivity(intent);
  }

    public void Gaya(){
        Intent intent = new Intent(this, gaya.class);
        startActivity(intent);
    }

    public void Percepatan(){
        Intent intent = new Intent(this, percepatan.class);
        startActivity(intent);
    }

    public void Exit() {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}