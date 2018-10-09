/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.book;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jscruz
 */
public class CustomerTest {

    private List<Movie> movies;

    private Customer customerJoseChildren;
    private Customer customerCarlaRegular;
    private Customer customerMarioChildren;
    private Customer customerAnaRegular;

    private Customer customerPedroRelease;

    private static final String HEAD = "Rental Record for ";
    private static final String AMOUNT_OWNED = "Amount owned is ";
    private static final String EARNED = "You earned ";
    private static final String FRP = " frequent renter points";

    public CustomerTest() {
        movies = new ArrayList<Movie>();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("SetUp Class");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("TearDown Class");
    }

    @Before
    public void setUp() {
        System.out.println("setUp");

        movies.clear();
        movies.add(new Movie("The Golden Ingot", Movie.REGULAR));
        movies.add(new Movie("El tentador de mi esposa", Movie.REGULAR));

        movies.add(new Movie("Avengers", Movie.CHILDRENS));

        movies.add(new Movie("Men in Black III", Movie.NEW_RELEASE));
        movies.add(new Movie("Jhon Carter", Movie.NEW_RELEASE));
        movies.add(new Movie("Valiente", Movie.NEW_RELEASE));


        customerCarlaRegular = new Customer("Carla");
        customerCarlaRegular.addRental(new Rental(movies.get(0), 2));
        customerCarlaRegular.addRental(new Rental(movies.get(1), 2));

        customerAnaRegular = new Customer("Ana");
        customerAnaRegular.addRental(new Rental(movies.get(0), 3));
        customerAnaRegular.addRental(new Rental(movies.get(1), 4));

        customerJoseChildren = new Customer("Jose");
        customerJoseChildren.addRental(new Rental(movies.get(2), 3));

        customerMarioChildren = new Customer("Mario");
        customerMarioChildren.addRental(new Rental(movies.get(2), 5));

        customerPedroRelease = new Customer("Pedro");
        customerPedroRelease.addRental(new Rental(movies.get(3), 1));
        customerPedroRelease.addRental(new Rental(movies.get(4), 3));
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    public void testRegularOnTime() {
        String expResult = HEAD + customerCarlaRegular.getName()
                + "\n\t" + movies.get(0).getTitle() + "\t" + 2.0
                + "\n\t" + movies.get(1).getTitle() + "\t" + 2.0 
                + "\n" + AMOUNT_OWNED + 4.0
                + "\n" + EARNED + 2 + FRP;

        String result = customerCarlaRegular.statement();

        //System.out.println("Sese:" +result);
        //System.out.println("SeseExpected:" + expResult);

        assertEquals(expResult, result);
    }

    @Test
    public void testRegularOverTime() {
        String expResult = HEAD + customerAnaRegular.getName()
                + "\n\t" + movies.get(0).getTitle() + "\t" + 3.5
                + "\n\t" + movies.get(1).getTitle() + "\t" + 5.0
                + "\n" + AMOUNT_OWNED + 8.5
                + "\n" + EARNED + 2 + FRP;

        String result = customerAnaRegular.statement();

        //System.out.println("Sese:" +result);
        //System.out.println("SeseExpected:" + expResult);

        assertEquals(expResult, result);
    }

    @Test
    public void testChildrenOnTime() {
        String expResult = HEAD + customerJoseChildren.getName()
                + "\n\t" + movies.get(2).getTitle() + "\t" + 1.5
                + "\n" + AMOUNT_OWNED + 1.5
                + "\n" + EARNED + 1 + FRP;

        String result = customerJoseChildren.statement();

        //System.out.println("Sese:" +result);
        //System.out.println("SeseExpected:" + expResult);

        assertEquals(expResult, result);
    }

    @Test
    public void testChildrenOverTime() {
        String expResult = HEAD + customerMarioChildren.getName()
                + "\n\t" + movies.get(2).getTitle() + "\t" + 4.5
                + "\n" + AMOUNT_OWNED + 4.5
                + "\n" + EARNED + 1 + FRP;

        String result = customerMarioChildren.statement();

        //System.out.println("Sese:" +result);
        //System.out.println("SeseExpected:" + expResult);

        assertEquals(expResult, result);
    }

    @Test
    public void testNewRelease() {
        String expResult = HEAD + customerPedroRelease.getName()
                + "\n\t" + movies.get(3).getTitle() + "\t" + 3.0
                + "\n\t" + movies.get(4).getTitle() + "\t" + 9.0
                + "\n" + AMOUNT_OWNED + 12.0
                + "\n" + EARNED + 3 + FRP;

        String result = customerPedroRelease.statement();

        //System.out.println("Sese:" +result);
        //System.out.println("SeseExpected:" + expResult);

        assertEquals(expResult, result);
    }
}
