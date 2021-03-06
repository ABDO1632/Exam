package com.example.exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    public  final  static String Nom_Db="enterprises.db";
    public  final  static String Nom_Table="Enterprise";
    public static final String COLId = "id";
    public  final  static String ColRaisonSociale="RaisonSociale";
    public  final  static String ColAdresse="Adresse";
    public  final  static String ColCapitale="Capitale";
    public MyDatabase(Context c){
        super(c,Nom_Db,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table "+Nom_Table+" ("+COLId+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ ColRaisonSociale + " TEXT, " +ColAdresse + " TEXT, "+ColCapitale+ " DOUBLE )";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS  "+Nom_Table);
        onCreate(sqLiteDatabase);
    }

    //Create
    public static long AddEntreprise(SQLiteDatabase sqLiteDatabase,Entreprise ct){
        ContentValues c=new ContentValues();
        c.put(ColRaisonSociale,ct.getRaisonSociale());
        c.put(ColAdresse,ct.getAdresse());
        c.put(ColCapitale,ct.getCapitale());
        return sqLiteDatabase.insert(Nom_Table,null,c);
    }
    //Update
    public static long UpdateEntreprise(SQLiteDatabase sqLiteDatabase,Entreprise ct){
        ContentValues c = new ContentValues();
        c.put(ColRaisonSociale,ct.getRaisonSociale());
        c.put(ColAdresse,ct.getAdresse());
        c.put(ColCapitale,ct.getCapitale());
        long result = sqLiteDatabase.update(MyDatabase.Nom_Table,c,"id = "+ct.getID(),null);
        sqLiteDatabase.close();
        return result;
    }
    //Delete
    public static long DeleteEntreprise(SQLiteDatabase sqLiteDatabase,int id){
        long result = sqLiteDatabase.delete(Nom_Table,"id = "+id,null);
        sqLiteDatabase.close();
        return result;
    }
    //FindAll
    public static ArrayList<Entreprise> getAllEntreprise(SQLiteDatabase sqLiteDatabase){
        ArrayList<Entreprise> entr=new ArrayList<>();
        Cursor cr=sqLiteDatabase.rawQuery("Select * from "+Nom_Table,null);
        while (cr.moveToNext())
        {
            Entreprise e=new Entreprise();
            e.setID(cr.getInt(0));
            e.setRaisonSociale(cr.getString(1));
            e.setRaisonSociale(cr.getString(2));
            e.setCapitale(cr.getDouble(3));
            entr.add(e);
        }
        return entr;

    }
    //findById
    public static Entreprise getOneEntreprise(SQLiteDatabase sqLiteDatabase, int id) {
        Entreprise e = null;
        Cursor cr = sqLiteDatabase.rawQuery("SELECT * FROM " + Nom_Table + " WHERE id=" + id, null);
        while (cr.moveToNext())
        {
            e = new Entreprise();
            e.setID(cr.getInt(0));
            e.setRaisonSociale(cr.getString(1));
            e.setAdresse(cr.getString(2));
            e.setCapitale(cr.getDouble(3));
        }
        return e;
    }

}
