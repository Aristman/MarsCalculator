package ru.marslab.android1.marscalculator.domain;

public enum ButtonType {
    _0("0", 0),
    _1("1", 1),
    _2("2", 2),
    _3("3", 3),
    _4("4", 4),
    _5("5", 5),
    _6("6", 6),
    _7("7", 7),
    _8("8", 8),
    _9("9", 9),
    ALT("ALT", -1),
    DOT(".", -1),
    PLUS("+", -1),
    MINUS("-", -1),
    DIV("/", -1),
    MUL("*", -1),
    FN("FN", -1),
    C("C", -1),
    AC("AC", -1);

    private final String label;
    private final Integer value;

    ButtonType(String label, Integer value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public Integer getValue() {
        return value;
    }
}
