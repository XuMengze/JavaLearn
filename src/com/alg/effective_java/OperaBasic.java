package com.alg.effective_java;

public enum OperaBasic implements Opera {
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    }, MIUNS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    }, MULTIPLY("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    }, DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    OperaBasic(String symbol) {
        this.symbol = symbol;
    }
}
