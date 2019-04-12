package edith.example.practica_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Principal extends AppCompatActivity implements ListView.OnItemClickListener {
    ListView lstVwRest;
    Intent inDetalle;
    Restaurante[] arRestaurantes = {
            new Restaurante(R.drawable.barrafina,
                    "Barra Fina",
                    "Restaurante Gourmet",
                    "\tPeriférico de la Juventud #312 Distrito 1",
                    "472-8500"),
            new Restaurante(R.drawable.bourkestreetbakery,
                    "Bourke Street Bakery",
                    "Pastelería y café",
                    "\tBarangaroo Avenue #4/23",
                    "831-9468"),
            new Restaurante(R.drawable.cafedeadend,
                    "Cafe Deadend",
                    "Café",
                    "\tPo Hing Fong #72",
                    "671-7005"),
            new Restaurante(R.drawable.cafeloisl,
                    "Cafe Loisl",
                    "Café",
                    "\tTai On Terrace #88",
                    "917-0209"),
            new Restaurante(R.drawable.cafelore,
                    "Cafe Loré",
                    "Restaurante Italiano",
                    "\t4th Avenue #4601",
                    "718-4927"),
            new Restaurante(R.drawable.confessional,
                    "Pizzas Italianissimo",
                    "Pizzas Tradicionales",
                    "\tAvenida Mirador #4723",
                    "423-4000"),
            new Restaurante(R.drawable.donostia,
                    "Donostia",
                    "Restaurante",
                    "\t29 Bis #5-84",
                    "287-3943"),
            new Restaurante(R.drawable.fiveleaves,
                    "Five Leaves",
                    "Restaurante Tradicional Americano",
                    "\tBedford Avenue #18",
                    "718-3835"),
            new Restaurante(R.drawable.forkeerestaurant,
                    "For Kee Restaurant",
                    "Café",
                    "\tHollywood Rd #200",
                    "254-6894"),
            new Restaurante(R.drawable.grahamavenuemeats,
                    "Graham Avenue Meats & Deli",
                    "Restaurante Gourmet",
                    "\tGraham Avenue #445",
                    "718-3830"),
            new Restaurante(R.drawable.haighschocolate,
                    "Haigh's Chocolates",
                    "Tienda de chocolate",
                    "\tThe Groove Shopping Centre Local #24",
                    "882-8884"),
            new Restaurante(R.drawable.homei,
                    "il Caffè",
                    "Cafe Tsukiyama",
                    "\tS Broadway #855",
                    "213-6120"),
            new Restaurante(R.drawable.palominoespresso,
                    "Palomino Espresso",
                    "Espresso Bar",
                    "\tYork St #1/61",
                    "411-4077"),
            new Restaurante(R.drawable.petiteoyster,
                    "Petite Oyster",
                    "Restaurante Francés",
                    "\tSai St #44",
                    "254-9080"),
            new Restaurante(R.drawable.posatelier,
                    "Po's Atelier",
                    "Pastelería",
                    "\tPo Hing Fong #70",
                    "605-6800"),
            new Restaurante(R.drawable.royaloak,
                    "Royal Oak Restaurant",
                    "Restaurante Griego",
                    "\tFrase Highway #15336",
                    "604-5813"),
            new Restaurante(R.drawable.teakha,
                    "Teakha",
                    "Café",
                    "\tTai Ping Shan St #18B",
                    "604-5813"),
            new Restaurante(R.drawable.thaicafe,
                    "Thai Cafe",
                    "Café",
                    "\tW Central Avenue #109",
                    "254-5982"),
            new Restaurante(R.drawable.traif,
                    "Traif",
                    "\tRestaurante Americano",
                    "S 4th Sth #229",
                    "347-8449"),
            new Restaurante(R.drawable.upstate,
                    "Upstate Tavern",
                    "Bar & Grill",
                    "\tPatrick Rd #5218",
                    "800-7717"),
            new Restaurante(R.drawable.wafflewolf,
                    "Waffle & Wolf",
                    "Tienda de sándwiches",
                    "\tGraham Avenue #413",
                    "850-5410")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        lstVwRest = findViewById(R.id.lstVwRest);
        lstVwRest.setAdapter(new RestauranteAdapter(this, R.layout.layout_restaurante,arRestaurantes));
        lstVwRest.setOnItemClickListener(this);

        inDetalle = new Intent(this, Detalle.class);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        Bundle bDatos = new Bundle();
        bDatos.putInt("IMG_REST", arRestaurantes[i].getImg_rest());
        bDatos.putString("NOM_REST", arRestaurantes[i].getNom_rest());
        bDatos.putString("DESC_REST", arRestaurantes[i].getDesc_rest());
        bDatos.putString("DIR_REST", arRestaurantes[i].getDir_rest());
        bDatos.putString("TEL_REST", arRestaurantes[i].getTel_rest());
        inDetalle.putExtras(bDatos);
        startActivity(inDetalle);
    }
}
