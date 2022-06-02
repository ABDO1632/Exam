package com.example.exam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
}
