package kz.worldskills.a202;

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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    Dialog dialog;
    ArrayList<Food> foodArrayList;
    ArrayList<FoodType> foodType;
    ImageView tamak1, tamak2, tamak3, tamak4, tamak5, tamak6;
    TextView tamak1_title, tamak2_title, tamak3_title, tamak4_title, tamak5_title, tamak6_title, tamak1_price, tamak2_price, tamak3_price, tamak4_price, tamak5_price, tamak6_price, tamak1_desc, tamak2_desc, tamak3_desc, tamak4_desc, tamak5_desc, tamak6_desc;
    ImageView tamak1_minus, tamak2_minus, tamak3_minus, tamak4_minus, tamak5_minus, tamak6_minus;
    TextView tamak1_san, tamak2_san, tamak3_san, tamak4_san, tamak5_san, tamak6_san;

    ImageView tamak1_plus, tamak2_plus, tamak3_plus, tamak4_plus, tamak5_plus, tamak6_plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        dialog = new Dialog(CategoryActivity.this);
        foodArrayList = new ArrayList<>();
        foodType = new ArrayList<>();

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
        Button btnMenu4 = findViewById(R.id.btnMenu4);
        Button btnMenu5 = findViewById(R.id.btnMenu5);
        Button btnMenu6 = findViewById(R.id.btnMenu6);
        Button btnMenu7 = findViewById(R.id.btnMenu7);
        Button btnCart = findViewById(R.id.btnCart);

        tamak1 = findViewById(R.id.tamak1);
        tamak2 = findViewById(R.id.tamak2);
        tamak3 = findViewById(R.id.tamak3);
        tamak4 = findViewById(R.id.tamak4);
        tamak5 = findViewById(R.id.tamak5);
        tamak6 = findViewById(R.id.tamak6);

        tamak1_title = findViewById(R.id.tamak1_title);
        tamak2_title = findViewById(R.id.tamak2_title);
        tamak3_title = findViewById(R.id.tamak3_title);
        tamak4_title = findViewById(R.id.tamak4_title);
        tamak5_title = findViewById(R.id.tamak5_title);
        tamak6_title = findViewById(R.id.tamak6_title);

        tamak1_price = findViewById(R.id.tamak1_price);
        tamak2_price = findViewById(R.id.tamak2_price);
        tamak3_price = findViewById(R.id.tamak3_price);
        tamak4_price = findViewById(R.id.tamak4_price);
        tamak5_price = findViewById(R.id.tamak5_price);
        tamak6_price = findViewById(R.id.tamak6_price);

        tamak1_desc = findViewById(R.id.tamak1_desc);
        tamak2_desc = findViewById(R.id.tamak2_desc);
        tamak3_desc = findViewById(R.id.tamak3_desc);
        tamak4_desc = findViewById(R.id.tamak4_desc);
        tamak5_desc = findViewById(R.id.tamak5_desc);
        tamak6_desc = findViewById(R.id.tamak6_desc);

        tamak1_minus = findViewById(R.id.tamak1_minus);
        tamak2_minus = findViewById(R.id.tamak2_minus);
        tamak3_minus = findViewById(R.id.tamak3_minus);
        tamak4_minus = findViewById(R.id.tamak4_minus);
        tamak5_minus = findViewById(R.id.tamak5_minus);
        tamak6_minus = findViewById(R.id.tamak6_minus);

        tamak1_san = findViewById(R.id.tamak1_san);
        tamak2_san = findViewById(R.id.tamak2_san);
        tamak3_san = findViewById(R.id.tamak3_san);
        tamak4_san = findViewById(R.id.tamak4_san);
        tamak5_san = findViewById(R.id.tamak5_san);
        tamak6_san = findViewById(R.id.tamak6_san);

        tamak1_plus = findViewById(R.id.tamak1_plus);
        tamak2_plus = findViewById(R.id.tamak2_plus);
        tamak3_plus = findViewById(R.id.tamak3_plus);
        tamak4_plus = findViewById(R.id.tamak4_plus);
        tamak5_plus = findViewById(R.id.tamak5_plus);
        tamak6_plus = findViewById(R.id.tamak6_plus);


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
        tamak2_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int san = Integer.parseInt("" + tamak2_san.getText());
                san = san + 1;
                tamak2_san.setText("" + san);


                tamak2_minus.setVisibility(View.VISIBLE);
                tamak2_san.setVisibility(View.VISIBLE);
            }
        });
        tamak2_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int san = Integer.parseInt("" + tamak2_san.getText());
                san = san - 1;
                tamak2_san.setText("" + san);

                if (san == 0) {
                    tamak2_minus.setVisibility(View.GONE);
                    tamak2_san.setVisibility(View.GONE);
                }
            }
        });
        tamak3_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int san = Integer.parseInt("" + tamak3_san.getText());
                san = san + 1;
                tamak3_san.setText("" + san);


                tamak3_minus.setVisibility(View.VISIBLE);
                tamak3_san.setVisibility(View.VISIBLE);
            }
        });
        tamak3_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int san = Integer.parseInt("" + tamak3_san.getText());
                san = san - 1;
                tamak3_san.setText("" + san);

                if (san == 0) {
                    tamak3_minus.setVisibility(View.GONE);
                    tamak3_san.setVisibility(View.GONE);
                }
            }
        });
        tamak4_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int san = Integer.parseInt("" + tamak4_san.getText());
                san = san + 1;
                tamak4_san.setText("" + san);


                tamak4_minus.setVisibility(View.VISIBLE);
                tamak4_san.setVisibility(View.VISIBLE);
            }
        });
        tamak4_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int san = Integer.parseInt("" + tamak4_san.getText());
                san = san - 1;
                tamak4_san.setText("" + san);

                if (san == 0) {
                    tamak4_minus.setVisibility(View.GONE);
                    tamak4_san.setVisibility(View.GONE);
                }
            }
        });
        tamak5_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int san = Integer.parseInt("" + tamak5_san.getText());
                san = san + 1;
                tamak5_san.setText("" + san);


                tamak5_minus.setVisibility(View.VISIBLE);
                tamak5_san.setVisibility(View.VISIBLE);
            }
        });
        tamak5_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int san = Integer.parseInt("" + tamak5_san.getText());
                san = san - 1;
                tamak5_san.setText("" + san);

                if (san == 0) {
                    tamak5_minus.setVisibility(View.GONE);
                    tamak5_san.setVisibility(View.GONE);
                }
            }
        });

        cardDialog();

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();

                Button submit = dialog.findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                        AlertDialog.Builder builder = new AlertDialog.Builder(CategoryActivity.this);
                        builder.setMessage("Whether to submit an order")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {

                                        Intent intent = new Intent(CategoryActivity.this, CheckoutPageActivity.class);
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
        });

        String jsonString = LoadJSONAsset.loadJSONFromAsset(this, "food_menu.json");
        if (jsonString != null) {
            try {
                JSONArray jsonArray = new JSONArray(jsonString);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("name");
                    String price = jsonObject.getString("price");
                    String remark = jsonObject.getString("remark");
                    String type_id = jsonObject.getString("type_id");
                    String score = jsonObject.getString("score");
                    String imgName = jsonObject.getString("image_url"); //type_1_01.png
                    imgName = imgName.substring(0, imgName.indexOf("."));
                    int suret = getDrawableId(this, imgName);

                    Food food = new Food(name, price, remark, type_id, score, suret);
                    foodArrayList.add(food);
                }
            } catch (JSONException e) {
                Log.i("json_text", "e: " + e.toString());
                e.printStackTrace();
            }
        }

        String jsonString2 = LoadJSONAsset.loadJSONFromAsset(this, "food_type.json");
        if (jsonString2 != null) {
            try {
                JSONArray jsonArray = new JSONArray(jsonString2);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("name");
                    String id = jsonObject.getString("id");

                    FoodType foods = new FoodType(name, id);
                    foodType.add(foods);
                }
            } catch (JSONException e) {
                Log.i("json_text", "e: " + e.toString());
                e.printStackTrace();
            }
        }

//        Log.i("info", "foodArrayList: " + foodArrayList.size());
//        Log.i("info", "foodType: " + foodType.size());

        btnMenu1.setText(foodType.get(0).name);
        btnMenu2.setText(foodType.get(1).name);
        btnMenu3.setText(foodType.get(2).name);
        btnMenu4.setText(foodType.get(3).name);
        btnMenu5.setText(foodType.get(4).name);
        btnMenu6.setText(foodType.get(5).name);
        btnMenu7.setText(foodType.get(6).name);

        btnMenu1.setOnClickListener(view -> tamaktarById(1));
        btnMenu2.setOnClickListener(view -> tamaktarById(2));
        btnMenu3.setOnClickListener(view -> tamaktarById(3));
        btnMenu4.setOnClickListener(view -> tamaktarById(4));
        btnMenu5.setOnClickListener(view -> tamaktarById(5));
        btnMenu6.setOnClickListener(view -> tamaktarById(6));
        btnMenu7.setOnClickListener(view -> tamaktarById(7));
    }

    public void tamaktarById(int id) {
            ArrayList<Food> oneFoodList = new ArrayList<>();

            for (int i = 0; i < foodArrayList.size(); i++) {
                Food food = foodArrayList.get(i);
                if (food.type_id.equals("" + id)) {
                    oneFoodList.add(food);
                }
            }
            Log.i("info", "oneFoodList: " + oneFoodList.size());

            tamak1.setImageResource(oneFoodList.get(0).image_url);
            tamak2.setImageResource(oneFoodList.get(1).image_url);
            tamak3.setImageResource(oneFoodList.get(2).image_url);
            tamak4.setImageResource(oneFoodList.get(3).image_url);
            tamak5.setImageResource(oneFoodList.get(4).image_url);
            tamak6.setImageResource(oneFoodList.get(5).image_url);

            tamak1_title.setText(oneFoodList.get(0).name);
            tamak2_title.setText(oneFoodList.get(1).name);
            tamak3_title.setText(oneFoodList.get(2).name);
            tamak4_title.setText(oneFoodList.get(3).name);
            tamak5_title.setText(oneFoodList.get(4).name);
            tamak6_title.setText(oneFoodList.get(5).name);

            tamak1_price.setText(oneFoodList.get(0).price);
            tamak2_price.setText(oneFoodList.get(1).price);
            tamak3_price.setText(oneFoodList.get(2).price);
            tamak4_price.setText(oneFoodList.get(3).price);
            tamak5_price.setText(oneFoodList.get(4).price);
            tamak6_price.setText(oneFoodList.get(5).price);

            tamak1_desc.setText(oneFoodList.get(0).remark);
            tamak2_desc.setText(oneFoodList.get(1).remark);
            tamak3_desc.setText(oneFoodList.get(2).remark);
            tamak4_desc.setText(oneFoodList.get(3).remark);
            tamak5_desc.setText(oneFoodList.get(4).remark);
            tamak6_desc.setText(oneFoodList.get(5).remark);
    }

    public static int getDrawableId(Activity activity, String drawableName) {
        return activity.getResources().getIdentifier(drawableName, "drawable", activity.getPackageName());
    }

    public void cardDialog() {

        dialog.getWindow().setGravity(Gravity.RIGHT);
        dialog.setContentView(R.layout.dialog_cart);


        LinearLayout tamakListLayout = dialog.findViewById(R.id.tamakListLayout);

        ImageView tamak1_minus = dialog.findViewById(R.id.tamak1_minus);
        TextView tamak1_san = dialog.findViewById(R.id.tamak1_san);
        ImageView tamak1_plus = dialog.findViewById(R.id.tamak1_plus);

        Button clearAll = dialog.findViewById(R.id.clearAll);

        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
}