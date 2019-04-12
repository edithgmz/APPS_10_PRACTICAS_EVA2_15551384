package edith.example.eva2_2_contactos;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {
    Button btnContactos, btnVerContactos;
    Intent inVerContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnContactos = findViewById(R.id.btnContactos);
        btnVerContactos = findViewById(R.id.btnVerContactos);
    }

    public void onClickCon(View v){
        String sUri = "content://contacts/people";
        inVerContactos = new Intent(Intent.ACTION_VIEW, Uri.parse(sUri));
        startActivity(inVerContactos);
    }

    public void onClickVerCon(View v){
        String sUri = ContactsContract.Contacts.CONTENT_URI + "/1";
        inVerContactos = new Intent(Intent.ACTION_EDIT, Uri.parse(sUri));
        startActivity(inVerContactos);
    }
}
