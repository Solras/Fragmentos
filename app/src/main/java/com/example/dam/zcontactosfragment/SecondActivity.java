package com.example.dam.zcontactosfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    private Contacto valor;
    private Contacto contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        valor=null;
        if(savedInstanceState!=null){
            valor = (Contacto) savedInstanceState.getSerializable("valor");
        }

        if(valor==null){
            setContentView(R.layout.second_activity);
            contacto = (Contacto) getIntent().getExtras().getSerializable("contacto");
            Fragment2 fragment = (Fragment2) getFragmentManager().findFragmentById(R.id.fragment2v);
            Log.v(FirstActivity.TAG, "Contacto: "+contacto.getNombre());
            fragment.setDato(contacto);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("valor", contacto);
    }
}
