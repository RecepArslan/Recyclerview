package com.example.proje2_rcyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class createNewPerson extends AppCompatActivity {
    RadioGroup radio_group_cinsiyet, radio_group_calismaDurumu;
    EditText editText_yeniAdSoyad;
    Button btn_yeniKisiOlustur;
    RadioButton radiobtn_cinsiyetSecim, radiobtn_calismadurumusecim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_person);
        tanimla();
        clickbutton();

    }

    void tanimla() {
        radio_group_cinsiyet = findViewById(R.id.radiogrp_gender);
        radio_group_calismaDurumu = findViewById(R.id.radiogrp_work);
        editText_yeniAdSoyad = findViewById(R.id.yenikisi_isim_edittext);
        btn_yeniKisiOlustur = findViewById(R.id.yenikisi_ekle_btn);


    }

    void clickbutton() {

        btn_yeniKisiOlustur.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                person_model temp = createnewperson();
                if (temp != null) {
                    Intent intent = new Intent(getApplicationContext(), homePageActivity.class);
                    intent.putExtra(Utility.name, createnewperson().getName());
                    intent.putExtra(Utility.gender, createnewperson().getGender());
                    intent.putExtra(Utility.working, createnewperson().getWork());
                    ;
                    setResult(1, intent);
                    finish();

                } else
                    Toast.makeText(getApplicationContext(), R.string.eksikbilgi, Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, homePageActivity.class);
        setResult(3, intent);
        finish();
        super.onBackPressed();
    }

    person_model createnewperson() {
        if (check()) {
            String adsoyad = editText_yeniAdSoyad.getText().toString();
            radiobtn_cinsiyetSecim = findViewById(radio_group_cinsiyet.getCheckedRadioButtonId());
            String cinsiyetS = radiobtn_cinsiyetSecim.getText().toString();
            radiobtn_calismadurumusecim = findViewById(radio_group_calismaDurumu.getCheckedRadioButtonId());
            String isdurumuS = radiobtn_calismadurumusecim.getText().toString();
            int cinsiyetint;
            int isdurumInt;
            if (cinsiyetS.equals("Kadın")) {
                cinsiyetint = R.drawable.kadin;
            } else {
                cinsiyetint = R.drawable.erkek;
            }
            if (isdurumuS.equals("Çalışıyor")) {
                isdurumInt = R.drawable.evet;
            } else {
                isdurumInt = R.drawable.hayir;
            }

            person_model temp = new person_model(adsoyad, cinsiyetint, isdurumInt);

            return temp;
        } else {

            return null;

        }
    }

    boolean check() {


        if (radio_group_cinsiyet.getCheckedRadioButtonId() == -1) return false;
        else if (radio_group_calismaDurumu.getCheckedRadioButtonId() == -1) return false;
        else if (editText_yeniAdSoyad.getText().toString().equals("")) return false;
        else return true;
    }
}