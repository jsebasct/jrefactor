/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.book;

/**
 *
 */
public class Rental {
    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.daysRented = daysRented;
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    double getCharge() {
        return movie.getChargeFromMovie(daysRented);
    }

    int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }

}
