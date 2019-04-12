package edith.example.eva2_10_for_result;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    TextView txtVwMensaje, txtVwProv;
    EditText edtTxtOpcion;
    Button btnOpcion;
    Uri[] uProv = {
            Uri.parse("content://media/external/audio/media"),
            Uri.parse("content://media/external/images/media"),
            android.provider.ContactsContract.Contacts.CONTENT_URI,
            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
    };
    final int CODIGO = 222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        try {
            txtVwMensaje = findViewById(R.id.txtVwMensaje);
            txtVwProv = findViewById(R.id.txtVwProv);
            // Muestra ejemplos de proveedores de contenido internos
            edtTxtOpcion = findViewById(R.id.edtTxtOpcion);
            for(int i = 0; i < uProv.length; i++){
                txtVwProv.append("\n" + i + "    " + uProv[i].toString());
            }
            btnOpcion = findViewById(R.id.btnOpcion);
            btnOpcion.setOnClickListener(new ClickHandler());
        } catch(Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private class ClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            try {
                //Inicia inAct2, se indica el código por medio de una constante
                int iOpcion = Integer.parseInt(edtTxtOpcion.getText().toString());
                Intent inAct2 = new Intent(Intent.ACTION_PICK, uProv[iOpcion]);
                startActivityForResult(inAct2, CODIGO);
            } catch(Exception e){
                Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            //Usa requestCode para identificar quién está llamando
            switch (requestCode){
                case CODIGO:
                    //La constante es el código para llamar a la actividad
                    if(resultCode == Activity.RESULT_OK){
                        String sDatos = data.getDataString();
                        Toast.makeText(getApplication(), "id" + sDatos, Toast.LENGTH_LONG).show();
                        /*Regresará una URI que se verá como:
                        **content://contacts/people/n
                        **Donde n es el ID del contacto seleccionado
                        **/
                        txtVwMensaje.setText(sDatos.toString());
                        //Muestra una ventana con el recurso seleccionado
                        Toast.makeText(getApplication(), "UI para\n" + sDatos, Toast.LENGTH_LONG).show();
                        Intent inAct3 = new Intent(Intent.ACTION_VIEW, Uri.parse(sDatos));
                        startActivity(inAct3);
                    } else{
                        //El usuario presionó el botón atrás para terminar la actividad
                        txtVwMensaje.setText("Selección CANCELADA " + requestCode + "    " + resultCode);
                    }
                    break;
            }
        } catch(Exception e){
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
