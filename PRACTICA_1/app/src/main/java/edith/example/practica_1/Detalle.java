package edith.example.practica_1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalle extends AppCompatActivity {
    ImageView imgVwRest;
    TextView txtVwNom, txtVwDesc, txtVwDir, txtVwTel;
    Intent inLlamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        imgVwRest = findViewById(R.id.imgVwRest);
        txtVwNom = findViewById(R.id.txtVwNom);
        txtVwDesc = findViewById(R.id.txtVwDesc);
        txtVwDir = findViewById(R.id.txtVwDir);
        txtVwTel = findViewById(R.id.txtVwTel);

        Intent inDatos = getIntent();
        Bundle bDatos = inDatos.getExtras();
        imgVwRest.setImageResource(bDatos.getInt("IMG_REST"));
        txtVwNom.setText(bDatos.getString("NOM_REST"));
        txtVwDesc.setText(bDatos.getString("DESC_REST"));
        txtVwDir.setText(bDatos.getString("DIR_REST"));
        txtVwTel.setText(bDatos.getString("TEL_REST"));
    }

    public void llamar(View v){
        String sTel = "tel:" + txtVwTel.getText().toString();
        inLlamar = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
        startActivity(inLlamar);
    }
}
