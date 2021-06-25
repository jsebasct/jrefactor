/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.book;

/**
 *
 */
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    double getChargeFromMovie(int daysRented) {
        double result = 0;
        switch (priceCode) {
            case REGULAR:
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                result += daysRented * 3;
                break;
            case CHILDRENS:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    int getFrequentRenterPoints(int daysRented, Rental rental) {
        int frequentRenterPoints = 1;
        // add bonus for a two day new release rental
        if ((rental.getMovie().getPriceCode() == NEW_RELEASE)
                && daysRented > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}
