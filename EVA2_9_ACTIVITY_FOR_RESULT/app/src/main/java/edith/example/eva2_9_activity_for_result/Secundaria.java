package edith.example.eva2_9_activity_for_result;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Secundaria extends AppCompatActivity {
    EditText edtTxtDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        edtTxtDatos = findViewById(R.id.edtTxtDatos);
    }

    public void onClickOk(View v){
        String sCade = edtTxtDatos.getText().toString();
        Intent inDatos = new Intent();
        inDatos.putExtra("DATOS", sCade);

        setResult(Activity.RESULT_OK, inDatos);

        finish();
    }

    public void onClickCancel(View v){
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}
