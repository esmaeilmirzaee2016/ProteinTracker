package com.scalaprogramming.proteintracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AppActivity extends AppCompatActivity {

    private Button bAccount;
    private Button bFreeAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        bAccount = (Button) findViewById(R.id.BAccount);
        bAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                bFreeAccount.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(AppActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        bFreeAccount = (Button) findViewById(R.id.BFreeCalculation);
        bFreeAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
