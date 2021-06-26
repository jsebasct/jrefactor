package com.book;

public class NewRelasePrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getFrequentRenterPoints(int daysRented, Movie movie) {
        // add bonus for a two day new release rental
        return (daysRented > 1) ? 2 : 1;
    }
}
