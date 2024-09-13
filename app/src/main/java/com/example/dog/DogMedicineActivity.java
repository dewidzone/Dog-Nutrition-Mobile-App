package com.example.dog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DogMedicineActivity extends AppCompatActivity {


    List<Model> modelList;
    RecyclerView Recyclerview;
    SearchView Searchview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_medicine);

        Searchview = findViewById(R.id.searchView2);
        Searchview.clearFocus();
        Searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        modelList.add(new Model("Defender Pro", getString(R.string.defenderpro), R.drawable.defenderpro));
        modelList.add(new Model("Dermisule", getString(R.string.dermisule), R.drawable.dermisule));
        modelList.add(new Model("Neomec", getString(R.string.neomec), R.drawable.neomec));
        modelList.add(new Model("Nexgard", getString(R.string.nexgard), R.drawable.nexgard));
        modelList.add(new Model("Pet Vit Power", getString(R.string.petvitpower), R.drawable.petvitpower));
        modelList.add(new Model("Simparica", getString(R.string.simparica), R.drawable.simparica));
        modelList.add(new Model("Kennel Cough", getString(R.string.kennelcough), R.drawable.cough));
        modelList.add(new Model("Sanpet Plus", getString(R.string.sanpetplus), R.drawable.sanpetplus));
        modelList.add(new Model("Para gard", getString(R.string.paragard), R.drawable.paragard));


        Recyclerview = findViewById(R.id.recyclerview2);
        Recyclerview.setLayoutManager(new LinearLayoutManager(this));
        Recyclerview.setAdapter(new ModelAdapter(this, modelList));

    }

    private void filterList(String text) {
        List<Model> filteredList = new ArrayList<>();
        for (Model model : modelList) {
            if (model.getmItemName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(model);
            }
        }

        if (!filteredList.isEmpty()) {
            RecyclerView recyclerView = findViewById(R.id.recyclerview2);
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