import java.util.function.BinaryOperator;

public class FunctionCompose {


    public static void main(String[] args) {

    }


    static Function<Integer, Integer> compose(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        return new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return f1.apply(f2.apply(integer));
            }
        };
    }

    static Function<Double, Double> anotherCompose(Function<Double, Double> f1, Function<Double, Double> f2) {
        return arg -> f1.apply(f2.apply(arg));
    }

    static <T, U, V> Function<Function<U, V>, Function<Function<T, U>, Function<T, V>>> higherCompose() {
        return x -> y -> z -> x.apply(y.apply(z));
    }

    static BinaryOperator<Integer> mult = (x, y) -> x * y;

//    public static void main(String[] args) {
//        anotherCompose(Math::sin, x -> Math.PI / 2 - x).apply(2.0);
//    }

    public void aMethor() {
        final double taxRate = 0.1;
        Function<Double, Double> addTax = price -> price * (1 + taxRate);
    }

}