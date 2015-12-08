package com.example.dam.zcontactosfragment;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Fragment2 extends Fragment {
    private View viewFragment;
    private TextView tvNombre;
    private TextView tvNumeros;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        viewFragment = inflater.inflate(R.layout.fragment2, container, false);

        tvNombre = (TextView) viewFragment.findViewById(R.id.tvNombre);
        tvNumeros = (TextView) viewFragment.findViewById(R.id.tvNumeros);
        return viewFragment;
    }

    public void setDato(Contacto c){
        Log.v(FirstActivity.TAG, "setDato: " + c.getNombre());
        Log.v(FirstActivity.TAG, "setDato: " + c.getNumeros().get(0));

        tvNombre.setText(c.getNombre());
        tvNumeros.setText("Numeros: ");
        ArrayList<String> numeros = c.getNumeros();
        for (String num : numeros) {
            tvNumeros.append("\n"+num);
        }

    }
}
