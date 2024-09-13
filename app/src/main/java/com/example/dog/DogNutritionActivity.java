package com.example.dog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DogNutritionActivity extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_nutrition);

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });


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
    }

    private void filterList(String text) {
        List<Model> filteredList = new ArrayList<>();
        for (Model model : modelList) {
            if (model.getmItemName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(model);
            }
        }

        if (!filteredList.isEmpty()) {
            RecyclerView recyclerView = findViewById(R.id.recyclerview);
            ModelAdapter adapter = (ModelAdapter) recyclerView.getAdapter();
            if (adapter != null) {
                adapter.setFilteredList(filteredList);  // Pass filtered list to adapter
            }
        } else {
            // Optionally handle the case when no items match the search query
            Toast.makeText(this, "No matches found", Toast.LENGTH_SHORT).show();
        }
    }

}