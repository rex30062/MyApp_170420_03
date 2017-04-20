package com.cclz.myapp_170420_03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student> mylist;
    File myfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myfile = new File(getFilesDir() + File.separator + "mydata.json");
        if(myfile.exists()){
            try {
                FileReader fr=new FileReader(myfile);
                BufferedReader br=new BufferedReader(fr);
                String data=br.readLine();
                Gson gson=new Gson();
                mylist = gson.fromJson(data, new TypeToken<ArrayList>(){}.getType());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getTitle().equals("Add")){
            Intent it=new Intent(MainActivity.this, AddActivity.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }
}
