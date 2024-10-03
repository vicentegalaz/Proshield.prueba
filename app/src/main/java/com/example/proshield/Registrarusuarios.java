package com.example.proshield;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;  // Importar Log
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class Registrarusuarios extends AppCompatActivity {

    private UsuarioViewModel usuarioViewModel;  // ViewModel como variable global
    private static final String TAG = "Registrarusuarios"; // Etiqueta para los logs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarusuarios);  // Configurar la vista

        // Inicializamos el Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inicializamos el ViewModel
        usuarioViewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);

        // Manejo de WindowInsets para bordes a bordes
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Método llamado cuando se hace clic en el botón de registro
    public void Registrar(View v) {
        // 1. Obtener los datos del usuario desde los EditText
        EditText editTextNombre = findViewById(R.id.editTextNombre);
        EditText editTextCorreo = findViewById(R.id.editTextCorreo);
        EditText editTextContrasena = findViewById(R.id.editTextContrasena);
        EditText editTextCargo = findViewById(R.id.editTextCargo);
        EditText editTextTelefono = findViewById(R.id.editTextTelefono);
        EditText editTextEnfermedad = findViewById(R.id.editTextEnfermedad);

        String nombre = editTextNombre.getText().toString().trim();
        String correo = editTextCorreo.getText().toString().trim();
        String contrasena = editTextContrasena.getText().toString().trim();
        String cargo = editTextCargo.getText().toString().trim();
        String telefono = editTextTelefono.getText().toString().trim();
        String enfermedad = editTextEnfermedad.getText().toString().trim();

        // 2. Validación de campos vacíos
        if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || cargo.isEmpty() || telefono.isEmpty()) {
            Toast.makeText(this, "Todos los campos excepto enfermedad son obligatorios.", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Registro fallido: campos vacíos.");
            return;  // Detener el proceso si algún campo requerido está vacío
        }

        // 3. Crear un nuevo objeto Usuario
        Usuario nuevoUsuario = new Usuario(nombre, correo, contrasena, cargo, telefono, enfermedad);
        Log.d(TAG, "Usuario creado: " + nuevoUsuario.toString());

        // 4. Agregar el usuario al ViewModel
        usuarioViewModel.agregarUsuario(nuevoUsuario);
        Log.d(TAG, "Usuario agregado al ViewModel.");

        // 5. Mostrar mensaje de éxito
        Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();

        // 6. Navegar a la actividad Inicio
        Intent intent = new Intent(this, Inicio.class);
        startActivity(intent);
        finish();  // Finalizar la actividad actual
    }
}
