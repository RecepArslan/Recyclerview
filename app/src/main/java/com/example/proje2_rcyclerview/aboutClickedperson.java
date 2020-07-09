package com.example.proje2_rcyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class aboutClickedperson extends AppCompatActivity {
    TextView adsoyad, cinsiyet, isdurumu;
    Button btn;
    int sil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_clickedperson);
        tanimla();
        bilgilerial();
        sil();
    }


    void tanimla() {
        adsoyad = findViewById(R.id.bilgileriGoster_textview_ad);
        cinsiyet = findViewById(R.id.bilgileriGoster_textview_cinsiyet);
        isdurumu = findViewById(R.id.bilgileriGoster_textview_Calisma);
        btn = findViewById(R.id.bilgileriGoster_btn_sil);

    }

    void bilgilerial() {
        Bundle bundle = getIntent().getExtras();
        String adString = bundle.getString(Utility.name);
        int cinsiyetInt = bundle.getInt(Utility.gender);
        int isDurumuInt = bundle.getInt(Utility.working);
        sil = bundle.getInt(Utility.objectid);

        if (cinsiyetInt == R.drawable.erkek) cinsiyet.setText(R.string.aboutclickedperson_genderman);
        else cinsiyet.setText(R.string.aboutclickedperson_genderwoman);
        if (isDurumuInt == R.drawable.evet) isdurumu.setText(R.string.aboutclickedperson_workingyes);
        else isdurumu.setText(R.string.aboutclickedperson_workingno);
        adsoyad.setText(adString);

    }

    void sil() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), homePageActivity.class);
                intent.putExtra(Utility.delete, sil);
                setResult(2, intent);
                finish();
            }
        });


    }
}