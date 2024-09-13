package com.example.dog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectionActivity extends AppCompatActivity {
    Button  dog_education_btn;
    Button dog_nutrition_btn;
    Button order_dog_nutrition_btn;
    Button dog_medicine_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);


        dog_education_btn = findViewById(R.id.buttonDogEducation);
        dog_nutrition_btn = findViewById(R.id.buttonDogNutrition);
        dog_medicine_btn = findViewById(R.id.buttonDogMedicine);
        order_dog_nutrition_btn = findViewById(R.id.buttonOrderDogNutrition);


        dog_education_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectionActivity.this, DogEducationActivity.class));
            }
        });

        dog_nutrition_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectionActivity.this, DogNutritionActivity.class));
            }
        });

        dog_medicine_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectionActivity.this, DogMedicineActivity.class));
            }
        });


        order_dog_nutrition_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectionActivity.this, OrderDogNutritionActivity.class));
            }
        });

    }
}