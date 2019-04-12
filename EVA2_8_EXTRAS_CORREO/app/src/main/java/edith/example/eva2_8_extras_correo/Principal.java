package edith.example.eva2_8_extras_correo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Principal extends AppCompatActivity {
    EditText edtTxtAsunto, edtTxtCorreo, edtTxtMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        edtTxtAsunto = findViewById(R.id.edtTxtAsunto);
        edtTxtCorreo = findViewById(R.id.edtTxtCorreo);
        edtTxtMensaje = findViewById(R.id.edtTxtMensaje);
    }

    public void onClick(View v){
        String sAsunto = edtTxtAsunto.getText().toString();
        String sMensaje = edtTxtMensaje.getText().toString();
        String[] sListaCorreo = {edtTxtCorreo.getText().toString()};
        Intent inCorreo = new Intent(Intent.ACTION_SEND);
        inCorreo.setType("vnd.android.cursor.dir/email");
        inCorreo.putExtra(Intent.EXTRA_EMAIL, sListaCorreo);
        inCorreo.putExtra(Intent.EXTRA_SUBJECT, sAsunto);
        inCorreo.putExtra(Intent.EXTRA_TEXT, sMensaje);
        startActivity(Intent.createChooser(inCorreo,"Para completar la acción seleccione:"));
    }
}
