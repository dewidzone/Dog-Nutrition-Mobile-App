package com.example.dog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class OrderDogNutritionActivity extends AppCompatActivity{

    List<Model> modelList;
    RecyclerView recyclerView;
    OrderAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_dog_nutrition);

        modelList = new ArrayList<>();
        modelList.add(new Model("Raw Ternative", getString(R.string.rawternative), R.drawable.rawternative));
        modelList.add(new Model("Pedigree", getString(R.string.pedigree), R.drawable.pedigree));
        modelList.add(new Model("Wellness Core", getString(R.string.wellnesscore), R.drawable.wellnesscore));
        modelList.add(new Model("Purina Pro Plan", getString(R.string.purinapro), R.drawable.purinapro));
        modelList.add(new Model("Royal Canin", getString(R.string.royalcanin), R.drawable.royalcanin));
        modelList.add(new Model("Nextrition", getString(R.string.nextrition), R.drawable.nextrition));
        modelList.add(new Model("Hill's Science", getString(R.string.hillscience), R.drawable.hill));
        modelList.add(new Model("Blue Buffalo", getString(R.string.bluebuffalo), R.drawable.bluebuffalo));
        modelList.add(new Model("Nutro Ultra", getString(R.string.nutroultra), R.drawable.nutroultra));
        modelList.add(new Model("Taste of wild", getString(R.string.tasteofthewild), R.drawable.tasteofwild));
        modelList.add(new Model("Acana", getString(R.string.acana), R.drawable.acana));

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ModelAdapter(this, modelList));

        // adapter
        mAdapter = new OrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdapter);

    }
}
