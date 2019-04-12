package edith.example.eva2_9_activity_for_result;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    TextView txtVwResu;
    Intent inSecun, inOtra;
    final int SECUNDARIA = 1000; //Código para startActivityForResult
    final int OTRA_ACTIVIDAD = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtVwResu = findViewById(R.id.txtVwResu);
        inSecun = new Intent(this, Secundaria.class);
        inOtra = new Intent(this, OtraActividad.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //1. Distinguir la actividad que devuelve el resultado
        //requestCode
        //2. Saber si envió resultados o canceló
        //resultCode
        //3. Procesar los datos
        //data (Intent)
        if(requestCode == SECUNDARIA){ //Actividad Secundaria regresa el valor
            if(resultCode == Activity.RESULT_OK){
                //Procesar los resultados
                //Si el resultado es de una actividad del SO se debe verificar el tipo de contenedor
                String sCade = data.getStringExtra("DATOS");
                //Ponerlos en el txtVw
                txtVwResu.append("SECUNDARIA: " + sCade + "\n");
            }else if(resultCode == Activity.RESULT_CANCELED){
                Toast.makeText(this, "SECUNDARIA: ACCIÓN CANCELADA POR EL USUARIO", Toast.LENGTH_LONG).show();
            }
        }
        //Otra Actividad
        if(requestCode == OTRA_ACTIVIDAD){
            if(resultCode == Activity.RESULT_OK){
                String sCade = data.getStringExtra("DATOS");
                txtVwResu.append("OTRA: " + sCade + "\n");
            }else if(resultCode == Activity.RESULT_CANCELED){
                Toast.makeText(this, "OTRA: ACCIÓN CANCELADA POR EL USUARIO", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void onClick(View v){
        //Pide un código numérico porque es una actividad que potencialmente regresa un resultado
        startActivityForResult(inSecun, SECUNDARIA);
    }

    public void onClick2(View v){
        startActivityForResult(inOtra, OTRA_ACTIVIDAD);
    }
}
