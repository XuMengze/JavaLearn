package com.alg.effective_java;

public enum OperaExtended implements Opera {
    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    }, REMAINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    OperaExtended(String symbol) {
        this.symbol = symbol;
    }
}
