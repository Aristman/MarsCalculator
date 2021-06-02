package ru.marslab.android1.marscalculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.marslab.android1.marscalculator.domain.ButtonType;
import ru.marslab.android1.marscalculator.domain.Calculator;

public class MainActivity extends AppCompatActivity {

    private final Calculator calculator = new Calculator();
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initKeyboard();
        initDisplay();
    }

    private void initDisplay() {
        display = findViewById(R.id.display);
    }

    private void initKeyboard() {
        findViewById(R.id.button_0).setOnClickListener(v -> clickListener(ButtonType._0));
        findViewById(R.id.button_1).setOnClickListener(v -> clickListener(ButtonType._1));
        findViewById(R.id.button_2).setOnClickListener(v -> clickListener(ButtonType._2));
        findViewById(R.id.button_3).setOnClickListener(v -> clickListener(ButtonType._3));
        findViewById(R.id.button_4).setOnClickListener(v -> clickListener(ButtonType._4));
        findViewById(R.id.button_5).setOnClickListener(v -> clickListener(ButtonType._5));
        findViewById(R.id.button_6).setOnClickListener(v -> clickListener(ButtonType._6));
        findViewById(R.id.button_7).setOnClickListener(v -> clickListener(ButtonType._7));
        findViewById(R.id.button_8).setOnClickListener(v -> clickListener(ButtonType._8));
        findViewById(R.id.button_9).setOnClickListener(v -> clickListener(ButtonType._9));
        findViewById(R.id.button_alt).setOnClickListener(v -> clickListener(ButtonType.ALT));
        findViewById(R.id.button_dot).setOnClickListener(v -> clickListener(ButtonType.DOT));
        findViewById(R.id.button_plus).setOnClickListener(v -> clickListener(ButtonType.PLUS));
        findViewById(R.id.button_minus).setOnClickListener(v -> clickListener(ButtonType.MINUS));
        findViewById(R.id.button_div).setOnClickListener(v -> clickListener(ButtonType.DIV));
        findViewById(R.id.button_multi).setOnClickListener(v -> clickListener(ButtonType.MUL));
        findViewById(R.id.button_fn).setOnClickListener(v -> clickListener(ButtonType.FN));
        findViewById(R.id.button_c).setOnClickListener(v -> clickListener(ButtonType.C));
    }

    private void clickListener(ButtonType buttonType) {
        calculator.click(buttonType);
        display.setText(calculator.getDisplay());
    }
}