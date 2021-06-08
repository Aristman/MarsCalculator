package ru.marslab.android1.marscalculator.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.marslab.android1.marscalculator.R;

public class ChoosingThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_theme);
        initRadioGroup();

        findViewById(R.id.btn_set_theme).setOnClickListener(v -> {
            Intent intent = new Intent();
            RadioGroup group = findViewById(R.id.choosing_theme_group);
            intent.putExtra(MarsCalculatorActivity.THEME_KEY, group.getCheckedRadioButtonId());
            setResult(RESULT_OK, intent);
            finish();
        });
    }

    private void initRadioGroup() {
        if (getIntent() != null) {
            int inputTheme = getIntent().getIntExtra(MarsCalculatorActivity.THEME_KEY, -1);
            RadioButton radioButton;
            if (inputTheme == 1) {
                radioButton = (RadioButton) findViewById(R.id.theme_1);
            } else {
                radioButton = (RadioButton) findViewById(R.id.theme_2);
            }
            radioButton.toggle();
        }
    }
}
