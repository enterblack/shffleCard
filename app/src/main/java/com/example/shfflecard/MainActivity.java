package com.example.shfflecard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public ScrollView scrollView;
    ImageView first,second,third,fourth,fifth;
    Button changeButton;
    int[] img = {R.drawable.jan_gwang,R.drawable.jan_normal,R.drawable.feb_bird,R.drawable.feb_normal,
            R.drawable.mar_gwang,R.drawable.mar_normal,R.drawable.apr_bird,R.drawable.apr_normal,
            R.drawable.may_flower,R.drawable.may_normal,R.drawable.jun_flower,R.drawable.jun_normal,
            R.drawable.jul_pig,R.drawable.jul_normal,R.drawable.aug_gwang,R.drawable.aug_normal,
            R.drawable.sep_mung,R.drawable.sep_normal,R.drawable.oct_deer,R.drawable.oct_normal};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first = (ImageView) findViewById(R.id.first);
        second = (ImageView) findViewById(R.id.second);
        third = (ImageView) findViewById(R.id.third);
        fourth = (ImageView) findViewById(R.id.fourth);
        fifth = (ImageView) findViewById(R.id.fifth);

        changeButton = (Button) findViewById(R.id.changeButton);

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"이거 누르면 색깔 바꾸게 만들자",Toast.LENGTH_SHORT).show();
                int[] shuffle = shuffle(img);


                third.setImageResource(shuffle[0]);
                first.setImageResource(shuffle[1]);
                second.setImageResource(shuffle[2]);
                fourth.setImageResource(shuffle[3]);
                fifth.setImageResource(shuffle[4]);
            }
        });
    }
    public static int[] shuffle(int[] array){
        for(int i=0 ; i< array.length ; i++){
            int randomNumber = (int) (Math.random() * array.length);

            int temp = array[randomNumber];
            array[randomNumber] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
