package edith.example.eva2_12_permisos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Principal extends AppCompatActivity implements View.OnClickListener {
    EditText edtTxtTel;
    Button btnTel;
    Intent inLlamar;
    final int PERMISO_CALL_PHONE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        edtTxtTel = findViewById(R.id.edtTxtTel);
        btnTel = findViewById(R.id.btnTel);
        btnTel.setOnClickListener(this);
        btnTel.setEnabled(false);

        //Verificar si se tienen permisos
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //Se pueden solicitar varios permisos a la vez
            //Los permisos se pueden solicitar en determinados momentos
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISO_CALL_PHONE);
            //Toast.makeText(this, "No tiene permisos", Toast.LENGTH_LONG).show();
        }
    }

    //Es para la primera vez que el usuario utiliza la aplicación
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISO_CALL_PHONE:
                if(grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                    btnTel.setEnabled(true);
                    //Toast.makeText(this, "Ya tiene permiso", Toast.LENGTH_LONG).show();
                } else{
                    btnTel.setEnabled(false);
                    //Toast.makeText(this, "No tiene permiso", Toast.LENGTH_LONG).show();
                }
                break;
            default:
        }
    }

    @Override
    public void onClick(View v) {
        String sTel = "tel:" + edtTxtTel.getText().toString();
        inLlamar = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
        startActivity(inLlamar);
    }
}

