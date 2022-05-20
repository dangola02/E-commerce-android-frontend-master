package com.example.ecommerce;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    private static  final String databaseName = "DBApp";
    private static  final String Table_name = "Users";
    private static  final String FullName = "fullName";
    private static  final String Password = "Password";
    private static  final String Email = "Email";
    private static  final String UserId = "Id";
    private static final int verision = 1 ;

    public DataBase(@Nullable Context context) {
        super(context, databaseName, null, verision);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Users (Id INTEGER PRIMARY KEY AUTOINCREMENT , " + this.FullName  + "  VARCHAR(225) NOT NULL UNIQUE ,  Password VARCHAR(255) NOT NULL )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Users");
        onCreate(db);
    }

    public long insertData(String Fullname , String Password ) {
        SQLiteDatabase db = getWritableDatabase() ;
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.FullName , Fullname);
        contentValues.put(this.Password , Password);
        long result = db.insert(this.Table_name , null , contentValues);
        return result ;

    }
    public  String showData (){
        SQLiteDatabase db = getReadableDatabase();
        String [] columns = {this.UserId , this.FullName , this.Password , this.Email };
        Cursor result = db.query(this.Table_name , columns , null , null , null,null,null);
        StringBuffer stringBuffer = new StringBuffer() ;
        while (result.moveToNext()){
            int userId = result.getInt(0) ;
            String fullName = result.getString(1);
            String password = result.getString(2);
            String Email = result.getString(3);
            stringBuffer.append(userId+"----> ID" + "\n fullName: " + fullName + "\n  Email: " + Email+ "\n  password : "+ password+ "\n");
        }
        return stringBuffer.toString() ;
    }
    public String searchDate (String fullName  , String Email ) {
        SQLiteDatabase db = getWritableDatabase();
        String [] columns = {this.UserId , this.FullName , this.Email , this.Password};
        Cursor resulte = db.query(this.Table_name , columns , this.FullName +"like '%" +FullName+"%' and "+this.Email+" like '%"+Email+"%' ",null, null , null ,null);
        StringBuffer stringBuffer = new StringBuffer();
        while (resulte.moveToNext()){
            int userId = resulte.getInt(0) ;
            String fullname = resulte.getString(1);
            String email = resulte.getString(2);
            String password = resulte.getString(3);
            stringBuffer.append(userId+"----> ID" + "\n FullName: "+ fullname + "\n Email: "+ email+ "\n Password : "+ password +"\n") ;

        }
        return stringBuffer.toString();
    }
    public int updateDate(String fullname , String email , String newFullname , String newEmail) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues() ;
        contentValues.put(this.FullName , newFullname) ;
        contentValues.put(this.Email , newEmail) ;
        String[] arg = {fullname , email} ;
        int result = db.update(this.Table_name , contentValues , this.FullName + " = ? and "+this.Email +" = ? " , arg) ;
        return result ;
    }
    public int deleteDate(String fullName , String email ){
        SQLiteDatabase db = getWritableDatabase();
        String[] arg = {fullName , email} ;
        int result = db.delete(this.Table_name , this.FullName +" = ? and "+this.Email+" = ? " , arg  );
        return result;
    }
}
