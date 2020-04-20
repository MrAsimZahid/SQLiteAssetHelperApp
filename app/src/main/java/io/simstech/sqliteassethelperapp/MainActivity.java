package io.simstech.sqliteassethelperapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import io.simstech.sqliteassethelperapp.SQLitePackage.MyDbClass;
import io.simstech.sqliteassethelperapp.recyclerpackage.DbAdapter;
import io.simstech.sqliteassethelperapp.recyclerpackage.DbModelClass;

public class MainActivity extends AppCompatActivity {

    MyDbClass objMyDbClass;
    ArrayList<DbModelClass> objDbModelClassArrayList;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objMyDbClass=new MyDbClass(this);
        objDbModelClassArrayList=new ArrayList<>();
        recyclerView=findViewById(R.id.dataRV);
    }

    public void showData(View view)
    {
        try {

            objDbModelClassArrayList=objMyDbClass.getAllData();
            DbAdapter objdbAdapter=new DbAdapter(objDbModelClassArrayList);

            recyclerView.hasFixedSize();
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            recyclerView.setAdapter(objdbAdapter);

        }
        catch(Exception e)
        {

        }
    }
}
