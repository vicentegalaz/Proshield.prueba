package com.example.proshield;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void login(View V) {

        EditText campo1 = this.findViewById(R.id.correo);
        String correo = campo1.getText().toString();
        EditText campo2 = this.findViewById(R.id.contrasenia);
        String contrasenia = campo2.getText().toString();
        EditText campo3 = this.findViewById(R.id.cargo);
        String cargo = campo3.getText().toString();
        if (correo.equals("vicente") && contrasenia.equals("12345") && cargo.equals("jefe")) {
            Intent i = new Intent(this, Inicio.class);
            startActivity(i);

        } else {
            Toast.makeText(this, "error, ingrese el usuario correctamente", Toast.LENGTH_SHORT).show();
        }
    }
    public void RecuperarCuenta(View V){
        Intent i = new Intent(this,OlvidarContrasenia.class);
        startActivity(i);
    }

}