/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
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

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : rentals) {
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        //add footer lines
        result += "Amount owned is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";

        return result;
    }

    private double getTotalCharge() {
        double totalAmount = 0;
        for (Rental each : rentals) {
            totalAmount += each.getCharge();
        }
        return totalAmount;
    }

    private int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;

        for (Rental each : rentals) {
            frequentRenterPoints += each.getFrequentRenterPoints();
        }

        return frequentRenterPoints;
    }

}
