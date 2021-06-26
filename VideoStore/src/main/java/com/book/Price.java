package com.book;

public abstract class Price {

    public abstract int getPriceCode();

    double getCharge(int daysRented) {
        double result = 0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                double result1 = 2;
                if (daysRented > 2) {
                    result1 += (daysRented - 2) * 1.5;
                }
                result = result1;
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }

}
