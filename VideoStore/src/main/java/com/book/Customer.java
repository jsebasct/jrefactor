/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.book;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jscruz
 */
public class Customer {

    private String name;
    private List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        this.rentals = new ArrayList<Rental>();
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement()
    {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental eachRental : rentals)
        {
            //show figures for this rental
            result += "\t" + eachRental.getMovie().getTitle() + "\t" +String.valueOf(eachRental.getCharge()) + "\n";
        }

        //add footer lines
        result += "Amount owned is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getFrequentRenterPoints()) +" frequent renter points";

        return result;
    }

    private double getTotalAmount() {
        return rentals.stream().mapToDouble( r -> r.getCharge()).sum();
    }

    private int getFrequentRenterPoints() {
        return rentals.stream().mapToInt(r -> r.getFrequentRenterPoints()).sum();
    }

}
