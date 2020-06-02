package com.example.androidtermproject;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class CodyActivity extends AppCompatActivity {

    String[] category = {"(선택)","상의","하의","신발"};
    String[] color = {"(선택)","빨강색","주황색","노랑색","초록색","파랑색","남색","보라색","흰색","검은색","혼합","기타"};
    String[] style = {"(선택)","일상","격식","운동","데이트"};
    Button change;
    Button done;
    Button reset;
    private View layoutCody;
    private View layoutCloth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cody);

        Spinner category_spinner = (Spinner) findViewById(R.id.category_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, category);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category_spinner.setAdapter(adapter);

        Spinner color_spinner = (Spinner) findViewById(R.id.color_spinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, color);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        color_spinner.setAdapter(adapter1);

        Spinner style_spinner = (Spinner) findViewById(R.id.style_spinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, style);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        style_spinner.setAdapter(adapter2);

        layoutCody = (LinearLayout)findViewById(R.id.codyImg_layout);
        layoutCloth = (LinearLayout)findViewById(R.id.cloth_layout);


        change = (Button)findViewById(R.id.change_btn);
        done = (Button)findViewById(R.id.done_btn);
        reset = (Button)findViewById(R.id.reset_btn);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(layoutCody.getVisibility() == View.VISIBLE){
                    layoutCloth.setVisibility(View.VISIBLE);
                    layoutCody.setVisibility(View.INVISIBLE);
                }
                else{
                    layoutCloth.setVisibility(View.INVISIBLE);
                    layoutCody.setVisibility(View.VISIBLE);
                }
            }
        });
        GridView cloth_grid = findViewById(R.id.cloth_grid);

        cloth_grid.setAdapter(new ClothAdapter(this));


    }
}
