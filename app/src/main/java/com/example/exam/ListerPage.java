package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListerPage extends AppCompatActivity {
    ListView lst;
    MyDatabase db;
    ArrayList<Entreprise> sts;
    Entreprise en;
    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lister_page);
        lst=findViewById(R.id.listViewE);
        db=new MyDatabase(this);
        //Load List View
        sts = MyDatabase.getAllEntreprise(db.getReadableDatabase());

        ArrayList<HashMap<String,Object>> lstItems=new ArrayList<>();
        for(Entreprise c : sts){
            HashMap<String,Object> it=new HashMap<String,Object>();
            it.put("txtRs",c.getRaisonSociale());
            it.put("txC",c.getCapitale());
            lstItems.add(it);
            //nomPays.add(c.getName());
        }
        String[] from={"txtRs","txC"};
        int[] to={R.id.RSLineStructure,R.id.textCapitalLineStructure};
        SimpleAdapter ad = new SimpleAdapter(this,lstItems,R.layout.line_structure,from,to);
        lst.setAdapter(ad);
    }
}