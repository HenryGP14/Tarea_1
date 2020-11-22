package com.example.miapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class actBienvenida extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_bienvenida);

        //Localizar los controles
        TextView nombre, genero, f_nacimiento, telefono;
        nombre = (TextView)findViewById(R.id.txtRNombre);
        f_nacimiento = (TextView)findViewById(R.id.txtRFNac);
        telefono = (TextView)findViewById(R.id.txtRTelefono);
        genero = (TextView)findViewById(R.id.txtRGenero);

        //Recuperamos la información pasada en el intent
        Bundle bundel = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        nombre.setText(bundel.getString("nombre"));
        f_nacimiento.setText(bundel.getString("f_nacimiento"));
        telefono.setText(bundel.getString("telefono"));
        genero.setText(bundel.getString("genero"));

    }
}