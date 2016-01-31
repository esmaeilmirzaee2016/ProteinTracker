package com.scalaprogramming.proteintracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    @Bind(R.id.SGender)
    Spinner sGender;
    @Bind(R.id.ACBtnBirthday)
    Button acbtnBirthday;
//    @Bind(R.id.ACSFood) Spinner acsFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);


        /**
         * Gender Selector
         */

        sGender = (Spinner) findViewById(R.id.SGender);
        String[] sGenderValues = new String[]{"male", "female"};
        ArrayAdapter<String> sGenderItem =
                new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, sGenderValues);
        sGender.setAdapter(sGenderItem);
        sGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int selectedItem, long items) {
                switch (selectedItem) {
                    case 0:
                        Toast.makeText(getBaseContext(), "0", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getBaseContext(), "1", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(getBaseContext(), "Anything", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getBaseContext(), "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });


        /**
         * Food Selector
         */
        Spinner acsFood = (Spinner) findViewById(R.id.ACSFood);
        String[] foodValue = new String[]{"", "Rice", "Orange", "Apple", "More"};
        ArrayAdapter<String> foodItem =
                new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, foodValue);
        acsFood.setAdapter(foodItem);
        acsFood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int selectedItem, long items) {
                switch (selectedItem) {
                    case 0:
                        Toast.makeText(getBaseContext(), "Chose One Of Item Then Press Right Add Button", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(getBaseContext(), "Calories of Rice = ", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(getBaseContext(), "Calories of Orange = ", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(getBaseContext(), "Calories of Apple = ", Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Toast.makeText(getBaseContext(), "Add more Item... ", Toast.LENGTH_LONG).show();
                        break;
                    default:
                        Toast.makeText(getBaseContext(), "DEFAULT ITEM HAS NOT BEEN NEVER CHOSEN", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getBaseContext(), "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });

        acbtnBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Something ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}