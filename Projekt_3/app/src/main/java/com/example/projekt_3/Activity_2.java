package com.example.projekt_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_2 extends AppCompatActivity implements View.OnClickListener {

    private TextView tvTytul_2;
    private TextView tvImie;
    private TextView tvRokAkt;
    private TextView tvRok;
    private TextView tvLata;
    private Button bDo1Okna;
    private int rok2, rokAkt2;
    private String imie2;
    private int lata2;
    private Intent odIntentActivity1;
    //public Intent paczkaDo1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvTytul_2 = (TextView) findViewById(R.id.tvTytul_2);
        tvImie = (TextView) findViewById(R.id.tvImie);
        tvRok = (TextView) findViewById(R.id.tvRok);
        tvRokAkt = (TextView) findViewById(R.id.tvRokAkt);
        tvLata = (TextView) findViewById(R.id.tvLata);
        bDo1Okna = (Button) findViewById(R.id.bDo1Okna);

        bDo1Okna.setOnClickListener(this);

    }


    @Override
    protected void onResume() {
        super.onResume();

        odIntentActivity1 = getIntent();

        Bundle paczka2 = odIntentActivity1.getBundleExtra("paczka");
        imie2 = paczka2.getString("imie");
        rok2 = paczka2.getInt("rok");
        rokAkt2 = paczka2.getInt("rokAkt");
        lata2 = rokAkt2 - rok2;

        tvImie.setText(String.format("Witaj %s !",imie2));
        tvRokAkt.setText("Mamy rok: "+rokAkt2);
        tvRok.setText("Urodziles/as sie w:  "+rok2);
        tvLata.setText("Masz "+lata2+" lat");

    }

    public void ReturnResult(){

        Bundle paczka2 = new Bundle();
        paczka2.putInt("lata2",lata2);
        odIntentActivity1.putExtra("paczka2",paczka2);
        this.setResult(RESULT_OK,odIntentActivity1);
        this.finish();

    }

    @Override
    public void onClick(View view) {
        ReturnResult();
    }
}
