package com.example.androidgamev2;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Random rnd = new Random();
    int firstNum = 0;
    int secondNum = 0;
    int sum = 0;
    int input = 0;
    int ansCount = 0;
    String temp;
    boolean click1 = false;
    boolean click2 = false;
    boolean click3 = false;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    EditText et1;
    EditText et2;
    EditText et3;
    ImageView iV1;
    ImageView iV2;
    ImageView iV3;
    Button btn1;
    Button btn2;
    Button btn3;
    Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tV11);
        tv2 = findViewById(R.id.tV12);
        tv3 = findViewById(R.id.tV21);
        tv4 = findViewById(R.id.tV22);
        tv5 = findViewById(R.id.tV31);
        tv6 = findViewById(R.id.tV32);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        iV1 = findViewById(R.id.iV1);
        iV2 = findViewById(R.id.iV2);
        iV3 = findViewById(R.id.iV3);
        et1 = findViewById(R.id.eT1);
        et2 = findViewById(R.id.eT2);
        et3 = findViewById(R.id.eT3);
        restart = findViewById(R.id.reset);
        game();
    }

    public void game()
    {
        firstNum = rnd.nextInt(90) + 10;
        secondNum = rnd.nextInt(90) + 10;
        sum = firstNum + secondNum;
        tv1.setText("" + firstNum);
        tv2.setText("" + secondNum);
    }







    public void pressed1(View view)
    {
        if(!click1 && !click2 && !click3)
        {
            temp = et1.getText().toString();
            input = Integer.parseInt(temp);
            if(sum == input)
            {
                iV1.setImageResource(R.drawable.v);
                ansCount++;
            }
            else
            {
                iV1.setImageResource(R.drawable.x);
            }
            click1 = true;
            tv3.setText("" + sum);
            secondNum = rnd.nextInt(90) + 10;
            tv4.setText("" + secondNum);
        }
    }

    public void pressed2(View view)
    {
        if(click1 && !click2 && !click3)
        {
            temp = et2.getText().toString();
            input = Integer.parseInt(temp);
            sum += secondNum;
            if(sum == input)
            {
                iV2.setImageResource(R.drawable.v);
                ansCount++;
            }
            else
            {
                iV2.setImageResource(R.drawable.x);
            }
            click2 = true;
            tv5.setText("" + sum);
            secondNum = rnd.nextInt(90) + 10;
            tv6.setText("" + secondNum);
        }
    }

    public void pressed3(View view)
    {
        if (click1 && click2 && !click3)
        {
            temp = et3.getText().toString();
            input = Integer.parseInt(temp);
            sum += secondNum;
            if (sum == input) {
                iV3.setImageResource(R.drawable.v);
                ansCount++;
            } else {
                iV3.setImageResource(R.drawable.x);
            }
            click3 = true;
            if(ansCount == 3)
            {
                Toast.makeText(this, "You got " + ansCount + "/3 " + "100%", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "You got " + ansCount + "/3 " + (ansCount * 33.0) + "%", Toast.LENGTH_SHORT).show();
            }

        }
    }
    public void reset(View view)
    {
        firstNum = 0;
        secondNum = 0;
        sum = 0;
        input = 0;
        ansCount = 0;
        click1 = false;
        click2 = false;
        click3 = false;
        tv1.setText("");
        tv2.setText("");
        tv3.setText("");
        tv4.setText("");
        tv5.setText("");
        tv6.setText("");
        iV1.setImageResource(android.R.color.transparent);
        iV2.setImageResource(android.R.color.transparent);
        iV3.setImageResource(android.R.color.transparent);
        et1.getText().clear();
        et2.getText().clear();
        et3.getText().clear();
        game();
    }


}

