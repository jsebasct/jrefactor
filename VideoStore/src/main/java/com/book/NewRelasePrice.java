package com.book;

public class NewRelasePrice extends Price{

    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }
}
