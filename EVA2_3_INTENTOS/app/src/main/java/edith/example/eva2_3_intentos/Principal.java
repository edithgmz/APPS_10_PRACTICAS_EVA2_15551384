package edith.example.eva2_3_intentos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity {
    Intent inLanzarSec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        inLanzarSec = new Intent(this, Secundaria.class);
    }

    public void onClick(View v){
        startActivity(inLanzarSec);
    }
}
