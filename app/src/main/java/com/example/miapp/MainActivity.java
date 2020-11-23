package com.example.miapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;

import static java.util.Calendar.*;

public class MainActivity extends AppCompatActivity {

    
    private EditText nombre, f_nacimiento, telefono;
    private int dia, mes, ano;
    private RadioButton rMasculino, rFemenino;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignamos los valores a las referencias
        nombre = findViewById(R.id.edNombre);
        f_nacimiento = findViewById(R.id.edFechaN);
        telefono = findViewById(R.id.edTelefono);

        rMasculino = findViewById(R.id.rbtMasculino);
        rFemenino = findViewById(R.id.rbtFemenino);

    }

    public void Envio()
    {
        //Creamos el Intent
        Intent intent = new Intent(MainActivity.this, actBienvenida.class);

        //Creamos la informacion a pasar entre
        Bundle bundel = new Bundle();
        bundel.putString("nombre", nombre.getText().toString());
        bundel.putString("f_nacimiento", f_nacimiento.getText().toString());
        bundel.putString("telefono", telefono.getText().toString());

        if(rFemenino.isChecked())
            bundel.putString("genero", rFemenino.getText().toString());
        if(rMasculino.isChecked())
            bundel.putString("genero", rMasculino.getText().toString());

        //Añadimos la información al intent
        intent.putExtras(bundel);

        //Iniciamos la nueva actividad
        startActivity(intent);
    }

    public void vistaCalendar(View view)
    {
        final Calendar calendar = getInstance();

        dia = calendar.get(DAY_OF_MONTH);
        mes = calendar.get(MONTH);
        ano = calendar.get(YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view1, year, month, dayOfMonth) -> {
            String fecha = dayOfMonth + "/" + (month + 1) + "/" + year;
            f_nacimiento.setText(fecha);
        }, ano, mes, dia);
        datePickerDialog.show();

    }

    public void onClick_Enviar(View view)
    {
        if(nombre.getText().toString().equals("") || f_nacimiento.getText().toString().equals("") || (!rFemenino.isChecked() && !rMasculino.isChecked()) || telefono.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), "Todo los campos son obligatorio", Toast.LENGTH_SHORT).show();
        else if(telefono.getText().length() != 10)
            Toast.makeText(getApplicationContext(), "La cantidad de dígitos que debe colocar en su télefono es 10", Toast.LENGTH_SHORT).show();
        else
            Envio();
    }
}