package ru.marslab.android1.marscalculator.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import ru.marslab.android1.marscalculator.MarsCalculator;
import ru.marslab.android1.marscalculator.R;

public class MarsCalculatorActivity extends AppCompatActivity implements CalculatorView {
    private static final int THEME_1 = 1;
    private static final int THEME_2 = 2;

    private static final String CALCULATOR_KEY = "calculator";
    static final String THEME_KEY = "theme_key";

    private int currentTheme;
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

    ActivityResultLauncher<Intent> chooseThemeLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null) {
                                int themeId = result.getData().getIntExtra(THEME_KEY, THEME_1);
                                if (themeId == R.id.theme_1) {
                                    currentTheme = THEME_1;
                                } else {
                                    currentTheme = THEME_2;
                                }
                            }
                        }
                        Intent newMainIntent = new Intent(
                                this,
                                MarsCalculatorActivity.class
                        );
                        newMainIntent.putExtra(CALCULATOR_KEY, calculator);
                        newMainIntent.putExtra(THEME_KEY, currentTheme);
                        finish();
                        startActivity(newMainIntent);
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            currentTheme = THEME_1;
            calculator = new MarsCalculator();
        } else {
            currentTheme = savedInstanceState.getInt(THEME_KEY);
            calculator = savedInstanceState.getParcelable(CALCULATOR_KEY);
        }
        switchTheme();
        setContentView(R.layout.activity_main);
        initKeyboard();
        initDisplay();
        calculator.attach(this);
    }

    private void switchTheme() {
        if (getIntent() != null) {
            currentTheme = getIntent().getIntExtra(THEME_KEY, THEME_1);
            if (currentTheme == THEME_1) {
                setTheme(R.style.Theme_MarsCalculator);
            } else {
                setTheme(R.style.Widget_AppCompat_Light_ActionBar);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(THEME_KEY, currentTheme);
        outState.putParcelable(CALCULATOR_KEY, calculator);
        super.onSaveInstanceState(outState);
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
    }

    @Override
    public void launchChoosingTheme() {
        Intent intent = new Intent(this, ChoosingThemeActivity.class);
        intent.putExtra(THEME_KEY, currentTheme);
        chooseThemeLauncher.launch(intent);
    }

    @Override
    protected void onDestroy() {
        calculator.detach();
        super.onDestroy();
    }
}