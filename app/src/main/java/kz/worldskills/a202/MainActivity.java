package kz.worldskills.a202;

import static kz.worldskills.a202.Food.cardFoods;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Food> foodArrayList;
    ImageView tamak1_suret, tamak2_suret, tamak3_suret, tamak4_suret, tamak5_suret, tamak6_suret;
    TextView tamak1_name, tamak1_desc, tamak2_name, tamak2_desc, tamak3_name, tamak3_desc, tamak4_name, tamak4_desc, tamak5_name, tamak5_desc, tamak6_name, tamak6_desc;
    RatingBar tamak1_ratingBar, tamak2_ratingBar, tamak3_ratingBar, tamak4_ratingBar, tamak5_ratingBar, tamak6_ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodArrayList = new ArrayList<>();

        tamak1_suret = findViewById(R.id.tamak1_suret);
        tamak2_suret = findViewById(R.id.tamak2_suret);
        tamak3_suret = findViewById(R.id.tamak3_suret);
        tamak4_suret = findViewById(R.id.tamak4_suret);
        tamak5_suret = findViewById(R.id.tamak5_suret);
        tamak6_suret = findViewById(R.id.tamak6_suret);

        tamak1_name = findViewById(R.id.tamak1_name);
        tamak1_desc = findViewById(R.id.tamak1_desc);
        tamak2_name = findViewById(R.id.tamak2_name);
        tamak2_desc = findViewById(R.id.tamak2_desc);
        tamak3_name = findViewById(R.id.tamak3_name);
        tamak3_desc = findViewById(R.id.tamak3_desc);
        tamak4_name = findViewById(R.id.tamak4_name);
        tamak4_desc = findViewById(R.id.tamak4_desc);
        tamak5_name = findViewById(R.id.tamak5_name);
        tamak5_desc = findViewById(R.id.tamak5_desc);
        tamak6_name = findViewById(R.id.tamak6_name);
        tamak6_desc = findViewById(R.id.tamak6_desc);

        tamak1_ratingBar = findViewById(R.id.tamak1_ratingBar);
        tamak2_ratingBar = findViewById(R.id.tamak2_ratingBar);
        tamak3_ratingBar = findViewById(R.id.tamak3_ratingBar);
        tamak4_ratingBar = findViewById(R.id.tamak4_ratingBar);
        tamak5_ratingBar = findViewById(R.id.tamak5_ratingBar);
        tamak6_ratingBar = findViewById(R.id.tamak6_ratingBar);


        Button categoryBtn = findViewById(R.id.categoryBtn);
        categoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        tamak1_suret.setOnClickListener(view -> foodDetailDialog(0));
        tamak2_suret.setOnClickListener(view -> foodDetailDialog(1));
        tamak3_suret.setOnClickListener(view -> foodDetailDialog(2));
        tamak4_suret.setOnClickListener(view -> foodDetailDialog(3));
        tamak5_suret.setOnClickListener(view -> foodDetailDialog(4));
        tamak6_suret.setOnClickListener(view -> foodDetailDialog(5));

        String jsonString = LoadJSONAsset.loadJSONFromAsset(this, "food_menu.json");
        if (jsonString != null) {
            try {
                JSONArray jsonArray = new JSONArray(jsonString);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String score = jsonObject.getString("score");
                    double dScore = Double.parseDouble(score);

                    if (dScore >= 4.5) {
                        String name = jsonObject.getString("name");
                        String price = jsonObject.getString("price");
                        String remark = jsonObject.getString("remark");
                        String type_id = jsonObject.getString("type_id");
                        String imgName = jsonObject.getString("image_url"); //type_1_01.png
                        imgName = imgName.substring(0, imgName.indexOf("."));
                        int suret = getDrawableId(this, imgName);

                        Food food = new Food(name, price, remark, type_id, score, suret);
                        foodArrayList.add(food);
                    }
                }
            } catch (JSONException e) {
                Log.i("json_text", "e: " + e.toString());
                e.printStackTrace();
            }
        }

        tamak1_suret.setImageResource(foodArrayList.get(0).image_url);
        tamak2_suret.setImageResource(foodArrayList.get(1).image_url);
        tamak3_suret.setImageResource(foodArrayList.get(2).image_url);
        tamak4_suret.setImageResource(foodArrayList.get(3).image_url);
        tamak5_suret.setImageResource(foodArrayList.get(4).image_url);
        tamak6_suret.setImageResource(foodArrayList.get(5).image_url);

        tamak1_name.setText(foodArrayList.get(0).name);
        tamak1_desc.setText(foodArrayList.get(0).remark);
        tamak2_name.setText(foodArrayList.get(1).name);
        tamak2_desc.setText(foodArrayList.get(1).remark);
        tamak3_name.setText(foodArrayList.get(2).name);
        tamak3_desc.setText(foodArrayList.get(2).remark);
        tamak4_name.setText(foodArrayList.get(3).name);
        tamak4_desc.setText(foodArrayList.get(3).remark);
        tamak5_name.setText(foodArrayList.get(4).name);
        tamak5_desc.setText(foodArrayList.get(4).remark);
        tamak6_name.setText(foodArrayList.get(5).name);
        tamak6_desc.setText(foodArrayList.get(5).remark);

        float score1 = Float.parseFloat(foodArrayList.get(0).score);
        float score2 = Float.parseFloat(foodArrayList.get(1).score);
        float score3 = Float.parseFloat(foodArrayList.get(2).score);
        float score4 = Float.parseFloat(foodArrayList.get(3).score);
        float score5 = Float.parseFloat(foodArrayList.get(4).score);
        float score6 = Float.parseFloat(foodArrayList.get(5).score);

        tamak1_ratingBar.setRating(score1);
        tamak2_ratingBar.setRating(score2);
        tamak3_ratingBar.setRating(score3);
        tamak4_ratingBar.setRating(score4);
        tamak5_ratingBar.setRating(score5);
        tamak6_ratingBar.setRating(score6);

        dialog = new Dialog(MainActivity.this);

        Button btnCart = findViewById(R.id.btnCart);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardDialog();
                dialog.show();
            }
        });

    }


    public static int getDrawableId(Activity activity, String drawableName) {
        return activity.getResources().getIdentifier(drawableName, "drawable", activity.getPackageName());
    }

    Dialog foodDialog;

    public void foodDetailDialog(int index) {
        foodDialog = new Dialog(MainActivity.this);
        foodDialog.setContentView(R.layout.food_detail_dialog);

        ImageView food_suret = foodDialog.findViewById(R.id.food_suret);
        TextView food_name = foodDialog.findViewById(R.id.food_name);
        RatingBar food_ratingBar = foodDialog.findViewById(R.id.food_ratingBar);
        TextView food_desc = foodDialog.findViewById(R.id.food_desc);
        ImageView tamak_minus = foodDialog.findViewById(R.id.tamak_minus);
        TextView tamak_san = foodDialog.findViewById(R.id.tamak_san);
        ImageView tamak_plus = foodDialog.findViewById(R.id.tamak_plus);

        Button menuBtn = foodDialog.findViewById(R.id.menuBtn);

        food_suret.setImageResource(foodArrayList.get(index).image_url);
        food_name.setText(foodArrayList.get(index).name);

        float score = Float.parseFloat(foodArrayList.get(index).score);
        food_ratingBar.setRating(score);
        food_desc.setText(foodArrayList.get(index).remark);


        tamak_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int san = Integer.parseInt("" + tamak_san.getText());
                san = san + 1;
                tamak_san.setText("" + san);
            }
        });
        tamak_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int san = Integer.parseInt("" + tamak_san.getText());
                san = san - 1;
                tamak_san.setText("" + san);
            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardFoods.add(foodArrayList.get(index));
                foodDialog.cancel();
            }
        });


        foodDialog.show();
    }

    Dialog dialog;

    public void cardDialog() {
        dialog.getWindow().setGravity(Gravity.RIGHT);
        dialog.setContentView(R.layout.dialog_cart);
        LinearLayout tamakListLayout = dialog.findViewById(R.id.tamakListLayout);

        LinearLayout tamak1_layout = dialog.findViewById(R.id.tamak1_layout);
        LinearLayout tamak2_layout = dialog.findViewById(R.id.tamak2_layout);
        LinearLayout tamak3_layout = dialog.findViewById(R.id.tamak3_layout);
        LinearLayout tamak4_layout = dialog.findViewById(R.id.tamak4_layout);
        LinearLayout tamak5_layout = dialog.findViewById(R.id.tamak5_layout);

        tamak1_layout.setVisibility(View.GONE);
        tamak2_layout.setVisibility(View.GONE);
        tamak3_layout.setVisibility(View.GONE);
        tamak4_layout.setVisibility(View.GONE);
        tamak5_layout.setVisibility(View.GONE);

        ImageView tamak1_minus = dialog.findViewById(R.id.tamak1_minus);
        TextView tamak1_san = dialog.findViewById(R.id.tamak1_san);
        ImageView tamak1_plus = dialog.findViewById(R.id.tamak1_plus);

        ImageView tamak1_suret = dialog.findViewById(R.id.tamak1_suret);
        TextView tamak1_title = dialog.findViewById(R.id.tamak1_title);
        TextView tamak1_price = dialog.findViewById(R.id.tamak1_price);
        TextView tamak1_desc = dialog.findViewById(R.id.tamak1_desc);

        ImageView tamak2_suret = dialog.findViewById(R.id.tamak2_suret);
        TextView tamak2_title = dialog.findViewById(R.id.tamak2_title);
        TextView tamak2_price = dialog.findViewById(R.id.tamak2_price);
        TextView tamak2_desc = dialog.findViewById(R.id.tamak2_desc);

        ImageView tamak3_suret = dialog.findViewById(R.id.tamak3_suret);
        TextView tamak3_title = dialog.findViewById(R.id.tamak3_title);
        TextView tamak3_price = dialog.findViewById(R.id.tamak3_price);
        TextView tamak3_desc = dialog.findViewById(R.id.tamak3_desc);



/*
cardFoods: index 1 - tamak1_suret
cardFoods: index 2 - tamak1_suret, tamak2_suret
cardFoods: index 3 - tamak1_suret, tamak2_suret, tamak3_suret
 */

        if (cardFoods.size() == 1) {
            tamak1_layout.setVisibility(View.VISIBLE);
            tamak1_suret.setImageResource(cardFoods.get(0).image_url);
            tamak1_title.setText(cardFoods.get(0).name);
            tamak1_price.setText(cardFoods.get(0).price);
            tamak1_desc.setText(cardFoods.get(0).remark);

        }else if (cardFoods.size() == 2) {
            tamak1_layout.setVisibility(View.VISIBLE);
            tamak2_layout.setVisibility(View.VISIBLE);

            tamak1_suret.setImageResource(cardFoods.get(0).image_url);
            tamak1_title.setText(cardFoods.get(0).name);
            tamak1_price.setText(cardFoods.get(0).price);
            tamak1_desc.setText(cardFoods.get(0).remark);

            tamak2_suret.setImageResource(cardFoods.get(1).image_url);
            tamak2_title.setText(cardFoods.get(1).name);
            tamak2_price.setText(cardFoods.get(1).price);
            tamak2_desc.setText(cardFoods.get(1).remark);

        }else if (cardFoods.size() == 3) {
            tamak1_layout.setVisibility(View.VISIBLE);
            tamak2_layout.setVisibility(View.VISIBLE);
            tamak3_layout.setVisibility(View.VISIBLE);

            tamak1_suret.setImageResource(cardFoods.get(0).image_url);
            tamak1_title.setText(cardFoods.get(0).name);
            tamak1_price.setText(cardFoods.get(0).price);
            tamak1_desc.setText(cardFoods.get(0).remark);

            tamak2_suret.setImageResource(cardFoods.get(1).image_url);
            tamak2_title.setText(cardFoods.get(1).name);
            tamak2_price.setText(cardFoods.get(1).price);
            tamak2_desc.setText(cardFoods.get(1).remark);

            tamak3_suret.setImageResource(cardFoods.get(2).image_url);
            tamak3_title.setText(cardFoods.get(2).name);
            tamak3_price.setText(cardFoods.get(2).price);
            tamak3_desc.setText(cardFoods.get(2).remark);

        }

        Button submit = dialog.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Whether to submit an order")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Intent intent = new Intent(MainActivity.this, CheckoutPageActivity.class);
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

        Button clearAll = dialog.findViewById(R.id.clearAll);
        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardFoods.clear();
                tamakListLayout.setVisibility(View.INVISIBLE);
            }
        });

        tamak1_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int san = Integer.parseInt("" + tamak1_san.getText());
                san = san + 1;
                tamak1_san.setText("" + san);


                tamak1_minus.setVisibility(View.VISIBLE);
                tamak1_san.setVisibility(View.VISIBLE);
            }
        });
        tamak1_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int san = Integer.parseInt("" + tamak1_san.getText());
                san = san - 1;
                tamak1_san.setText("" + san);

                if (san == 0) {
                    tamak1_minus.setVisibility(View.GONE);
                    tamak1_san.setVisibility(View.GONE);
                }
            }
        });


    }

        /*
        //new

        addFood();
        ImageView tamak1 = findViewById(R.id.tamak1);
        ImageView tamak2 = findViewById(R.id.tamak2);

        tamak1.setOnClickListener(view -> dialog.show());
        tamak2.setOnClickListener(view -> dialog.show());


        //end new
        cardDialog();
        Button btnCart = findViewById(R.id.btnCart);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardDialog.show();

            }
        });

        */

   /*
    //new
    Dialog cardDialog;

    public void cardDialog() {
        cardDialog = new Dialog(MainActivity.this);

        cardDialog.getWindow().setGravity(Gravity.RIGHT);
        cardDialog.setContentView(R.layout.dialog_cart);

        Button submit = cardDialog.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardDialog.cancel();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Whether to submit an order")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });

                builder.show();
            }
        });
        tamak1 = cardDialog.findViewById(R.id.tamak1);
        tamak1_title = cardDialog.findViewById(R.id.tamak1_title);

    }



    ImageView tamak1;
    TextView tamak1_title;
    Dialog dialog;

    public void addFood() {
        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.food_detail_dialog);
        ImageView tamak1_plus = dialog.findViewById(R.id.tamak1_plus);
        ImageView tamak1_minus = dialog.findViewById(R.id.tamak1_minus);
        TextView tamak1_san = dialog.findViewById(R.id.tamak1_san);

        tamak1_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int san = Integer.parseInt("" + tamak1_san.getText());
                san = san + 1;
                tamak1_san.setText("" + san);


                tamak1_minus.setVisibility(View.VISIBLE);
                tamak1_san.setVisibility(View.VISIBLE);
            }
        });
        tamak1_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int san = Integer.parseInt("" + tamak1_san.getText());
                san = san - 1;
                tamak1_san.setText("" + san);

                if (san == 0) {
                    tamak1_minus.setVisibility(View.GONE);
                    tamak1_san.setVisibility(View.GONE);
                }
            }
        });

        Button menuBtn = dialog.findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardFoods.add(new Food("name1", "price", "remark", "id", "score", R.drawable.type_3_01));
                cardFoods.add(new Food("name2", "price", "remark", "id", "score", R.drawable.type_3_01));
                cardFoods.add(new Food("name3", "price", "remark", "id", "score", R.drawable.type_3_01));


                if (cardFoods.size() != 0) {
                    tamak1.setImageResource(cardFoods.get(0).image_url);
                    tamak1_title.setText(cardFoods.get(0).name);
                }

                dialog.cancel();
            }
        });

    }
     */
}
