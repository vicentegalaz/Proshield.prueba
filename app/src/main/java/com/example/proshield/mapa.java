package com.example.proshield;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mapa#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mapa extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public mapa() {
        // Required empty public constructor
    }

    public static mapa newInstance(String param1, String param2) {
        mapa fragment = new mapa();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mapa, container, false);

        // Configuración de los spinners (desplegables)
        Spinner spinnerAlarma = view.findViewById(R.id.spinnerAlarma);
        ArrayAdapter<CharSequence> adapterAlarma = ArrayAdapter.createFromResource(getContext(),
                R.array.alarmas_array, android.R.layout.simple_spinner_item);
        adapterAlarma.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAlarma.setAdapter(adapterAlarma);

        Spinner spinnerExtintor = view.findViewById(R.id.spinnerExtintor);
        ArrayAdapter<CharSequence> adapterExtintor = ArrayAdapter.createFromResource(getContext(),
                R.array.extintores_array, android.R.layout.simple_spinner_item);
        adapterExtintor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerExtintor.setAdapter(adapterExtintor);

        return view;
    }
}
