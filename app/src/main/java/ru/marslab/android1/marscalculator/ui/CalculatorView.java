package ru.marslab.android1.marscalculator.ui;

import java.util.ArrayList;

public interface CalculatorView {

    void showEnteringNumber(String number);

    void showHistoryNumbers(ArrayList<String> numbers);
}
