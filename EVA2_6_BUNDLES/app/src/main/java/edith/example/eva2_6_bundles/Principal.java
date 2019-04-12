package edith.example.eva2_6_bundles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity {
    Intent inSecun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        inSecun = new Intent(this, Secundaria.class);
    }

    public void onClick(View v){
        //Poner Bundle en el intento
        Bundle bDatos = new Bundle();
        bDatos.putString("NOMBRE", "Edith Gómez");
        bDatos.putDouble("ESTATURA", 1.60);
        inSecun.putExtras(bDatos);
        //Iniciar actividad
        startActivity(inSecun);
    }
}
