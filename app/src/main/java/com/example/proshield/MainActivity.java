package com.example.proshield;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerCargo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignar el Spinner
        spinnerCargo = findViewById(R.id.spinnerCargo);

        // Cargar el array de cargos desde strings.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.cargos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Configurar el adapter en el Spinner
        spinnerCargo.setAdapter(adapter);
    }

    public void login(View v) {
        EditText correoEditText = findViewById(R.id.correo);
        EditText contraseniaEditText = findViewById(R.id.contrasenia);
        String correo = correoEditText.getText().toString();
        String contrasenia = contraseniaEditText.getText().toString();

        // Obtener el cargo seleccionado en el Spinner
        String cargo = spinnerCargo.getSelectedItem().toString();

        if (correo.equals("vicente") && contrasenia.equals("12345") && cargo.equals("Jefe")) {
            // Iniciar nueva actividad
            Intent i = new Intent(this, Inicio.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Error, ingrese el usuario correctamente", Toast.LENGTH_SHORT).show();
        }
    }
}
