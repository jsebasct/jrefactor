package com.book;

public abstract class Price {

    public abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRented, Movie movie) {
        int frequentRenterPoints = 1;
        // add bonus for a two day new release rental
        if ((movie.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}
