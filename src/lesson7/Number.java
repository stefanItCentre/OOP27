package lesson7;


//1. Написать класс число (Number), хранящий целое число и выполняющий следующие операции:
//- получение примитива (метод int get())
//- сложение (метод Number add(Number num))
//- вычитание (метод Number sub(Number num))
//- умножение (метод Number mul(Number num))
//- деление (метод Number div(Number num))
//- возведение в степень (метод Number pow(Number exponent))
//- вычисление факториала (метод Number fact())
//- вычисление остатка от деления (метод Number mod(Number num))

public class Number {

    int number;

    public Number() {
    }

    public Number(int number) {
        this.number = number;
    }


    public int get() {
        return number;
    }

    public Number add(Number number) {
        return new Number(this.number + number.number);
    }

    public Number sub(Number number) {
        return new Number(this.number - number.get());
    }

    public Number mul(Number number) {
        return new Number(this.number * number.get());
    }

    public Number div(Number number) {
        return new Number(this.number / number.get());
    }

    public Number pow(Number exponent) {
        return new Number((int) Math.pow(this.number, exponent.get()));
    }

    public Number fact() {
        return new Number(factorial(this.number));
    }

    public Number mod(Number number) {
        return new Number(this.number % number.get());

    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            int res = n * factorial(n - 1);
            return res;
        }
    }

}

