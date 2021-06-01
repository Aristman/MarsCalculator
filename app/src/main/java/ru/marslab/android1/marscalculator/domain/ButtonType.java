package ru.marslab.android1.marscalculator.domain;

public enum ButtonType {
    _0("0"),
    _1("1"),
    _2("2"),
    _3("3"),
    _4("4"),
    _5("5"),
    _6("6"),
    _7("7"),
    _8("8"),
    _9("9"),
    ALT("ALT"),
    DOT("."),
    PLUS("+"),
    MINUS("-"),
    DIV("/"),
    MUL("*"),
    FN("FN"),
    C("C");

    private final String label;

    ButtonType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
