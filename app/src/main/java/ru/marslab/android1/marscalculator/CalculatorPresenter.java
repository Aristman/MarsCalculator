package ru.marslab.android1.marscalculator;

import ru.marslab.android1.marscalculator.domain.ButtonType;
import ru.marslab.android1.marscalculator.domain.Calculator;
import ru.marslab.android1.marscalculator.domain.CalculatorImpl;
import ru.marslab.android1.marscalculator.ui.CalculatorView;

public class CalculatorPresenter {
    final static String ZERO_STRING = "0";

    private Long firstNumber = 0L;
    private Long previousNumber = 0L;
    private Long nextNumber = 0L;
    private Long enteringNumber = 0L;
    private ButtonType operation;

    private CalculatorView view;

    private Calculator calculator = new CalculatorImpl();

    public CalculatorPresenter(CalculatorView view) {
        this.view = view;
        this.view.showEnteringNumber(ZERO_STRING);
    }

    // Логика обработки нажатия
    public void click(ButtonType buttonType) {
        switch (buttonType) {
            case _0:
            case _1:
            case _2:
            case _3:
            case _4:
            case _5:
            case _6:
            case _7:
            case _8:
            case _9:
                if (enteringNumber / 10000000000000L == 0 ) {
                    enteringNumber *= 10;
                    enteringNumber += buttonType.getValue();
                }
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
                if (enteringNumber != 0) {
                    enteringNumber /= 10L;
                }
                break;
            case AC:
                enteringNumber = 0L;
        }
        view.showEnteringNumber(String.valueOf(enteringNumber));
    }

}
