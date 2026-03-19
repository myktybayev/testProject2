package kz.worldskills.a202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        Button menuBtn = findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnMenu1 = findViewById(R.id.btnMenu1);
        Button btnMenu2 = findViewById(R.id.btnMenu2);
        Button btnMenu3 = findViewById(R.id.btnMenu3);

        ImageView tamak1 = findViewById(R.id.tamak1);
        ImageView tamak2 = findViewById(R.id.tamak2);
        ImageView tamak3 = findViewById(R.id.tamak3);
        ImageView tamak4 = findViewById(R.id.tamak4);
        ImageView tamak5 = findViewById(R.id.tamak5);

        TextView tamak1_title = findViewById(R.id.tamak1_title);
        TextView tamak2_title = findViewById(R.id.tamak2_title);
        TextView tamak3_title = findViewById(R.id.tamak3_title);
        TextView tamak4_title = findViewById(R.id.tamak4_title);
        TextView tamak5_title = findViewById(R.id.tamak5_title);

        TextView tamak1_price = findViewById(R.id.tamak1_price);
        TextView tamak2_price = findViewById(R.id.tamak2_price);
        TextView tamak3_price = findViewById(R.id.tamak3_price);
        TextView tamak4_price = findViewById(R.id.tamak4_price);
        TextView tamak5_price = findViewById(R.id.tamak5_price);

        TextView tamak1_desc = findViewById(R.id.tamak1_desc);
        TextView tamak2_desc = findViewById(R.id.tamak2_desc);
        TextView tamak3_desc = findViewById(R.id.tamak3_desc);
        TextView tamak4_desc = findViewById(R.id.tamak4_desc);
        TextView tamak5_desc = findViewById(R.id.tamak5_desc);

        ImageView tamak1_minus = findViewById(R.id.tamak1_minus);
        ImageView tamak2_minus = findViewById(R.id.tamak2_minus);
        ImageView tamak3_minus = findViewById(R.id.tamak3_minus);
        ImageView tamak4_minus = findViewById(R.id.tamak4_minus);
        ImageView tamak5_minus = findViewById(R.id.tamak5_minus);

        TextView tamak1_san = findViewById(R.id.tamak1_san);
        TextView tamak2_san = findViewById(R.id.tamak2_san);
        TextView tamak3_san = findViewById(R.id.tamak3_san);
        TextView tamak4_san = findViewById(R.id.tamak4_san);
        TextView tamak5_san = findViewById(R.id.tamak5_san);

        ImageView tamak1_plus = findViewById(R.id.tamak1_plus);
        ImageView tamak2_plus = findViewById(R.id.tamak2_plus);
        ImageView tamak3_plus = findViewById(R.id.tamak3_plus);
        ImageView tamak4_plus = findViewById(R.id.tamak4_plus);
        ImageView tamak5_plus = findViewById(R.id.tamak5_plus);


        btnMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tamak1.setImageDrawable(getDrawable(R.drawable.type_1_01));
                tamak2.setImageDrawable(getDrawable(R.drawable.type_1_02));
                tamak3.setImageDrawable(getDrawable(R.drawable.type_1_03));
                tamak4.setImageDrawable(getDrawable(R.drawable.type_1_04));
                tamak5.setImageDrawable(getDrawable(R.drawable.type_1_05));

                tamak1_title.setText("Brie Cheese ");
                tamak2_title.setText("Conte Cheese ");
                tamak3_title.setText("Camembert Cheese ");
                tamak4_title.setText("Baguette ");
                tamak5_title.setText("Brioche ");


                tamak1_price.setText("33");
                tamak2_price.setText("38");
                tamak3_price.setText("33.8");
                tamak4_price.setText("25");
                tamak5_price.setText("38");

                tamak1_desc.setText("Sign must be ordered, netizens recommend ");
                tamak2_desc.setText("Monthly sales 70");
                tamak3_desc.setText("Monthly sales 100+ praise 60%");
                tamak4_desc.setText("Monthly sales 100+ praise 100%");
                tamak5_desc.setText("Monthly sales 88");

            }
        });

        btnMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tamak1.setImageDrawable(getDrawable(R.drawable.type_2_01));
                tamak2.setImageDrawable(getDrawable(R.drawable.type_2_02));
                tamak3.setImageDrawable(getDrawable(R.drawable.type_2_03));
                tamak4.setImageDrawable(getDrawable(R.drawable.type_2_04));
                tamak5.setImageDrawable(getDrawable(R.drawable.type_2_05));

                tamak1_title.setText("Brittany Oyster ");
                tamak2_title.setText("Lobster Biske ");
                tamak3_title.setText("Cod pickle ");
                tamak4_title.setText("Shrimp vermicelli Salad ");
                tamak5_title.setText("Seafood burger ");


                tamak1_price.setText("48");
                tamak2_price.setText("138");
                tamak3_price.setText("88");
                tamak4_price.setText("66");
                tamak5_price.setText("59");

                tamak1_desc.setText("Number four ");
                tamak2_desc.setText("Number two in sales ");
                tamak3_desc.setText("Recently 100+ people order ");
                tamak4_desc.setText("Monthly sales 100+");
                tamak5_desc.setText("Kids like to eat online comments ");
            }
        });

        btnMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tamak1.setImageDrawable(getDrawable(R.drawable.type_3_01));
                tamak2.setImageDrawable(getDrawable(R.drawable.type_3_02));
                tamak3.setImageDrawable(getDrawable(R.drawable.type_3_03));
                tamak4.setImageDrawable(getDrawable(R.drawable.type_3_04));
                tamak5.setImageDrawable(getDrawable(R.drawable.type_3_05));

                tamak1_title.setText("333");
                tamak2_title.setText("333");
                tamak3_title.setText("333");
                tamak4_title.setText("333");
                tamak5_title.setText("333");


                tamak1_price.setText("333");
                tamak2_price.setText("333");
                tamak3_price.setText("333");
                tamak4_price.setText("333");
                tamak5_price.setText("333");

                tamak1_desc.setText("333");
                tamak2_desc.setText("333");
                tamak3_desc.setText("333");
                tamak4_desc.setText("333");
                tamak5_desc.setText("333");
            }
        });

        tamak2_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tamak2_san.setText("1");

                tamak2_minus.setVisibility(View.VISIBLE);
                tamak2_san.setVisibility(View.VISIBLE);
            }
        });

        tamak3_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tamak3_san.setText("1");

                tamak3_minus.setVisibility(View.VISIBLE);
                tamak3_san.setVisibility(View.VISIBLE);
            }
        });

        tamak4_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tamak4_san.setText("1");

                tamak4_minus.setVisibility(View.VISIBLE);
                tamak4_san.setVisibility(View.VISIBLE);
            }
        });

        tamak5_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tamak5_san.setText("1");

                tamak5_minus.setVisibility(View.VISIBLE);
                tamak5_san.setVisibility(View.VISIBLE);
            }
        });
    }
}