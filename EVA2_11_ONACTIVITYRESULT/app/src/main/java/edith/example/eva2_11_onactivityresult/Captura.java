package edith.example.eva2_11_onactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Captura extends AppCompatActivity {
    EditText edtTxtNom, edtTxtApe;
    TextView txtVwMaterias;
    Intent inLista;
    final int LISTA = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura);

        edtTxtNom = findViewById(R.id.edtTxtNom);
        edtTxtApe = findViewById(R.id.edtTxtApe);
        txtVwMaterias = findViewById(R.id.txtVwMaterias);

        inLista = new Intent(this, ListadoMaterias.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == LISTA){
            if(resultCode == Activity.RESULT_OK){
                Toast.makeText(this, "EJECUTADO", Toast.LENGTH_SHORT).show();
                txtVwMaterias.append(data.getStringExtra("MATERIAS") + "\n");
            }
        }
    }

    public void lanzarLista(View v){
        startActivityForResult(inLista, LISTA);
    }

    public void cerrar(View v){
        Intent inDatos = new Intent();
        inDatos.putExtra("NOMBRE", edtTxtNom.getText().toString());
        inDatos.putExtra("APELLIDO", edtTxtApe.getText().toString());
        inDatos.putExtra("MATERIAS", txtVwMaterias.getText().toString());
        setResult(Activity.RESULT_OK,inDatos);
        finish();
    }
}
