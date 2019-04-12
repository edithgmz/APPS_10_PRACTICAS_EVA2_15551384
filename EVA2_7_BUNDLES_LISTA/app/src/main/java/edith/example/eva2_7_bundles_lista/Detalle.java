package edith.example.eva2_7_bundles_lista;
/*
 * Created by Edith on 08-Mar-19.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalle extends AppCompatActivity {
    ImageView imgVwClima;
    TextView txtVwCd, txtVwTemp, txtVwClima, txtVwDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        imgVwClima = findViewById(R.id.imgVwClima2);
        txtVwCd = findViewById(R.id.txtVwCd2);
        txtVwTemp = findViewById(R.id.txtVwTemp2);
        txtVwClima = findViewById(R.id.txtVwClima2);
        txtVwDesc = findViewById(R.id.txtVwDesc2);

        Intent inDatos = getIntent();
        Bundle bDatos = inDatos.getExtras();
        imgVwClima.setImageResource(bDatos.getInt("IMAGEN"));
        txtVwCd.setText(bDatos.getString("CIUDAD"));
        txtVwDesc.setText(bDatos.getString("DESC_CLIMA"));
        txtVwClima.setText(bDatos.getString("CLIMA"));
        txtVwTemp.setText(bDatos.getDouble("TEMP") + "°C");
    }

    public void onClick(View v){
        finish();
    }
}
