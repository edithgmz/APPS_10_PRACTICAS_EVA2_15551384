package edith.example.eva2_6_bundles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Secundaria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        //Recuperar intento
        Intent inDatos = getIntent();

        //Recuperar datos del Bundle
        Bundle bDatos = inDatos.getExtras();
        Toast.makeText(this,bDatos.getString("NOMBRE") + " " +
                        bDatos.getDouble("ESTATURA"), Toast.LENGTH_LONG).show();
    }
}
