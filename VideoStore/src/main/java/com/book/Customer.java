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
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        Iterator<Rental> rentalIterator = rentals.iterator();

        String result = "Rental Record for " + getName() + "\n";
        while (rentalIterator.hasNext()) {
            Rental each = rentalIterator.next();

            // add frequent renter points
            frequentRenterPoints += each.getFrequentRenterPoints();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }

        //add footer lines
        result += "Amount owned is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }

}
