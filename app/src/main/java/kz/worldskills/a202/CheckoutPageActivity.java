package kz.worldskills.a202;

import static kz.worldskills.a202.Food.cardFoods;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckoutPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_page);


        ImageView tamak1_suret = findViewById(R.id.tamak1_suret);
        TextView tamak1_title = findViewById(R.id.tamak1_title);
        TextView tamak1_price = findViewById(R.id.tamak1_price);
        TextView tamak1_desc = findViewById(R.id.tamak1_desc);

        ImageView tamak2_suret = findViewById(R.id.tamak2_suret);
        TextView tamak2_title = findViewById(R.id.tamak2_title);
        TextView tamak2_price = findViewById(R.id.tamak2_price);
        TextView tamak2_desc = findViewById(R.id.tamak2_desc);

        if (cardFoods.size() == 1) {
            tamak1_suret.setImageResource(cardFoods.get(0).image_url);
            tamak1_title.setText(cardFoods.get(0).name);
            tamak1_price.setText(cardFoods.get(0).price);
            tamak1_desc.setText(cardFoods.get(0).remark);

        }else if (cardFoods.size() == 2) {

            tamak1_suret.setImageResource(cardFoods.get(0).image_url);
            tamak1_title.setText(cardFoods.get(0).name);
            tamak1_price.setText(cardFoods.get(0).price);
            tamak1_desc.setText(cardFoods.get(0).remark);

            tamak2_suret.setImageResource(cardFoods.get(1).image_url);
            tamak2_title.setText(cardFoods.get(1).name);
            tamak2_price.setText(cardFoods.get(1).price);
            tamak2_desc.setText(cardFoods.get(1).remark);

        }else if (cardFoods.size() == 3) {
//
//            tamak1_suret.setImageResource(cardFoods.get(0).image_url);
//            tamak1_title.setText(cardFoods.get(0).name);
//            tamak1_price.setText(cardFoods.get(0).price);
//            tamak1_desc.setText(cardFoods.get(0).remark);
//
//            tamak2_suret.setImageResource(cardFoods.get(1).image_url);
//            tamak2_title.setText(cardFoods.get(1).name);
//            tamak2_price.setText(cardFoods.get(1).price);
//            tamak2_desc.setText(cardFoods.get(1).remark);
//
//            tamak3_suret.setImageResource(cardFoods.get(2).image_url);
//            tamak3_title.setText(cardFoods.get(2).name);
//            tamak3_price.setText(cardFoods.get(2).price);
//            tamak3_desc.setText(cardFoods.get(2).remark);

        }

//        cardFoods
        Button add_dish = findViewById(R.id.add_dish);
        add_dish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckoutPageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button checkout = findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CheckoutPageActivity.this);
                builder.setMessage("Whether to check out")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Intent intent = new Intent(CheckoutPageActivity.this, SuccessfulCheckoutActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });

                builder.show();
            }
        });
    }
}