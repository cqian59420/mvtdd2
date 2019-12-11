package com.ngari.mvtdd2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicketTest {


    Ticket ticket;


    @BeforeEach
    void setUp() {
        ticket = new Ticket();
    }

    @Test
    void testSaleTicket() {
        assertEquals(new BigDecimal("99"), ticket.sales(1));
    }


    @Test
    void testSaleZero() {
        assertEquals(BigDecimal.ZERO,ticket.sales(0));
    }

    @Test
    void testSale100() {
        assertEquals(BigDecimal.valueOf(99*100),ticket.sales(100));
    }


    @Test
    void testSaleException() {
        assertThrows(IllegalArgumentException.class, () -> ticket.sales(-1));
    }

}
