package com.example.kota.appmovil_trabajo2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SearchView listaBuscador;

        listaBuscador = (SearchView) findViewById(R.id.searchView);

    }

    public void listar(){
        DbManager manager = new DbManager(this);
        manager.listar();
    }

}
