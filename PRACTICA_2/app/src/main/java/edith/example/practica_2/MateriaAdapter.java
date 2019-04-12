package edith.example.practica_2;
/*
 * Created by Edith on 02-Apr-19.
 */

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MateriaAdapter extends ArrayAdapter<Materia> {
    private Context cApp;
    private int iLayoutMateria;
    private Materia[] amDatos;

    public MateriaAdapter(@NonNull Context context, int resource, @NonNull Materia[] objects) {
        super(context, resource, objects);
        cApp = context;
        iLayoutMateria = resource;
        amDatos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imgVwMateria;
        TextView txtVwMateria;

        View vwLayoutMateria = convertView;

        if(vwLayoutMateria == null){
            LayoutInflater liCrearLayout = ((Activity)cApp).getLayoutInflater();
            vwLayoutMateria = liCrearLayout.inflate(iLayoutMateria, parent, false);
        }

        imgVwMateria = vwLayoutMateria.findViewById(R.id.imgVwMateria);
        txtVwMateria = vwLayoutMateria.findViewById(R.id.txtVwMateria);

        Materia mMateria = amDatos[position];

        imgVwMateria.setImageResource(mMateria.getImg_mat());
        txtVwMateria.setText(mMateria.getNom_mat());

        return vwLayoutMateria;
    }
}
