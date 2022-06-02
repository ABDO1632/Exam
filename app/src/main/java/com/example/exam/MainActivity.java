package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnAjout,btnEditer,btnLister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAjout=findViewById(R.id.btnAjout);
        btnEditer=findViewById(R.id.btnEdite);
        btnLister=findViewById(R.id.btnLister);

        btnAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,AjouterPage.class);

                startActivity(in);
            }
        });
        btnEditer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,EditerPage.class);

                startActivity(in);
            }
        });
        btnLister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,ListerPage.class);
                
                startActivity(in);
            }
        });

    }
}