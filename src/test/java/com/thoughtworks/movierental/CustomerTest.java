package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void shouldValidStatement() {
        Movie movie1 = new Movie("test1", Movie.CHILDRENS);
        Movie movie2 = new Movie("test2", Movie.NEW_RELEASE);
        Movie movie3 = new Movie("test3", Movie.REGULAR);

        Rental rental1 = new Rental(movie1, 2);
        Rental rental2 = new Rental(movie1, 3);
        Rental rental3 = new Rental(movie1, 4);

        Customer customer = new Customer("Sample_Customer");
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        String expected = "Rental Record for Sample_Customer\n" +
                "\ttest1\t1.5\n" +
                "\ttest1\t1.5\n" +
                "\ttest1\t3.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 3 frequent renter points";

        Assert.assertEquals(expected, customer.statement());

    }

}