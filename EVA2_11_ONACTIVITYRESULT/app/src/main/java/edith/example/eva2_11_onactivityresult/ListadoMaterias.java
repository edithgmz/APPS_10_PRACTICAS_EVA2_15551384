package edith.example.eva2_11_onactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListadoMaterias extends AppCompatActivity implements ListView.OnItemClickListener {
    ListView lstVwMaterias;
    String[] asMaterias = {
            "Fundamentos de programación",
            "Programación orientada a objetos",
            "Estructura de datos",
            "Tópicos avanzados de programación",
            "Graficación",
            "Programación web",
            "Apps 1",
            "Apps 2",
            "Apps 3",
            "Apps Hibridas"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_materias);

        lstVwMaterias = findViewById(R.id.lstVwMaterias);
        lstVwMaterias.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, asMaterias));
        lstVwMaterias.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        Intent inDatos = new Intent();
        inDatos.putExtra("MATERIAS", asMaterias[i]);
        setResult(Activity.RESULT_OK, inDatos);
        finish();
    }
}
