package com.example.yongjin.coolcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CalcActivity extends AppCompatActivity {

    String runningNumber = "";
    TextView resultView;

    public enum Operation {
        ADD, SUB, DIV, MUL, EQU
    }

    String leftValueStr = "";
    String rightValueStr = "";
    Operation currentOperation;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);



        Button mButton0 = (Button)findViewById(R.id.button0);
        Button mButton1 = (Button)findViewById(R.id.button1);
        Button mButton2 = (Button)findViewById(R.id.button2);
        Button mButton3 = (Button)findViewById(R.id.button3);
        Button mButton4 = (Button)findViewById(R.id.button4);
        Button mButton5 = (Button)findViewById(R.id.button5);
        Button mButton6 = (Button)findViewById(R.id.button6);
        Button mButton7 = (Button)findViewById(R.id.button7);
        Button mButton8 = (Button)findViewById(R.id.button8);
        Button mButton9 = (Button)findViewById(R.id.button9);
        Button clrButton = (Button)findViewById(R.id.Button10);

        ImageButton calcBtn = (ImageButton)findViewById(R.id.resultButton);
        ImageButton AddBtn = (ImageButton)findViewById(R.id.imageButtonA);
        ImageButton SubBtn = (ImageButton)findViewById(R.id.imageButtonS);
        ImageButton MulBtn = (ImageButton)findViewById(R.id.imageButtonM);
        ImageButton DivBtn = (ImageButton)findViewById(R.id.imageButtonD);

        resultView = (TextView)findViewById(R.id.textView);

        resultView.setText("");

        clrButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                runningNumber = "";
                leftValueStr = "";
                rightValueStr = "";
                result = 0;
                currentOperation = null;

                resultView.setText("0");
            }
        });

        mButton0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(0);
            }
        });

        mButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(1);
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(2);
            }
        });

        mButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(3);
            }
        });

        mButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(4);
            }
        });

        mButton5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(5);
            }
        });

        mButton6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(6);
            }
        });

        mButton7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(7);
            }
        });

        mButton8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(8);
            }
        });

        mButton9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(9);
            }
        });

        calcBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.EQU);
            }
        });

        AddBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.ADD);
            }
        });

        SubBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.SUB);
            }
        });

        MulBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.MUL);
            }
        });

        DivBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.DIV);
            }
        });


    }

    void processOperation (Operation operation) {
        if(currentOperation != null) { //연산자가 들어있으
            if(runningNumber != "") {
                rightValueStr = runningNumber;
                runningNumber = "";

                switch (currentOperation) {
                    case ADD:
                        result = Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
                        break;
                    case SUB:
                        result = Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
                        break;
                    case DIV:
                        result = Integer.parseInt(leftValueStr) / Integer.parseInt(rightValueStr);
                        break;
                    case MUL:
                        result = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                        break;

                }

                leftValueStr = String.valueOf(result);
                resultView.setText(leftValueStr);
            }

        }
        else
        {
            leftValueStr = runningNumber;
            runningNumber = "";
            currentOperation = operation;

        }


    }

    void numberPressed(int num) {
        if(runningNumber == "" && num == 0)
            return;
        runningNumber += String.valueOf(num);
        resultView.setText(runningNumber);
    }

}
