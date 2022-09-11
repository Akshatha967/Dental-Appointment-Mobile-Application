package com.example.mad_project1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

//import androidx.annotation.Nullable;

public class DbManager extends SQLiteOpenHelper {
    private static final String dbname = "hospital.db";
    private static final String pat_tab1 = "patient";
    private static final String doc_tab1 = "doctor";
    private static final String apt_table = "appointment";
    //private static final String apt_table = "appointment";
   // private static final String login_table = "login";

    public DbManager(@Nullable Context context) {
        super(context, dbname, null, 3);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
      //  String qry1 = "CREATE TABLE "+pat_tab+"(pat_id INTEGER  PRIMARY KEY AUTOINCREMENT, pat_name TEXT, pat_phone INTEGER, pat_gender TEXT, pat_age INTEGER, pat_location TEXT, pat_password TEXT, pat_email TEXT UNIQUE)";
      //  String qry2 = "CREATE TABLE "+doc_tab+"(doc_id INTEGER  PRIMARY KEY AUTOINCREMENT, doc_name TEXT, doc_phone INTEGER, doc_gender TEXT, doc_location TEXT, doc_specialization TEXT, doc_password TEXT, doc_email TEXT UNIQUE)";

        String qry1 = "CREATE TABLE "+pat_tab1+"(pat_email TEXT  PRIMARY KEY , pat_name TEXT, pat_phone INTEGER, pat_gender TEXT, pat_age INTEGER, pat_location TEXT, pat_password TEXT)";
        String qry2 = "CREATE TABLE "+doc_tab1+"(doc_name TEXT, doc_specialization TEXT,doc_email TEXT PRIMARY KEY ,  doc_phone INTEGER, doc_gender TEXT, doc_location TEXT, doc_password TEXT)";


       // String qry3 = "CREATE TABLE "+apt_table+"(pat_email TEXT , doc_email TEXT, apt_date TEXT, apt_time TEXT,PRIMARY KEY(pat_email,doc_email),  FOREIGN KEY(pat_email) REFERENCES "+pat_tab1+"(pat_email) ON DELETE CASCADE, FOREIGN KEY(doc_email) REFERENCES "+doc_tab1+"(doc_email) ON DELETE CASCADE)";
        String qry3 = "CREATE TABLE "+apt_table+"(pat_email TEXT , doc_email TEXT, apt_date TEXT, apt_time TEXT, flag INTEGER, PRIMARY KEY(pat_email,doc_email),  FOREIGN KEY(pat_email) REFERENCES "+pat_tab1+"(pat_email) ON DELETE CASCADE, FOREIGN KEY(doc_email) REFERENCES "+doc_tab1+"(doc_email) ON DELETE CASCADE)";

        // String qry4 = "CREATE TABLE "+login_table+"(name TEXT, email TEXT, password TEXT, gender TEXT,PRIMARY KEY(email))";
        db.execSQL(qry1);
        db.execSQL(qry2);
        db.execSQL(qry3);
        //db.execSQL(qry4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+pat_tab1);
        db.execSQL("DROP TABLE IF EXISTS "+doc_tab1);
        db.execSQL("DROP TABLE IF EXISTS "+ apt_table);
       // db.execSQL("DROP TABLE IF EXISTS "+ login_table);
        onCreate(db);
    }

    public String insertp(String name, String email, String password,String gender)// for both pat and doctor
    {
        SQLiteDatabase db = this.getWritableDatabase();// to be able to write into


        ContentValues cv2 = new ContentValues();
        cv2.put("pat_name",name);
        cv2.put("pat_email",email);
        cv2.put("pat_password",password);
        cv2.put("pat_gender",gender);
        long res2 = db.insert(pat_tab1,null,cv2);

//        ContentValues cv1 = new ContentValues();
//        cv1.put("name",name);
//        cv1.put("email",email);
//        cv1.put("password",password);
//        cv1.put("gender",gender);
//        long res = db.insert(login_table,null,cv1);
        if(res2 ==  -1)
        {
            return "failed";
        }
        else
        {
            return "success";
        }



    }

    public String updateaptReject(String pemail,String demail)
    {
        SQLiteDatabase db = this.getWritableDatabase();// to be able to write into

        //int phone1 = Integer.parseInt(phone);
        ContentValues cv2 = new ContentValues();
        cv2.put("flag",2);
        long res2 = db.update(apt_table,cv2,"pat_email=? and doc_email=?",new String[] {pemail,demail});

        if(res2 ==  -1)
        {
            return "failed";
        }
        else
        {
            return "success";
        }



    }

    public String updateaptAccept(String pemail,String demail)
    {
        SQLiteDatabase db = this.getWritableDatabase();// to be able to write into

        //int phone1 = Integer.parseInt(phone);
        ContentValues cv2 = new ContentValues();
        cv2.put("flag",3);
        long res2 = db.update(apt_table,cv2,"pat_email=? and doc_email=?",new String[] {pemail,demail});

        if(res2 ==  -1)
        {
            return "failed";
        }
        else
        {
            return "success";
        }



    }


    public String updatepat(String name, String email, long phone,String gender,int age,String location)// for both pat and doctor
    {
        SQLiteDatabase db = this.getWritableDatabase();// to be able to write into

        //int phone1 = Integer.parseInt(phone);
        ContentValues cv2 = new ContentValues();
        cv2.put("pat_name",name);

        cv2.put("pat_phone",phone);
        cv2.put("pat_gender",gender);
        cv2.put("pat_age",age);
        cv2.put("pat_location",location);
        long res2 = db.update(pat_tab1,cv2,"pat_email=?",new String[] {email});

//        ContentValues cv1 = new ContentValues();
//        cv1.put("name",name);
//        cv1.put("email",email);
//        cv1.put("password",password);
//        cv1.put("gender",gender);
//        long res = db.insert(login_table,null,cv1);
        if(res2 ==  -1)
        {
            return "failed";
        }
        else
        {
            return "success";
        }



    }



    public String insertd(String name, String email, String password,String gender)// for both pat and doctor
    {
        SQLiteDatabase db = this.getWritableDatabase();// to be able to write into


        ContentValues cv2 = new ContentValues();
        cv2.put("doc_name",name);
        cv2.put("doc_email",email);
        cv2.put("doc_password",password);
        cv2.put("doc_gender",gender);
        long res2 = db.insert(doc_tab1,null,cv2);

//        ContentValues cv1 = new ContentValues();
//        cv1.put("name",name);
//        cv1.put("email",email);
//        cv1.put("password",password);
//        cv1.put("gender",gender);
//        long res = db.insert(login_table,null,cv1);
        if(res2 ==  -1)
        {
            return "failed";
        }
        else
        {
            return "success";
        }



    }


    public String updataedoc(String name, String specialization, String email,long phone,String gender, String location)// for both pat and doctor
    {
        SQLiteDatabase db = this.getWritableDatabase();// to be able to write into


        ContentValues cv2 = new ContentValues();
        cv2.put("doc_name",name);

        cv2.put("doc_phone",phone);
        cv2.put("doc_gender",gender);
        cv2.put("doc_specialization",specialization);
        cv2.put("doc_location",location);

        long res2 = db.update(doc_tab1,cv2,"doc_email=?",new String[] {email});

//        ContentValues cv1 = new ContentValues();
//        cv1.put("name",name);
//        cv1.put("email",email);
//        cv1.put("password",password);
//        cv1.put("gender",gender);
//        long res = db.insert(login_table,null,cv1);
        if(res2 ==  -1)
        {
            return "failed";
        }
        else
        {
            return "success";
        }



    }



    public String insertapt(String pat_email,String doc_email, String date, String time)// for both pat and doctor
    {
        SQLiteDatabase db = this.getWritableDatabase();// to be able to write into


        ContentValues cv1 = new ContentValues();
        cv1.put("pat_email",pat_email);
        cv1.put("doc_email",doc_email);
        cv1.put("apt_date",date);
        cv1.put("apt_time",time);
        cv1.put("flag",0);


        long res = db.insert(apt_table,null,cv1);
        if(res ==  -1)
        {
            return "failed";
        }
        else
        {
            return "success";
        }


    }


    public Boolean signIndetp(String email, String pwd)// for both pat and doctor
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<>();
        // rawquerry
        Cursor cursor = db.rawQuery("SELECT * FROM "+pat_tab1+" WHERE pat_email=? and pat_password=?",new String[] {email,pwd});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }


    public Boolean signIndetd(String email, String pwd)// for both pat and doctor
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<>();
        // rawquerry
        Cursor cursor = db.rawQuery("SELECT * FROM "+doc_tab1+" WHERE doc_email=? and doc_password=?",new String[] {email,pwd});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Cursor  pat_name(String email)// retun name of patient welcome page
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+pat_tab1+" WHERE pat_email=?",new String[] {email});
//        if(cursor.getCount()>0)
//            return cursor.getString(0);
//        else
//            return "false";
        return cursor;

    }

    public Cursor doc_name(String email)// retun name of patient welcome page
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+doc_tab1+" WHERE doc_email=?",new String[] {email});
//        if(cursor.getCount()>0)
//            return cursor.getString(1);
//        else
//            return "false";
        return cursor;

    }

//    public Cursor getMakeAppt1()
//    {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT doc_name , doc_specialization, doc_email FROM "+doc_tab1,null);
//
//
//                return cursor;
//
//    }
    public Cursor getMakeAppt()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+doc_tab1,null);


        return cursor;

    }

    public Cursor myconfirmedAppt(String email)//accepted by doc and patnt
    {
        SQLiteDatabase db =this.getReadableDatabase();

        Cursor cursor=db.rawQuery("SELECT * FROM "+apt_table+" WHERE pat_email =? and flag=3",new String[] {email});
        return  cursor;
    }

    public Cursor mydocconfirmedAppt(String email)//accepted by doc and patnt
    {
        SQLiteDatabase db =this.getReadableDatabase();

        Cursor cursor=db.rawQuery("SELECT * FROM "+apt_table+" WHERE doc_email =? and flag=3",new String[] {email});
        return  cursor;
    }

    public Cursor myrejectedAppt(String email)
    {
        SQLiteDatabase db =this.getReadableDatabase();

        Cursor cursor=db.rawQuery("SELECT * FROM "+apt_table+" WHERE pat_email =? and flag=2",new String[] {email});
        return  cursor;
    }

    public Cursor confirmAppt(String email)//cld by doc..pending appt by patient
    {
        SQLiteDatabase db =this.getReadableDatabase();

        Cursor cursor=db.rawQuery("SELECT * FROM "+apt_table+" WHERE pat_email =? and flag=0",new String[] {email});
        return  cursor;
    }

    public Cursor dconfirmAppt(String email)
    {
        SQLiteDatabase db =this.getReadableDatabase();

        Cursor cursor=db.rawQuery("SELECT * FROM "+apt_table+" WHERE doc_email =? and flag=0",new String[] {email});
        return  cursor;

    }
    public Cursor getPat(String email)
    {
        SQLiteDatabase db =this.getReadableDatabase();

        Cursor cursor=db.rawQuery("SELECT * FROM "+pat_tab1+" WHERE pat_email =? ",new String[] {email});
        return  cursor;

    }

    public Cursor getDoc(String email)
    {
        SQLiteDatabase db =this.getReadableDatabase();

        Cursor cursor=db.rawQuery("SELECT * FROM "+doc_tab1+" WHERE doc_email =? ",new String[] {email});
        return  cursor;

    }




//    public String get_pat_id(String email)
//    {
//        SQLiteDatabase db =this.getReadableDatabase();
//        Cursor cursor=db.rawQuery("SELECT pat_id FROM "+pat_tab+" WHERE pat_email="+email,null);
//       String s = cursor.toString();
//      // int i = Integer.parseInt(s);
//       return s;
//
//    }

//    public int get_doc_id(String email)
//    {
//        SQLiteDatabase db =this.getReadableDatabase();
//        Cursor cursor=db.rawQuery("SELECT doc_id FROM "+doc_tab+" WHERE doc_email="+email,null);
//        String s = cursor.toString();
//        int i = Integer.parseInt(s);
//        return i;
//
//    }

}
