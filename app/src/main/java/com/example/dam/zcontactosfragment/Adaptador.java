package com.example.dam.zcontactosfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Adaptador extends ArrayAdapter<Contacto> {

    private Context ctx;
    private LayoutInflater lInflator;
    private ArrayList<Contacto> values;

    static class ViewHolder {
        TextView tv1, tv2;
    }

    public Adaptador(Context context, ArrayList<Contacto> objects) {
        super(context, R.layout.list_item, objects);
        this.ctx = context;
        this.lInflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.values = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = new ViewHolder();

        if (convertView == null) {
            convertView = lInflator.inflate(R.layout.list_item, null);
            TextView tv = (TextView) convertView.findViewById(R.id.tvNombre);
            vh.tv1 = tv;
            tv = (TextView) convertView.findViewById(R.id.tvNumero);
            vh.tv2 = tv;
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.tv1.setText(values.get(position).getNombre());
        if (!values.get(position).isEmpty())
            vh.tv2.setText(values.get(position).getNumeros().get(0));

        return convertView;
    }
}
