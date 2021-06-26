package com.book;

public class NewRelasePrice extends Price{
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}
