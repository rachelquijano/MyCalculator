package com.rachelquijano.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String oldNumber = "";
    String op = "+";
    EditText edText;
    boolean isNewOp = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edText = findViewById(R.id.editText);

    }

    public void numberEvent(View view) {
        if(isNewOp)
            edText.setText("");
        isNewOp = false;
        String number = edText.getText().toString();
        switch(view.getId()){
            case R.id.btn1:
                number += "1";
                break;
            case R.id.btn2:
                number += "2";
                break;
            case R.id.btn3:
                number += "3";
                break;
            case R.id.btn4:
                number += "4";
                break;
            case R.id.btn5:
                number += "5";
                break;
            case R.id.btn6:
                number += "6";
                break;
            case R.id.btn7:
                number += "7";
                break;
            case R.id.btn8:
                number += "8";
                break;
            case R.id.btn9:
                number += "9";
                break;
            case R.id.btn0:
                number += "0";
                break;
            case R.id.btnDot:
                number += ".";
                break;
            case R.id.btnPlusMinus:
                double numMultiplied = Double.parseDouble(number);
                numMultiplied *= -1;
                if(numMultiplied % 1 == 0) {
                    int res = (int) numMultiplied;
                    number = String.valueOf(res);
                    break;
                }
                number = String.valueOf(numMultiplied);
                edText.setText(number + "");
                break;
                }
        edText.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = edText.getText().toString();
        switch(view.getId()){
            case R.id.btnDivide:
                op = "/";
                break;
            case R.id.btnMultiply:
                op = "*";
                break;
            case R.id.btnPlus:
                op = "+";
                break;
            case R.id.btnMinus:
                op = "-";
                break;
        }
    }

    public void equalEvent(View view) {
        String newNumber = edText.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        if(result % 1 == 0){
            int res = (int)result;
            edText.setText(res + "");
            return;
        }
        edText.setText(result + "");
    }

    public void acEvent(View view) {
        edText.setText("0");
        isNewOp = true;
    }

    public void percentEvent(View view) {
        double no = Double.parseDouble(edText.getText().toString())/100;
        edText.setText(no+"");
        isNewOp = true;
    }
}