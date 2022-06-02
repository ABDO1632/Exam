package com.example.exam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EditerPage extends AppCompatActivity {
    Button btnModifier,btnSupprimer;
    EditText txtRS,txtAdresse,txtCapital;
    MyDatabase db;
    Entreprise en;
    Spinner sp;
    ArrayList<Entreprise> sts;
    ArrayAdapter ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editer_page);
        db=new MyDatabase(this);
        sp=findViewById(R.id.editSpinner);
        btnSupprimer=findViewById(R.id.editBtnA);
        btnModifier=findViewById(R.id.editBtnM);
        txtRS=findViewById(R.id.editRaisonS);
        txtAdresse=findViewById(R.id.editadresse);
        txtCapital=findViewById(R.id.editCapital);
        //Load Spinner
        sts = MyDatabase.getAllEntreprise(db.getReadableDatabase());
        ArrayList<String> noms=new ArrayList<>();
        for(Entreprise s:sts) {
            noms.add(s.getRaisonSociale()) ;
        }
        ad = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,noms);
        sp.setAdapter(ad);
        //
        btnModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long r=MyDatabase.UpdateEntreprise(db.getWritableDatabase(),en);

                if(r!=-1){
                    Toast.makeText(getApplicationContext(),"Update Reussie"+en.getID(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Update Echoue",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert =new AlertDialog.Builder(EditerPage.this);
                alert.setTitle("Boite 1");
                alert.setMessage("Message avec un seul button ");
                alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        long r=MyDatabase.DeleteEntreprise(db.getWritableDatabase(),en.getID());

                        if(r!=-1){
                            Toast.makeText(getApplicationContext(),"Delete Reussie"+en.getID(),Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(getApplicationContext(),"Delete Echoue",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                alert.show();


            }
        });
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                en=sts.get(i);
                txtRS.setText(String.valueOf(en.getRaisonSociale()));
                txtAdresse.setText(String.valueOf(en.getAdresse()));
                txtCapital.setText(String.valueOf(en.getCapitale()));

                Toast.makeText(EditerPage.this, String.valueOf(en.getRaisonSociale()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}