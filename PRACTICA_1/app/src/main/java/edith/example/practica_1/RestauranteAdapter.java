package edith.example.practica_1;
/*
 * Created by Edith on 27-Mar-19.
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

public class RestauranteAdapter extends ArrayAdapter<Restaurante> {
    private Context cApp;
    private int iLayoutRest;
    private Restaurante[] arDatos;

    public RestauranteAdapter(@NonNull Context context, int resource, @NonNull Restaurante[] objects) {
        super(context, resource, objects);
        cApp = context;
        iLayoutRest = resource;
        arDatos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        ImageView imgVwRest2;
        TextView txtVwNom2, txtVwDesc2;

        View vwLayoutRest = convertView;

        if(vwLayoutRest == null){
            LayoutInflater liCrearLayout = ((Activity)cApp).getLayoutInflater();
            vwLayoutRest = liCrearLayout.inflate(iLayoutRest, parent, false);
        }

        imgVwRest2 = vwLayoutRest.findViewById(R.id.imgVwRest2);
        txtVwNom2 = vwLayoutRest.findViewById(R.id.txtVwNom2);
        txtVwDesc2 = vwLayoutRest.findViewById(R.id.txtVwDesc2);

        Restaurante rRestaurante = arDatos[position];

        imgVwRest2.setImageResource(rRestaurante.getImg_rest());
        txtVwNom2.setText(rRestaurante.getNom_rest());
        txtVwDesc2.setText(rRestaurante.getDesc_rest());

        return vwLayoutRest;
    }
}
