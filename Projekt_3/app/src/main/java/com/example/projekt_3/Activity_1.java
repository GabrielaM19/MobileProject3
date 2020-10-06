package com.example.projekt_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Activity_1 extends AppCompatActivity implements View.OnClickListener {


    Intent go2ActIntent;
    private TextView tvTytul_1;
    private Button bDo2Okna;
    private TextView tvImie;
    private TextView tvRok;
    private TextView tvLata;
    private TextView tvRokAkt;
    private EditText etImie;
    private EditText etRok;
    private EditText etRokAkt;
    int rok, rokAkt, lata;
    String imie,roket,rokAktet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        tvTytul_1 = (TextView) findViewById(R.id.tvTytul_1);
        tvImie = (TextView) findViewById(R.id.tvImie);
        tvRok = (TextView) findViewById(R.id.tvRok);
        tvRokAkt = (TextView) findViewById(R.id.tvRokAkt);
        tvLata = (TextView) findViewById(R.id.tvLata);
        etImie = (EditText) findViewById(R.id.etImie);
        etRokAkt = (EditText) findViewById(R.id.etRokAkt);
        etRok = (EditText) findViewById(R.id.etRok);
        bDo2Okna = (Button) findViewById(R.id.bDo2Okna);


        bDo2Okna.setOnClickListener(this);

    }


    public void idzDoActivity2(View view){

        go2ActIntent = new Intent(getApplicationContext(), Activity_2.class);

        Bundle paczka = new Bundle();
        paczka.putInt("rok",rok);
        paczka.putString("imie",imie);
        paczka.putInt("rokAkt",rokAkt);

        go2ActIntent.putExtra("paczka",paczka);
        //startActivity(go2ActIntent);
        startActivityForResult(go2ActIntent,1234);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            lata=data.getBundleExtra("paczka2").getInt("lata2");
            tvLata.setText("Masz "+lata+" lat/a"
                    );
        }
    }

    @Override
    public void onClick(View view) {
        imie = etImie.getText().toString();
        roket = etRok.getText().toString();
        rok = Integer.decode(roket);
        rokAktet = etRokAkt.getText().toString();
        rokAkt = Integer.decode(rokAktet);
        idzDoActivity2(view);
    }
}
