package com.ewertonrodrigues.webservices.services;


import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ewertonrodrigues.webservices.entities.Order;
import com.ewertonrodrigues.webservices.entities.User;
import com.ewertonrodrigues.webservices.entities.enums.OrderStatus;

class OrderServiceTest {

    private Order order;
    private User client;

    @BeforeEach
    void setUp() {
        client = new User(1L, "Ewerton Rodrigues", "ewerton@example.com", "999999999", "password123");
        order = new Order(1L, Instant.parse("2024-03-02T12:00:00Z"), OrderStatus.SHIPPED, client);
    }

    @Test
    void testGetId() {
        assertEquals(1L, order.getId());
    }

    @Test
    void testSetId() {
        order.setId(2L);
        assertEquals(2L, order.getId());
    }

    @Test
    void testGetMoment() {
        assertEquals(Instant.parse("2024-03-02T12:00:00Z"), order.getMoment());
    }

    @Test
    void testSetMoment() {
        Instant newMoment = Instant.parse("2024-03-03T12:00:00Z");
        order.setMoment(newMoment);
        assertEquals(newMoment, order.getMoment());
    }

    @Test
    void testGetOrderStatus() {
        assertEquals(OrderStatus.SHIPPED, order.getOrderStatus());
    }

    @Test
    void testSetOrderStatus() {
        order.setOrderStatus(OrderStatus.DELIVERED);
        assertEquals(OrderStatus.DELIVERED, order.getOrderStatus());
    }

    @Test
    void testGetClient() {
        assertEquals(client, order.getClient());
    }

    @Test
    void testSetClient() {
        User newClient = new User(2L, "Carlos Silva", "carlos@example.com", "888888888", "password456");
        order.setClient(newClient);
        assertEquals(newClient, order.getClient());
    }
}
