package edith.example.eva2_5_extras_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class Principal extends AppCompatActivity {
    EditText edtTxtNom, edtTxtEdad, edtTxtSal;
    CheckBox ckBxTrabaja;
    RadioButton rdBtnSol, rdBtnCas, rdBtnArre, rdBtnViu;
    Intent inSecun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Crear intento para ejecutar actividad Secundaria
        inSecun = new Intent(this, Secundaria.class);

        edtTxtNom = findViewById(R.id.edtTxtNom);
        edtTxtEdad = findViewById(R.id.edtTxtEdad);
        edtTxtSal = findViewById(R.id.edtTxtSal);
        ckBxTrabaja = findViewById(R.id.ckBxTrabaja);
        rdBtnSol = findViewById(R.id.rdBtnSol);
        rdBtnCas = findViewById(R.id.rdBtnCas);
        rdBtnArre = findViewById(R.id.rdBtnArre);
        rdBtnViu = findViewById(R.id.rdBtnViu);
    }

    public void onClick(View v){
        //Enviar datos al intento
        inSecun.putExtra("NOMBRE", edtTxtNom.getText().toString());

        int iEdad = Integer.parseInt(edtTxtEdad.getText().toString());
        inSecun.putExtra("EDAD", iEdad);

        double dSal = Double.parseDouble(edtTxtSal.getText().toString());
        inSecun.putExtra("SALARIO", dSal);

        inSecun.putExtra("ES_CHAMBEADOR", ckBxTrabaja.isChecked());

        if(rdBtnArre.isChecked()){
            inSecun.putExtra("ESTADO", "Arrejuntado");
        } else if(rdBtnCas.isChecked()){
            inSecun.putExtra("ESTADO", "Casado");
        } else if(rdBtnSol.isChecked()){
            inSecun.putExtra("ESTADO", "Soltero");
        } else if(rdBtnViu.isChecked()){
            inSecun.putExtra("ESTADO", "Viudo");
        }

        //Iniciar actividad
        startActivity(inSecun);
    }
}
