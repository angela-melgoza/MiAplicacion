package com.angelamelgoza.miaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button btnRegresar;
    TextView txtvNombre, txtvFecha, txtvTel, txtvEmail, txtvDesc;
    String nombre, fecha, telefono, correo, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtvNombre = findViewById(R.id.txtvNombre);
        txtvFecha = findViewById(R.id.txtvFecha);
        txtvTel = findViewById(R.id.txtvTel);
        txtvEmail = findViewById(R.id.txtvEmail);
        txtvDesc = findViewById(R.id.txtvDesc);
        btnRegresar = findViewById(R.id.btnRegresar);

        /*PARA OBTENER UN VALOR QUE FUE PASADA DESDE LA OTRA ACTIVITY:

          *Se tiene que llamar al método getIntent()
          *Se llama al método correspondiente al tipo de dato:
                -getIntegerExtra() -> Dato de tipo entero
                -getFloatExtra() -> Dato de tipo flotante/real
                -getCharExtra() -> Dato de tipo caracter
                -getStringExtra() -> Dato de tipo cadena de caracteres
          *Dentro del método se debe pasar el nombre de la etiqueta para identificar al dato
                getStringExtra("Nombre de la etiqueta")

         */

        nombre = getIntent().getStringExtra("nombre");
        txtvNombre.setText(nombre);
        fecha = getIntent().getStringExtra("fecha");
        txtvFecha.setText("Fecha de nacimiento: " + fecha);
        telefono = getIntent().getStringExtra("telefono");
        txtvTel.setText("Tel: " + telefono);
        correo = getIntent().getStringExtra("correo");
        txtvEmail.setText("Email: " + correo);
        desc = getIntent().getStringExtra("desc");
        txtvDesc.setText("Descripción: " + desc);


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                //startActivity(intent2);
                finish(); //Finaliza la actividad llamando al método onDestroy() de manera segura
            }
        });

    }
}