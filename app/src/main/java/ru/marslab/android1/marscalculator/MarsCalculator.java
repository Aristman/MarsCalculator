package ru.marslab.android1.marscalculator;

import ru.marslab.android1.marscalculator.domain.Calculator;
import ru.marslab.android1.marscalculator.domain.CalculatorImpl;
import ru.marslab.android1.marscalculator.ui.CalculatorView;

public class MarsCalculator {
    final static String ZERO_STRING = "0";

    private StringBuilder leftPart = new StringBuilder("0");
    private StringBuilder rightPart = new StringBuilder();
    private boolean isDotSet = false;

    private Long enteringNumber = 0L;

    private CalculatorView view;

    private final Calculator calculator = new CalculatorImpl();

    public void attach(CalculatorView view) {
        this.view = view;
        this.view.showEnteringNumber(getEnterNumber());
    }

    public void detach () {
        view = null;
    }

    public boolean isAttach() {
        return view != null;
    }

    // Логика обработки нажатия
    public void click(String buttonText) {
        switch (buttonText) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                if (leftPart.length() + rightPart.length() <= 12) {
                    if (!isDotSet) {
                        if (leftPart.indexOf(ZERO_STRING) == 0) {
                            leftPart.setLength(0);
                        }
                        leftPart.append(buttonText);
                    } else {
                        rightPart.append(buttonText);
                    }
                }
                break;
            case "ALT":
                break;
            case ".":
                isDotSet = true;
                break;
            case "+":
                break;
            case "-":
                break;
            case "/":
                break;
            case "*":
                break;
            case "FN":
                break;
            case "C":
                if (!isDotSet) {
                    leftPart.deleteCharAt(leftPart.length() - 1);
                    if (leftPart.length() == 0 ) {
                        leftPart.append(ZERO_STRING);
                    }
                } else {
                    if (rightPart.length() > 0) {
                        rightPart.setLength(rightPart.length() - 1);
                    } else {
                        isDotSet = false;
                    }
                }
                break;
            case "AC":
                clearAllNumbers();
        }
        view.showEnteringNumber(getEnterNumber());
    }

    private String getEnterNumber() {
        StringBuilder resultString = new StringBuilder(leftPart);
        if (isDotSet) {
            resultString.append(".");
            resultString.append(rightPart);
        }
        return resultString.toString();
    }

    private void clearAllNumbers() {
        leftPart.setLength(0);
        leftPart.append(ZERO_STRING);
        rightPart.setLength(0);
        isDotSet = false;
    }

}
