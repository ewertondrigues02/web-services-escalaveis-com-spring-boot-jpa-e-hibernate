package com.ewertonrodrigues.webservices.services;

import com.ewertonrodrigues.webservices.entities.Category;
import com.ewertonrodrigues.webservices.entities.Order;
import com.ewertonrodrigues.webservices.repositories.CategoryRepository;
import com.ewertonrodrigues.webservices.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    private Category category1;
    private Category category2;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    private Order order1;
    private Order order2;

    @BeforeEach
    void setUp() {

        category1 = new Category(1L, "Electronics");
        category2 = new Category(2L, "Books");
        order1 = new Order(1L, "Order1");
        order2 = new Order(2L, "Order2");
    }

    @Test
    void testFindAllCategories() {

        List<Category> categories = Arrays.asList(category1, category2);
        when(categoryRepository.findAll()).thenReturn(categories);

        List<Category> result = categoryService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Electronics", result.get(0).getName());
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdCategory() {
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category1));

        Category result = categoryService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Electronics", result.getName());
        verify(categoryRepository, times(1)).findById(1L);
    }

    @Test
    void testFindAllOrders() {

        List<Order> orders = Arrays.asList(order1, order2);
        when(orderRepository.findAll()).thenReturn(orders);


        List<Order> result = orderService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Order1", result.get(0).getClient());
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdOrder() {

        when(orderRepository.findById(1L)).thenReturn(Optional.of(order1));

        Order result = orderService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Order1", result.getItems());
        verify(orderRepository, times(1)).findById(1L);
    }
}
