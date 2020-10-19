package com.example.formulariousuario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etFechaNacimiento;
    Calendar miCalendario = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFechaNacimiento = findViewById(R.id.etFechaNacimiento);
        etFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, date, miCalendario.get(Calendar.YEAR), miCalendario.get(Calendar.MONTH),miCalendario.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        final EditText etNombreUsuario = (EditText) findViewById(R.id.etNombreUsuario);
        final EditText etFechaNacimiento = (EditText) findViewById(R.id.etFechaNacimiento);
        final EditText etTelefono = (EditText) findViewById(R.id.etTelefono);
        final EditText etCorreo = (EditText) findViewById(R.id.etCorreo);
        final EditText etDescripcionUsuario = (EditText) findViewById(R.id.etDescripcionUsuario);
        Button btn_sig = (Button) findViewById(R.id.BotonSiguiente);
        btn_sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ConfirmacionDatosUsuario.class);
                intent.putExtra("Nombre",etNombreUsuario.getText().toString());
                intent.putExtra("Fecha",etFechaNacimiento.getText().toString());
                intent.putExtra("Telefono",etTelefono.getText().toString());
                intent.putExtra("Correo",etCorreo.getText().toString());
                intent.putExtra("Descripcion",etDescripcionUsuario.getText().toString());
                startActivityForResult(intent,0);
            }
        });

    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            miCalendario.set(Calendar.YEAR, year);
            miCalendario.set(Calendar.MONTH, month);
            miCalendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            actualizarInput();
        }
    };

    private void actualizarInput(){
        String formatoDeFecha = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha, Locale.US);
        etFechaNacimiento.setText(sdf.format(miCalendario.getTime()));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}