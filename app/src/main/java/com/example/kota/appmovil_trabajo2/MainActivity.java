package com.example.kota.appmovil_trabajo2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText name, apepat, apemat, fono, mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.editText);
        apepat = (EditText) findViewById(R.id.editText2);
        apemat = (EditText) findViewById(R.id.editText3);
        fono = (EditText) findViewById(R.id.editText4);
        mail = (EditText) findViewById(R.id.editText5);

    }

    public void Insertar (View view){
        String nombre = name.getText().toString();
        String apelpat = apepat.getText().toString();
        String apelmat = apemat.getText().toString();
        Integer numero = Integer.parseInt(fono.getText().toString());
        String email = mail.getText().toString();

        DbManager manager = new DbManager(this);
        manager.inserta(nombre, apelpat, apelmat, numero, email);

    }

    public void Listar(View view){
        DbManager manager = new DbManager(this);

        manager.listar();
    }

}
