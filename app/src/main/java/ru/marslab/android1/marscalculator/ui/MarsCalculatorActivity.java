package ru.marslab.android1.marscalculator.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import ru.marslab.android1.marscalculator.MarsCalculator;
import ru.marslab.android1.marscalculator.R;

public class MarsCalculatorActivity extends AppCompatActivity implements CalculatorView {

    private MarsCalculator calculator;
    private TextView historyDisplay;
    private TextView enteringDisplay;
    private final int[] buttons = new int[]{
            R.id.button_0,
            R.id.button_1,
            R.id.button_2,
            R.id.button_3,
            R.id.button_4,
            R.id.button_5,
            R.id.button_6,
            R.id.button_7,
            R.id.button_8,
            R.id.button_9,
            R.id.button_alt,
            R.id.button_dot,
            R.id.button_plus,
            R.id.button_minus,
            R.id.button_div,
            R.id.button_multi,
            R.id.button_fn,
            R.id.button_c,
            R.id.button_ac,
            R.id.button_equ
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initKeyboard();
        initDisplay();
        calculator = new MarsCalculator();
        calculator.attach(this);
    }

    private void initDisplay() {
        enteringDisplay = findViewById(R.id.enter_display);
        historyDisplay = findViewById(R.id.display);
    }

    private void initKeyboard() {
        for (int numberButton : buttons) {
            findViewById(numberButton).setOnClickListener(v -> {
                Button key = (Button) v;
                calculator.click(key.getText().toString());
            });
        }
    }

    @Override
    public void showEnteringNumber(String number) {
        enteringDisplay.setText(number);
    }

    @Override
    public void showHistoryNumbers(ArrayList<String> numbers) {
        StringBuilder text = new StringBuilder();
        for (String number : numbers) {
            text.append(number);
        }
        historyDisplay.setText(text);
        historyDisplay.computeScroll();
    }

    @Override
    protected void onDestroy() {
        calculator.detach();
        super.onDestroy();
    }
}