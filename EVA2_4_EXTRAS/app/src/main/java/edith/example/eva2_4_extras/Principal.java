package edith.example.eva2_4_extras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Principal extends AppCompatActivity implements ListView.OnItemClickListener {
    Intent inSecundaria;
    final String[] asMaterias = {
            "Fundamentos de programación",
            "Programación orientada a objetos",
            "Estructuras de datos",
            "Tópicos avanzados de programación",
            "Graficación",
            "Programación web",
            "Aplicaciones 1",
            "Aplicaciones 2",
            "Aplicaciones 3",
            "Aplicaciones Híbridas",
            "Tópicos selectos"
    };
    final String[] asProfes = {
            "Royce Rodriguez",
            "Hector Fuentes Ochos",
            "Ignacio Villalobos",
            "Marisela Caldera",
            "Mario Espadas",
            "Leonardo Nevarez",
            "Ruben Hernandez",
            "Leonardo Nevares",
            "Un wey nuevo",
            "El mismo wey nuevo",
            "Marisela Caldera"
    };
    ListView lstVwMaterias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lstVwMaterias = findViewById(R.id.lstVwMaterias);
        lstVwMaterias.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, asMaterias));
        lstVwMaterias.setOnItemClickListener(this);
        inSecundaria = new Intent(this, Secundaria.class);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        //Enviar a Secundaria el maestro que da la materia
        inSecundaria.putExtra("MAESTRO", asProfes[i]);
        startActivity(inSecundaria);
    }
}
