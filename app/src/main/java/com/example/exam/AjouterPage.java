package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjouterPage extends AppCompatActivity {
    Button btnAnnuler,btnEnregitrez;
    EditText txtRS,txtAdresse,txtCapital;
    MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_page);
        db=new MyDatabase(this);

        txtRS=findViewById(R.id.ajoutRaisonS);
        txtAdresse=findViewById(R.id.ajoutadresse);
        txtCapital=findViewById(R.id.ajoutCapital);


        btnAnnuler=findViewById(R.id.ajoutBtnAnnuler);
        btnEnregitrez=findViewById(R.id.ajoutBtnEnregistrez);
        btnAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnEnregitrez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Entreprise pr1=new Entreprise(txtRS.getText().toString(),txtAdresse.getText().toString(),Double.valueOf(txtCapital.getText().toString()));
                long r=MyDatabase.AddEntreprise(db.getWritableDatabase(),pr1);

                if(r!=-1){
                    Toast.makeText(getApplicationContext(),"Insertion Reussie",Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getApplicationContext(),"Insertion Echoue",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}