package edith.example.eva2_7_bundles_lista;
/*
 * Created by Edith on 08-Mar-19.
 */
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Principal extends AppCompatActivity implements ListView.OnItemClickListener {
    ListView lstVwCiudades;
    Clima[] acClimaCd = {
            new Clima(R.drawable.light_rain, "Delicias", "Despejado", "Seco y polvoriento", 17),
            new Clima(R.drawable.atmospher, "Entre ríos", "Soleado", "Despejado", 24),
            new Clima(R.drawable.cloudy, "Ciudad Juarez", "Nublado", "Nublado con intervalos", 19.3),
            new Clima(R.drawable.rainy, "Cuahutemoc", "Despejado", "Lluvias moderadas", 17),
            new Clima(R.drawable.snow, "Delicias", "Despejado", "Nevadas intensas", -30),
            new Clima(R.drawable.tornado, "Villa Ahumada", "Hollywoodezco", "The day after tomorrow", 28),
            new Clima(R.drawable.thunderstorm, "Chihuahua", "Tormentoso", "Hollywoodezco", 0)
    };
    Intent inDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        lstVwCiudades = findViewById(R.id.lstVwCiudades);
        lstVwCiudades.setAdapter(new ClimaAdapter(this, R.layout.layout_clima, acClimaCd));
        lstVwCiudades.setOnItemClickListener(this);

        inDetalle = new Intent(this, Detalle.class);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        clicDialogo(i);

        Toast.makeText(this, acClimaCd[i].getDesc_clima(), Toast.LENGTH_SHORT);

        Bundle bDatos = new Bundle();
        bDatos.putInt("IMAGEN", acClimaCd[i].getImagen_clima());
        bDatos.putString("CIUDAD", acClimaCd[i].getCiudad());
        bDatos.putString("DESC_CLIMA", acClimaCd[i].getDesc_clima());
        bDatos.putString("CLIMA", acClimaCd[i].getClima());
        bDatos.putDouble("TEMP", acClimaCd[i].getTemp());
        inDetalle.putExtras(bDatos);
        startActivity(inDetalle);
    }

    public void clicDialogo(int i){
        new AlertDialog.Builder(this)
                .setTitle("Clima")
                .setMessage(acClimaCd[i].getDesc_clima())
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                }).create().show();
    }
}
