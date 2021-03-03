package com.angelamelgoza.miaplicacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    /* NOTACIÓN MÁS COMÚN PARA LAS VARIABLES/ID SEGÚN EL COMPONENTE:

       TextView -> txtvNombreVariable
       EditText -> etxtNombreVariable
       Button -> btnNombreVariable
       Spinner -> spNombreVariable
       ImageView -> imgvNombreVariable
       SeekBar -> sbNombreVariable
       WebView -> wvNombreVariable

     */

    TextView txtTitulo;
    EditText etxtNombre, etxtCorreo, etxtTelefono, etxtFecha, etxtDesc;
    Button btnIngresar;

    String nombre, correo, telefono, fecha, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show();

        txtTitulo = findViewById(R.id.txtTitulo);
        etxtNombre = findViewById(R.id.etxtNombre);
        etxtCorreo = findViewById(R.id.etxtEmail);
        etxtTelefono = findViewById(R.id.etxtTelefono);
        etxtFecha = findViewById(R.id.etxtFechaNac);
        etxtDesc = findViewById(R.id.etxtDescContacto);
        btnIngresar = findViewById(R.id.btnIngresar);

        etxtFecha.setOnClickListener(new View.OnClickListener() { //Objeto creado para ejecutar lo que se pide cuando se seleccione el botón
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.etxtFechaNac:
                        showDatePickerDialog();
                        break;
                }
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, R.string.toast_hola, Toast.LENGTH_SHORT).show();
                nombre = etxtNombre.getText().toString();
                correo = etxtCorreo.getText().toString();
                telefono = etxtTelefono.getText().toString();
                fecha = etxtFecha.getText().toString();
                desc = etxtDesc.getText().toString();

                if(nombre.isEmpty()){
                    Toast.makeText(MainActivity.this, R.string.toast_nombre, Toast.LENGTH_LONG).show();
                }
                else if(fecha.isEmpty()){
                    Toast.makeText(MainActivity.this, R.string.toast_fecha, Toast.LENGTH_LONG).show();
                }
                else if(telefono.isEmpty()){
                    Toast.makeText(MainActivity.this, R.string.toast_telefono, Toast.LENGTH_LONG).show();
                }
                else if(correo.isEmpty()){
                    Toast.makeText(MainActivity.this, R.string.toast_email, Toast.LENGTH_LONG).show();
                }
                else if(desc.isEmpty()){
                    Toast.makeText(MainActivity.this, R.string.toast_desc, Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class); //Intent(de donde venimos, hacia dónde queremos ir)
                    intent.putExtra("nombre", nombre); // putExtra(etiqueta para identificar, variable)
                    intent.putExtra("fecha", fecha);
                    intent.putExtra("telefono", telefono);
                    intent.putExtra("correo", correo);
                    intent.putExtra("desc", desc);

                    startActivity(intent);
                }
            }
        });
    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String selectedDate = day + "/" + (month+1) + "/" + year;
                etxtFecha.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    


  /*  @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();
    } */
}