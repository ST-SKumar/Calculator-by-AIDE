package com.appssk.calculator;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import net.objecthunter.exp4j.*;
import android.widget.AutoCompleteTextView.*;

public class MainActivity extends Activity implements View.OnClickListener
{
    private Button tvOne,tvTwo,tvThree,tvFour,tvFive,tvSix,tvSeven,tvEight,tvNine,tvZero,tvDot,tvPlus,tvMinus,tvMul,tvDivide,tvOpen,tvClose;
    private Button tvClear, tvBack, tvEquals;
    private EditText tvResult,tvExpression;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //TextBox
        tvResult = findViewById(R.id.tvResult);
        tvExpression = findViewById(R.id.tvExpression);
        tvResult.setEnabled(false);
        tvExpression.setEnabled(false);
        //Numbers
        tvOne = findViewById(R.id.tvOne);
        tvTwo = findViewById(R.id.tvTwo);
        tvThree = findViewById(R.id.tvThree);
        tvFour = findViewById(R.id.tvFour);
        tvFive = findViewById(R.id.tvFive);
        tvSix = findViewById(R.id.tvSix);
        tvSeven = findViewById(R.id.tvSeven);
        tvEight = findViewById(R.id.tvEight);
        tvNine = findViewById(R.id.tvNine);
        tvZero = findViewById(R.id.tvZero);
        tvDot = findViewById(R.id.tvDot);
        //Operators
        tvPlus = findViewById(R.id.tvPlus);
        tvMinus = findViewById(R.id.tvMinus);
        tvMul = findViewById(R.id.tvMul);
        tvDivide = findViewById(R.id.tvDivide);
        tvOpen = findViewById(R.id.tvOpen);
        tvClose = findViewById(R.id.tvClose);
        tvClear = findViewById(R.id.tvClear);
        tvBack = findViewById(R.id.tvBack);
        tvEquals = findViewById(R.id.tvEquals);
        
        //Numbers Listener
        tvOne.setOnClickListener(this);
        tvTwo.setOnClickListener(this);
        tvThree.setOnClickListener(this);
        tvFour.setOnClickListener(this);
        tvFive.setOnClickListener(this);
        tvSix.setOnClickListener(this);
        tvSeven.setOnClickListener(this);
        tvEight.setOnClickListener(this);
        tvNine.setOnClickListener(this);
        tvZero.setOnClickListener(this);
        tvDot.setOnClickListener(this);
        //Operators Listener
        tvPlus.setOnClickListener(this);
        tvMinus.setOnClickListener(this);
        tvMul.setOnClickListener(this);
        tvDivide.setOnClickListener(this);
        tvOpen.setOnClickListener(this);
        tvClose.setOnClickListener(this);
        
        tvClear.setOnClickListener(this);
        tvBack.setOnClickListener(this);
        tvEquals.setOnClickListener(this);
    }
    private void appendOnExpression(String string, Boolean canClear)
    {
        String s = tvResult.getText().toString();
        if(!s.isEmpty())
            tvExpression.setText("");
        if(canClear)
        {
            tvResult.setText("");
            tvExpression.append(string);
        }else
        {
            tvExpression.append(tvResult.getText());
            tvExpression.append(string);
            tvResult.setText("");
        }
    }

    @Override
    public void onClick(View v)
    {
        // TODO: Implement this method
        switch(v.getId())
        {
            case R.id.tvOne:
                appendOnExpression("1", true);
                break;
            case R.id.tvTwo:
                appendOnExpression("2", true);
                break;
            case R.id.tvThree:
                appendOnExpression("3", true);
                break;
            case R.id.tvFour:
                appendOnExpression("4", true);
                break;
            case R.id.tvFive:
                appendOnExpression("5", true);
                break;
            case R.id.tvSix:
                appendOnExpression("6", true);
                break;
            case R.id.tvSeven:
                appendOnExpression("7", true);
                break;
            case R.id.tvEight:
                appendOnExpression("8", true);
                break;
            case R.id.tvNine:
                appendOnExpression("9", true);
                break;
            case R.id.tvZero:
                appendOnExpression("0", true);
                break;
            case R.id.tvDot:
                appendOnExpression(".", true);
                break;
            case R.id.tvPlus:
                appendOnExpression("+", true);
                break;
            case R.id.tvMinus:
                appendOnExpression("-", true);
                break;
            case R.id.tvMul:
                appendOnExpression("*", true);
                break;
            case R.id.tvDivide:
                appendOnExpression("/", true);
                break;
            case R.id.tvOpen:
                appendOnExpression("(", true);
                break;
            case R.id.tvClose:
                appendOnExpression(")", true);
                break;
            case R.id.tvClear:
                tvClear();
                break;
            case R.id.tvBack:
                tvBack();
                break;
            case R.id.tvEquals:
                tvEquals();
                break;
        }
    }

    private void tvEquals()
    {
        // TODO: Implement this method
        try
        {
            Expression expression = new ExpressionBuilder(tvExpression.getText().toString()).build();
            double result = expression.evaluate();
            long longResult = (long) result;
            double lr = (double) longResult;
            if(result == lr)
            {
                tvResult.setText(longResult+"");
            }
            else{
                tvResult.setText(result+"");
            }
        }catch(Exception e)
        {
            Toast.makeText(MainActivity.this,"Message : "+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void tvBack()
    {
        // TODO: Implement this method
        String string =tvExpression.getText().toString();
        if(!string.isEmpty())
        {
            tvExpression.setText(string.substring(0,string.length()-1));
        }
        tvResult.setText("");
    }

    private void tvClear()
    {
        // TODO: Implement this method
        tvExpression.setText("");
        tvResult.setText("");
    }
}
