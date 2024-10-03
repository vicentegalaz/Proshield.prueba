package com.example.proshield;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {
    private List<Usuario> usuarios = new ArrayList<>();

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_usuario, parent, false);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Usuario usuario = usuarios.get(position);
        holder.nombreTextView.setText(usuario.getNombre());
        holder.correoTextView.setText(usuario.getCorreo());
        holder.cargoTextView.setText(usuario.getCargo());
        holder.telefonoTextView.setText(usuario.getTelefono());
        holder.enfermedadTextView.setText(usuario.getEnfermedad());
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        notifyDataSetChanged();
    }

    static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTextView, correoTextView, cargoTextView, telefonoTextView, enfermedadTextView;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.textViewNombre);
            correoTextView = itemView.findViewById(R.id.textViewCorreo);
            cargoTextView = itemView.findViewById(R.id.textViewCargo);
            telefonoTextView = itemView.findViewById(R.id.textViewTelefono);
            enfermedadTextView = itemView.findViewById(R.id.textViewEnfermedad);
        }
    }
}
