package com.example.proje2_rcyclerview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class homePageActivity extends AppCompatActivity implements Interface_go_aboutClickedperson {
    RecyclerView.LayoutManager homePageActivity_layoutManager;
    RecyclerView mainactivity_recyclerview;
    List<person_model> list;
    adapter adp;
    FloatingActionButton homepage_btn_newperson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        define();
        fill();
        click_newPerson();

    }


    void define() {
        mainactivity_recyclerview = findViewById(R.id.homepage_recyclerviewid);
        homePageActivity_layoutManager = new LinearLayoutManager(this);
        list = new ArrayList<>();
        mainactivity_recyclerview.setLayoutManager(homePageActivity_layoutManager);
        homepage_btn_newperson = findViewById(R.id.floatingActionButton);


    }

    void fill() {
        person_model kisi1 = new person_model("Recep Arslan", R.drawable.erkek, R.drawable.hayir);
        person_model kisi2 = new person_model("elif Türk", R.drawable.kadin, R.drawable.evet);
        person_model kisi3 = new person_model("Ayşe fatma", R.drawable.kadin, R.drawable.evet);
        person_model kisi4 = new person_model("Barbara Palvin", R.drawable.kadin, R.drawable.hayir);
        person_model kisi5 = new person_model("Kazım Kazm", R.drawable.erkek, R.drawable.hayir);
        list.add(kisi1);
        list.add(kisi2);
        list.add(kisi3);
        list.add(kisi4);
        list.add(kisi5);

        Log.i("abc", "" + list.get(3).getName());
        adp = new adapter(this, list, this);
        mainactivity_recyclerview.setAdapter(adp);


    }

    void click_newPerson() {
        homepage_btn_newperson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), createNewPerson.class);
                startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {

            String kisiYeniAdSoyad = data.getStringExtra(Utility.name);
            int kisiYeniCalismaDurumu = data.getIntExtra(Utility.working, 0);
            int KisiYeniCinsiyet = data.getIntExtra(Utility.gender, 0);
            add(KisiYeniCinsiyet, kisiYeniAdSoyad, kisiYeniCalismaDurumu);
        } else if (resultCode == 2) {
            list.remove(data.getIntExtra(Utility.delete, 0));
            mainactivity_recyclerview.setAdapter(adp);


        }
    }

    void add(int kisiCinsiyet, String kisiYeniAdSoyad, int kisiCalismaDurumu) {

        person_model m = new person_model(kisiYeniAdSoyad, kisiCinsiyet, kisiCalismaDurumu);
        list.add(m);
        mainactivity_recyclerview.setAdapter(adp);


    }


    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, aboutClickedperson.class);
        intent.putExtra(Utility.name, list.get(position).getName());
        intent.putExtra(Utility.gender, list.get(position).getGender());
        intent.putExtra(Utility.working, list.get(position).getWork());
        intent.putExtra(Utility.objectid, position);
        startActivityForResult(intent, 2);
    }
}