package com.Moch_Zukhruf_Ain_F55121034.aplikasi_uts;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private HeroAdapter adapter;
    private ArrayList<Hero> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new HeroAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);
        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int Position, long id) {
                if (Position == 0) {
                    startActivity(new Intent(MainActivity.this, file1.class));
                }
                else if (Position == 1){
                    startActivity(new Intent(MainActivity.this, ActivityDetail.class));
                }
                else if (Position == 2){
                    startActivity(new Intent(MainActivity.this, file2.class));
                }
                else if (Position == 3){
                    startActivity(new Intent(MainActivity.this, file3.class));
                }
            }
        });
    }
    private void prepare() {
        dataName =
                getResources().getStringArray(R.array.data_name);
        dataDescription =
                getResources().getStringArray(R.array.data_description);
        dataPhoto =
                getResources().obtainTypedArray(R.array.data_photo);
    }
    private void addItem() {
        heroes = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Hero hero = new Hero();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            heroes.add(hero);
        }
        adapter.setHeroes(heroes);
    }
}