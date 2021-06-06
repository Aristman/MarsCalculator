package ru.marslab.android1.marscalculator.domain;

import java.util.ArrayList;

public class CalculatorImpl implements Calculator {
    private final ArrayList<HistoryItem> historyNumbers = new ArrayList<>();
    private Double subTotal = 0D;

    @Override
    public void clearHistoryList() {
        historyNumbers.clear();
        subTotal = 0D;
    }

    @Override
    public String operation(String number, Operation operation) {
        double value = Double.parseDouble(number);
        HistoryItem prevItem = getLastHistoryItemOrEmpty();
        if (prevItem.operation == Operation.END) {
            subTotal = value;
        }
        switch (prevItem.operation) {
            case ADD:
                subTotal += value;
                break;
            case SUB:
                subTotal -= value;
                break;
            case MUL:
                subTotal *= value;
                break;
            case DIV:
                if (value == 0) {
                    return String.valueOf(value);
                }
                subTotal /= value;
                break;
        }
        if (operation == Operation.EQU) {
            historyNumbers.add(new HistoryItem(value, Operation.EQU));
            historyNumbers.add(new HistoryItem(subTotal, Operation.END));
        } else {
            historyNumbers.add(new HistoryItem(value, operation));
        }
        return String.valueOf(subTotal);
    }

    private HistoryItem getLastHistoryItemOrEmpty() {
        HistoryItem item;
        if (historyNumbers.isEmpty()) {
            item = new HistoryItem(0D, Operation.END);
        } else {
            item = historyNumbers.get(historyNumbers.size() - 1);
        }
        return item;
    }

    @Override
    public ArrayList<String> getHistoryList() {
        ArrayList<String> result = new ArrayList<>();
        for (HistoryItem historyItem : historyNumbers) {
            result.add(historyItem.number + historyItem.operation.getValue());
        }
        return result;
    }
}
