package com.example.dog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import android.animation.ArgbEvaluator;

public class StartActivity extends AppCompatActivity {

    private ConstraintLayout start_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Set up the start button click listener
        start_button = findViewById(R.id.go_button);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this, RegisterActivity.class));
            }
        });

        // Set up the animated text
        TextView animatedText = findViewById(R.id.animatedText);

        // Color change animation
        int colorFrom = ContextCompat.getColor(this, R.color.purple_700);
        int colorTo = ContextCompat.getColor(this, R.color.red);

        ValueAnimator colorAnimation = ObjectAnimator.ofInt(animatedText, "textColor", colorFrom, colorTo);
        colorAnimation.setDuration(1000); // Duration of the animation
        colorAnimation.setEvaluator(new ArgbEvaluator());
        colorAnimation.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimation.setRepeatMode(ValueAnimator.REVERSE);
        colorAnimation.start();

        // Shining effect animation
        ObjectAnimator shineAnimator = ObjectAnimator.ofFloat(animatedText, "alpha", 0.5f, 1f);
        shineAnimator.setDuration(500);
        shineAnimator.setInterpolator(new LinearInterpolator());
        shineAnimator.setRepeatCount(ValueAnimator.INFINITE);
        shineAnimator.setRepeatMode(ValueAnimator.REVERSE);
        shineAnimator.start();
    }
}
