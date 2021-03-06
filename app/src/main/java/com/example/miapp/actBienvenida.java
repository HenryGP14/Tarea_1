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
        TextView mensaje;
        mensaje = findViewById(R.id.txtRMensaje);

        //Recuperamos la información pasada en el intent
        Bundle bundel = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        String cadena;

        if (bundel.getString("genero").equals("Masculino"))
            cadena = "Hola, bienvenido " + bundel.getString("nombre");
        else
            cadena = "Hola, bienvenida " + bundel.getString("nombre");

        cadena += " su fecha de nacimiento es " + bundel.getString("f_nacimiento")
                + ", y su número de télefono es: " + bundel.getString("telefono") + " y lo registramos para contactarnos en un futuro próximo. " +
                "\n\nGracias por su atención y confiar en nosotros.";
        mensaje.setText(cadena);

    }
}