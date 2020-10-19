package com.example.formulariousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmacionDatosUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos_usuario);

        // -- Aca obtengo los datos que pasa el MainActivity
        // -- y los cargo en los TextView
        cargarTextView();

        Button btn_editar = (Button) findViewById(R.id.BotonEditar);
        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }



    private void cargarTextView(){
        // -- Obtencion de datos del MainActivity
        Bundle bundle = getIntent().getExtras();
        String nombreImportado = bundle.getString("Nombre");
        String fechaImportado = bundle.getString("Fecha");
        String telefonoImportado = bundle.getString("Telefono");
        String correoImportado = bundle.getString("Correo");
        String descripcionImportado = bundle.getString("Descripcion");

        fechaImportado = "Fecha Nacimiento: "+fechaImportado;
        telefonoImportado = "Tel: "+telefonoImportado;
        correoImportado = "Email: "+correoImportado;
        descripcionImportado = "Descripcion: "+descripcionImportado;

        // -- Asignacion de los TextView
        TextView tvNombreUsuario = (TextView) findViewById(R.id.tvNombreUsuario);
        TextView tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        TextView tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        TextView tvCorreo = (TextView) findViewById(R.id.tvCorreo);
        TextView tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvNombreUsuario.setText(nombreImportado);
        tvFechaNacimiento.setText(fechaImportado);
        tvTelefono.setText(telefonoImportado);
        tvCorreo.setText(correoImportado);
        tvDescripcion.setText(descripcionImportado);
    }
}