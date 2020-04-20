package io.simstech.sqliteassethelperapp.SQLitePackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

import io.simstech.sqliteassethelperapp.recyclerpackage.DbModelClass;

public class MyDbClass extends SQLiteAssetHelper {

    private static final String DATABASE_NAME= "sunsetapp.db";
    private static final int DATABASE_VERSION=1;

    Context context;

    public MyDbClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    public void getAllData()
    {
        try
        {
            ArrayList<DbModelClass> objDbModelClassArrayList=new ArrayList<>();
            SQLiteDatabase objSqLiteDatabase=getReadableDatabase();
            if(objSqLiteDatabase!=null)
            {
                Cursor objCursor=objSqLiteDatabase.rawQuery("select * from sunsetdata", null);
                if(objCursor.getCount()!=0)
                {
                    while (objCursor.moveToNext())
                    {
                        String imageDes=objCursor.getString(0);
                        byte[] imageByte=objCursor.getBlob(1);

                        Bitmap ourImage= BitmapFactory.decodeByteArray(imageByte,0,imageByte.length);
                        objDbModelClassArrayList.add(
                                new DbModelClass(
                                        imageDes,ourImage
                                )
                        );

                    }
                }

            }
            else
            {

            }

        }
        catch (Exception e){

        }
    }
}
