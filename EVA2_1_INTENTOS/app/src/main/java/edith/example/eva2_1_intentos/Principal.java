package edith.example.eva2_1_intentos;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Principal extends AppCompatActivity {
    EditText edtTxtTel, edtTxtBus, edtTxtMen,edtTxtTelMen;
    Intent inMarcar, inBuscar, inMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        edtTxtTel = findViewById(R.id.edtTxtTel);
        edtTxtBus = findViewById(R.id.edtTxtBus);
        edtTxtMen = findViewById(R.id.edtTxtMen);
        edtTxtTelMen = findViewById(R.id.edtTxtTelMen);
    }

    public void onClick(View v){
        //Recuperar el número de tel
        String sTel = "tel:" + edtTxtTel.getText().toString();
        //Generar el intento, requiere el número de tel
        inMarcar = new Intent(Intent.ACTION_DIAL, Uri.parse(sTel));
        //inMarcar = new Intent(Intent.ACTION_CALL, Uri.parse(sTel)); --> hace la llamada sin preguntar al usuario [requiere permisos]
        //Iniciar actividad, solicitar o no resultados
        //Sin resultados
        startActivity(inMarcar);
        //Con resultados
        //startActivityForResult(inMarcar);
    }

    public void onClickWeb(View v){
        //Recuperar el término a buscar
        String sBus = edtTxtBus.getText().toString();
        //Generar intento
        inBuscar = new Intent(Intent.ACTION_WEB_SEARCH);
        inBuscar.putExtra(SearchManager.QUERY, sBus);
        //Iniciar actividad, sin resultados
        startActivity(inBuscar);
    }

    public void onClickMensaje(View v){
        //Recuperar el número de tel
        String sTel = "smsto:" + edtTxtTelMen.getText().toString();
        String sMen = edtTxtMen.getText().toString();
        //Generar el intento, requiere el número de tel
        inMensaje = new Intent(Intent.ACTION_SENDTO, Uri.parse(sTel));
        inMensaje.putExtra("sms_body", sMen);
        //Iniciar actividad, sin resultados
        startActivity(inMensaje);
    }

    public void onClickLlamar(View v){
        //Recuperar el número de tel
        String sTel = "tel:" + edtTxtTel.getText().toString();
        //Generar el intento, requiere el número de tel
        inMarcar = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
        //inMarcar = new Intent(Intent.ACTION_CALL, Uri.parse(sTel)); --> hace la llamada sin preguntar al usuario [requiere permisos]
        //Iniciar actividad, solicitar o no resultados
        //Sin resultados
        startActivity(inMarcar);
        //Con resultados
        //startActivityForResult(inMarcar);
    }
}
