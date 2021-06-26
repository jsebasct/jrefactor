package com.book;

public abstract class Price {

    public abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRented, Movie movie) {

        return 1;
    }
}
