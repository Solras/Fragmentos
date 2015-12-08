package com.example.dam.zcontactosfragment;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity implements OnFragmentoInteraccionListener {

    public static final String TAG = "FRAGMENTOS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
    }

    @Override
    public void onInteraccion(Contacto c) {
        Fragment2 fragment = (Fragment2) getFragmentManager().findFragmentById(R.id.fragment2h);
        if (fragment == null || !fragment.isInLayout()) {
            //Vertical
            Intent i=new Intent (this,SecondActivity.class);
            Bundle b= new Bundle();
            b.putSerializable("contacto", c);
            i.putExtras(b);
            startActivity(i);
        }else{
            //Horizontal
            fragment.setDato(c);
        }
    }
}
