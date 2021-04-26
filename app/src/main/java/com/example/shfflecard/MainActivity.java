package com.example.shfflecard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public ScrollView scrollView;
    ImageView first,second,third,fourth,fifth;
    TextView grade;
    Button changeButton;
    int[] img = {R.drawable.jan_gwang,R.drawable.jan_normal,R.drawable.feb_bird,R.drawable.feb_normal,
            R.drawable.mar_gwang,R.drawable.mar_normal,R.drawable.apr_bird,R.drawable.apr_normal,
            R.drawable.may_flower,R.drawable.may_normal,R.drawable.jun_flower,R.drawable.jun_normal,
            R.drawable.jul_pig,R.drawable.jul_normal,R.drawable.aug_gwang,R.drawable.aug_normal,
            R.drawable.sep_mung,R.drawable.sep_normal,R.drawable.oct_deer,R.drawable.oct_normal};

    // img를 직접 셔플하는게 아니라 그냥 다른 임의의 int배열을 만들고 셔플하고 정하고 이걸 다하고 출력만 매칭이 되게 수정을 하면될듯
    //아나 이걸 몰라서 2개월을 날렸네 ;;;(20210426 14:40);

    //1부터 20까지 선언을 하고 1은 jan_gwang 이렇게 매칭할 예정
    final int[] imgNumber = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

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
        grade = (TextView) findViewById(R.id.grade);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"이거 누르면 색깔 바꾸게 만들자",Toast.LENGTH_SHORT).show();

//                int[] shuffle = imgNumber;
//                shuffle = shuffle(shuffle);
                //아 이렇게 하면 얕은 복사가 되서 그냥 동기화가 되는군!


                int[] shuffle = imgNumber.clone();
                shuffle = shuffleCard(shuffle);
                //이게 깊은 복사 배열이고 복사하는건 같지만 서로 간섭을 안함


                //ㅇㅋㅇㅋ 일단 족보 판정만 만들면 됨 !!!!(20210426)
                grade.setText(shuffle[0]+" "+shuffle[1]+" "+shuffle[2]+" "+shuffle[3]+" "+shuffle[4]);
                first.setImageResource(img[shuffle[0]]);
                second.setImageResource(img[shuffle[1]]);
                third.setImageResource(img[shuffle[2]]);
                fourth.setImageResource(img[shuffle[3]]);
                fifth.setImageResource(img[shuffle[4]]);

            }
        });
    }
    public static int[] shuffleCard(int[] array){
        for(int i=0 ; i< array.length ; i++){
            int randomNumber = (int) (Math.random() * array.length);

            int temp = array[randomNumber];
            array[randomNumber] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
