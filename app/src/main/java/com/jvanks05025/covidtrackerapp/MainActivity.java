package com.jvanks05025.covidtrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=findViewById(R.id.lv);
        getSuperHeroes();


    }

    private void getSuperHeroes() {
        Call<List<Results>> call= RetrofitClient.getInstance().getMyApi().getSuperHero();
        call.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
                List<Results> myheroList=response.body();
                String[] oneHeroes=new String[myheroList.size()];

                for (int i=0;i<myheroList.size();i++){
                    oneHeroes[i]=myheroList.get(i).getSuperName();
                }
                lv.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,oneHeroes));
            }

            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {

            }
        });
    }
}