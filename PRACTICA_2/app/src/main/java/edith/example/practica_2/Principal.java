package edith.example.practica_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements ListView.OnItemClickListener {
    ListView lstVwMateria;
    ImageView imgVwArea;
    TextView txtVwArea;
    Intent inDetalle;
    Materia[] amMaterias = {
            new Materia(
                    R.drawable.fundprog,
                    R.drawable.osamudazai,
                    R.drawable.prog,
                    5,
                    "Fundamentos de Programación",
                    "Osamu Dazai",
                    "Programación"
            ),
            new Materia(
                    R.drawable.poo,
                    R.drawable.doppokuni,
                    R.drawable.prog,
                    5,
                    "Programación Orientada a Objetos",
                    "Doppo Kunikida",
                    "Programación"
            ),
            new Materia(
                    R.drawable.edd,
                    R.drawable.ryuuaku,
                    R.drawable.prog,
                    5,
                    "Estructura de Datos",
                    "Ryuunosuke Akutagawa",
                    "Programación"
            ),
            new Materia(
                    R.drawable.topavprog,
                    R.drawable.sakuoda,
                    R.drawable.prog,
                    5,
                    "Tópicos Avanzados de Programación",
                    "Sakunosuke Oda",
                    "Programación"
            ),
            new Materia(
                    R.drawable.proglogfun,
                    R.drawable.chuuyanakah,
                    R.drawable.prog,
                    4,
                    "Programación Lógica y Funcional",
                    "Chuuya Nakahara",
                    "Programación"
            ),
            new Materia(
                    R.drawable.progweb,
                    R.drawable.osamudazai,
                    R.drawable.prog,
                    5,
                    "Programación Web",
                    "Osamu Dazai",
                    "Programación"
            ),
            new Materia(
                    R.drawable.fundbd,
                    R.drawable.doppokuni,
                    R.drawable.bd,
                    5,
                    "Fundamentos de Bases de Datos",
                    "Doppo Kunikida",
                    "Bases de Datos"
            ),
            new Materia(
                    R.drawable.tallbd,
                    R.drawable.ryuuaku,
                    R.drawable.bd,
                    4,
                    "Taller de Bases de Datos",
                    "Ryuunosuke Akutagawa",
                    "Bases de Datos"
            ),
            new Materia(
                    R.drawable.admbd,
                    R.drawable.sakuoda,
                    R.drawable.bd,
                    5,
                    "Administración de Bases de Datos",
                    "Sakunosuke Oda",
                    "Bases de Datos"
            ),
            new Materia(
                    R.drawable.funtele,
                    R.drawable.chuuyanakah,
                    R.drawable.redes,
                    4,
                    "Fundamentos de Telecomunicaciones",
                    "Chuuya Nakahara",
                    "Redes"
            ),
            new Materia(
                    R.drawable.redcomp,
                    R.drawable.osamudazai,
                    R.drawable.redes,
                    5,
                    "Redes de Computadoras",
                    "Osamu Dazai",
                    "Redes"
            ),
            new Materia(
                    R.drawable.conenrred,
                    R.drawable.doppokuni,
                    R.drawable.redes,
                    5,
                    "Conmutación y Enrutamiento de Redes de Datos",
                    "Doppo Kunikida",
                    "Redes"
            ),
            new Materia(
                    R.drawable.admred,
                    R.drawable.chuuyanakah,
                    R.drawable.redes,
                    4,
                    "Administración de Redes",
                    "Chuuya Nakahara",
                    "Redes"
            )
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        lstVwMateria = findViewById(R.id.lstVwMateria);
        imgVwArea = findViewById(R.id.imgVwArea);
        txtVwArea = findViewById(R.id.txtVwArea);

        lstVwMateria.setOnItemClickListener(this);
        lstVwMateria.setAdapter(new MateriaAdapter(this, R.layout.layout_materia, amMaterias));

        inDetalle = new Intent(this, Detalle.class);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bDatos = new Bundle();

        bDatos.putInt("IMG_DOC", amMaterias[position].getImg_doc());
        bDatos.putInt("MAT_CRE", amMaterias[position].getMat_cre());
        bDatos.putString("NOM_MAT", amMaterias[position].getNom_mat());
        bDatos.putString("NOM_DOC", amMaterias[position].getNom_doc());

        inDetalle.putExtras(bDatos);

        startActivity(inDetalle);

        switch (amMaterias[position].getImg_are()){
            case R.drawable.prog:
                imgVwArea.setImageResource(amMaterias[position].getImg_are());
                txtVwArea.setText(amMaterias[position].getNom_are());
                break;
            case R.drawable.bd:
                imgVwArea.setImageResource(amMaterias[position].getImg_are());
                txtVwArea.setText(amMaterias[position].getNom_are());
                break;
            case R.drawable.redes:
                imgVwArea.setImageResource(amMaterias[position].getImg_are());
                txtVwArea.setText(amMaterias[position].getNom_are());
                break;
        }
    }
}
