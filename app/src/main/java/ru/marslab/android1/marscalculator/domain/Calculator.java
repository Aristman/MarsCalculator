package ru.marslab.android1.marscalculator.domain;

import java.util.ArrayList;

public interface Calculator {

    enum Operation {
        ADD("+"),
        SUB("-"),
        MUL("*"),
        DIV("/"),
        EQU("="),
        END("\n");

        private final String value;
        Operation(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }
    class HistoryItem {

        Double number;
        Operation operation;
        public HistoryItem(Double number, Operation operation) {
            this.number = number;
            this.operation = operation;
        }


    }

    void clearHistoryList();

    String operation(String number, Operation operation);

    ArrayList<String> getHistoryList();

}
