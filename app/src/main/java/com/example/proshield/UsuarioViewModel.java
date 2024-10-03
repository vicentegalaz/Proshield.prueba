package com.example.proshield;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class UsuarioViewModel extends AndroidViewModel {
    private final MutableLiveData<List<Usuario>> usuarios = new MutableLiveData<>(new ArrayList<>());

    public UsuarioViewModel(Application application) {
        super(application);
        cargarUsuarios(); // Cargar usuarios predeterminados al iniciar el ViewModel
    }

    // Método para obtener la lista de usuarios
    public LiveData<List<Usuario>> getUsuarios() {
        return usuarios;
    }

    // Método privado para cargar usuarios predeterminados
    private void cargarUsuarios() {
        List<Usuario> listaDeUsuarios = new ArrayList<>();
        listaDeUsuarios.add(new Usuario("Juan", "juan@example.com", "123456", "Cargo1", "123456789", "Ninguna"));
        listaDeUsuarios.add(new Usuario("Maria", "maria@example.com", "654321", "Cargo2", "987654321", "Ninguna"));
        usuarios.setValue(listaDeUsuarios); // Actualizar LiveData con la lista predeterminada
    }

    // Método para agregar un nuevo usuario
    public void agregarUsuario(Usuario nuevoUsuario) {
        List<Usuario> listaActual = usuarios.getValue();

        if (listaActual == null) {
            listaActual = new ArrayList<>(); // Inicializa la lista si es null
        }

        listaActual.add(nuevoUsuario); // Agregar el nuevo usuario a la lista
        usuarios.setValue(listaActual); // Actualiza la LiveData
    }
}
