package edith.example.eva2_5_extras_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Secundaria extends AppCompatActivity {
    TextView txtVwMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        txtVwMostrar = findViewById(R.id.txtVwMostrar);

        //Recuperar intento
        Intent inDatos = getIntent();

        //Recuperar datos
        txtVwMostrar.append("Nombre: " + inDatos.getStringExtra("NOMBRE") + "\n");
        txtVwMostrar.append("Edad: " + inDatos.getIntExtra("EDAD", 0) + "\n");
        txtVwMostrar.append("Salario: " + inDatos.getDoubleExtra("SALARIO", 20000) + "\n");

        if(inDatos.getBooleanExtra("ES_CHAMBEADOR", true))
            txtVwMostrar.append("Trabaja \n");
        else
            txtVwMostrar.append("De sabático \n");

        txtVwMostrar.append("Estado civil: " + inDatos.getStringExtra("ESTADO") + "\n");
    }
}
