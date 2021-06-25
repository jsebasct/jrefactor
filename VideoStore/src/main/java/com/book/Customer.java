/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.book;

import java.util.ArrayList;
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
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }

        //add footer lines
        result += "Amount owned is " + getTotalCharge() + "\n";
        result += "You earned " + getFrequentRenterPoints() + " frequent renter points";

        return result;
    }

    public String htmlStatement() {
        String result = "<h1>Rental Record for " + getName() + "</h1>\n";

        for (Rental each : rentals) {
            //show figures for this rental
            result += each.getMovie().getTitle() + ": " + each.getCharge() + " </br> \n";
        }

        //add footer lines
        result += "<p> Amount owned is " + getTotalCharge() + "</p>\n";
        result += "<p> You earned " + getFrequentRenterPoints() + " frequent renter points </p>";

        return result;
    }

    private double getTotalCharge() {
        return rentals.stream().mapToDouble(Rental::getCharge).sum();
    }

    private int getFrequentRenterPoints() {
        return rentals.stream().mapToInt(t -> t.getFrequentRenterPoints()).sum();
    }

}
