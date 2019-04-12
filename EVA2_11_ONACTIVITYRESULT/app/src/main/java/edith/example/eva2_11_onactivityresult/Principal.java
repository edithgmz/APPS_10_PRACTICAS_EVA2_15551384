package edith.example.eva2_11_onactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    TextView txtVwResumen;
    Intent inCaptura;
    final int CAPTURA = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtVwResumen = findViewById(R.id.txtVwResumen);
        inCaptura = new Intent(this, Captura.class);
    }

    public void captura(View v){
        startActivityForResult(inCaptura, CAPTURA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAPTURA){
            if(resultCode == Activity.RESULT_OK){
                Toast.makeText(this, "EJECUTADO", Toast.LENGTH_SHORT).show();
                txtVwResumen.setText("Nombre: " + data.getStringExtra("NOMBRE")+
                        "\nApellido: " + data.getStringExtra("APELLIDO")+
                        "\nMaterias: " + data.getStringExtra("MATERIAS"));
            }
        }
    }
}
