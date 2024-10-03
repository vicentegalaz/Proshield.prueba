package com.example.proshield;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link llamada#newInstance} factory method to
 * create an instance of this fragment.
 */
public class llamada extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public llamada() {
        // Required empty public constructor
    }

    public static llamada newInstance(String param1, String param2) {
        llamada fragment = new llamada();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_llamada, container, false);

        // Initialize buttons
        Button button132 = view.findViewById(R.id.button3);
        Button button133 = view.findViewById(R.id.button4);
        Button button131 = view.findViewById(R.id.button5);

        // Set click listeners for buttons
        button132.setOnClickListener(v -> makePhoneCall("132"));
        button133.setOnClickListener(v -> makePhoneCall("133"));
        button131.setOnClickListener(v -> makePhoneCall("131"));

        return view;
    }

    private void makePhoneCall(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
        // Verificar y solicitar permisos antes de hacer la llamada
        if (getActivity().checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(intent);
        } else {
            Toast.makeText(getActivity(), "Permiso de llamada no concedido", Toast.LENGTH_SHORT).show();
            // Aquí puedes pedir permisos si no se han concedido
        }
    }
}
