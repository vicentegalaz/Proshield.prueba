package com.example.proshield;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar la Toolbar
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        TabLayout tl = (TabLayout) findViewById(R.id.tlayout);
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position){
                    case 0:
                        mapa m =  new mapa();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,m).commit();
                        break;
                    case 1:
                        emergencia e =  new emergencia();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,e).commit();
                        break;
                    case 2:
                        llamada l =  new llamada();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,l).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.op1) {
            Toast.makeText(this, "se dirige al perfil", Toast.LENGTH_SHORT).show();
            Fragment fragment = new Perfil();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contenedor, fragment)
                    .commit();
        } else if (id == R.id.op2) {
            Toast.makeText(this, "registrara un usuario", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Inicio.this, Registrarusuarios.class);
            startActivity(intent);
        } else if (id == R.id.op3) {
            Toast.makeText(this, "Ver Qr", Toast.LENGTH_SHORT).show();
            Fragment fragment = new Qr(); // Reemplaza Qr con el nombre de tu fragmento
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contenedor, fragment) // Reemplaza R.id.contenedor con el ID de tu contenedor
                    .commit();
        } else if (id == R.id.op4) {
            Toast.makeText(this, "lista de los trabajadores", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Inicio.this, ListaTrabajador.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }



}
