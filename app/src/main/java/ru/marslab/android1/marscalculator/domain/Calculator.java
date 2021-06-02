package ru.marslab.android1.marscalculator.domain;

public class Calculator {
    private Integer firstNumber;
    private Integer previousNumber;
    private Integer nextNumber;
    private ButtonType operation;

    // Логика обработки нажатия
    public void click(ButtonType buttonType) {
        switch (buttonType) {
            case _0:
                break;
            case _1:
                break;
            case _2:
                break;
            case _3:
                break;
            case _4:
                break;
            case _5:
                break;
            case _6:
                break;
            case _7:
                break;
            case _8:
                break;
            case _9:
                break;
            case ALT:
                break;
            case DOT:
                break;
            case PLUS:
                break;
            case MINUS:
                break;
            case DIV:
                break;
            case MUL:
                break;
            case FN:
                break;
            case C:
        }
    }

    public String getDisplay() {
        return "Тест дисплея";
    }
}
