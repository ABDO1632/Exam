package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditerPage extends AppCompatActivity {
    Button btnModifier,btnAnuler;
    EditText txtRS,txtAdresse,txtCapital;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editer_page);
        btnAnuler=findViewById(R.id.editBtnA);
        btnAnuler=findViewById(R.id.editBtnM);
        txtRS=findViewById(R.id.editRaisonS);
        txtAdresse=findViewById(R.id.editadresse);
        txtCapital=findViewById(R.id.editCapital);
        btnModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnAnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}