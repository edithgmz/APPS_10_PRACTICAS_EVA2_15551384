package edith.example.practica_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalle extends AppCompatActivity {
    ImageView imgVwDocente;
    TextView txtVwMateria, txtVwCreditos, txtVwDocente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        imgVwDocente = findViewById(R.id.imgVwDocente);
        txtVwMateria = findViewById(R.id.txtVwMateria);
        txtVwDocente = findViewById(R.id.txtVwDocente);
        txtVwCreditos = findViewById(R.id.txtVwCreditos);

        Intent inDatos = getIntent();
        Bundle bDatos = inDatos.getExtras();

        imgVwDocente.setImageResource(bDatos.getInt("IMG_DOC"));
        txtVwMateria.setText(bDatos.getString("NOM_MAT"));
        txtVwDocente.setText(bDatos.getString("NOM_DOC"));
        txtVwCreditos.setText(bDatos.getInt("MAT_CRE") + "");
    }
}
