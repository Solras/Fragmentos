package com.example.dam.zcontactosfragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends android.support.v4.app.Fragment {
    View viewFragment;
    private List<Contacto> lista ;
    private ListView lv;
    private Adaptador ad;
    private OnFragmentoInteraccionListener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        viewFragment= inflater.inflate(R.layout.fragment1, container, false);

        init();

        return viewFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentoInteraccionListener){
            listener = (OnFragmentoInteraccionListener) context;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof OnFragmentoInteraccionListener){
            listener = (OnFragmentoInteraccionListener) activity;
        }
    }

    private void init(){
        lv = (ListView) viewFragment.findViewById(R.id.lvFragment);
        lista = new ArrayList<>();
        lista = Cursores.getListaContactos(getActivity());
        for (Contacto c : lista) {
            c.setNumeros(cleanRep(Cursores.getListaTelefonos(getActivity(), c.getId())));
        }
        ad = new Adaptador(getActivity(),(ArrayList)lista);
        lv.setAdapter(ad);
        lv.setTag(lista);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onInteraccion(lista.get(position));
            }
        });

    }
    private ArrayList<String> cleanRep(List<String> list) {
        ArrayList<String> clearedList = new ArrayList();
        for (String str : list) {
            if (!clearedList.contains(str))
                clearedList.add(str);
        }
        return clearedList;
    }
}
