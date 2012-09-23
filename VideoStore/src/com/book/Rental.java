/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.book;

/**
 *
 * @author jscruz
 */
public class Rental {
    private int daysRented;
    private Movie movie;

    public Rental(int daysRented, Movie movie) {
        this.daysRented = daysRented;
        this.movie = movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}
