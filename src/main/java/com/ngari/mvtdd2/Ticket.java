package com.ngari.mvtdd2;

import java.math.BigDecimal;

public class Ticket {

    private static final int TICKET_PRICE = 99;

    public BigDecimal sales(int num) {


        if (num<0) {
            throw new IllegalArgumentException("num should larger than 0");
        }

        if (num>=1) {
            return BigDecimal.valueOf(TICKET_PRICE * num);
        }


        return BigDecimal.ZERO;
    }
}
