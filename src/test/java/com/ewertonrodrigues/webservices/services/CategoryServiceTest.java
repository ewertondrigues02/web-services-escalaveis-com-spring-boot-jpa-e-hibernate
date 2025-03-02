package com.ewertonrodrigues.webservices.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ewertonrodrigues.webservices.entities.Category;
import com.ewertonrodrigues.webservices.repositories.CategoryRepository;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository repository;

    @InjectMocks
    private CategoryService service;

    private Category category1;
    private Category category2;

    @BeforeEach
    void setUp() {
        category1 = new Category(1L, "Electronics");
        category2 = new Category(2L, "Books");
    }

    @Test
    void testFindAll() {
        List<Category> categories = Arrays.asList(category1, category2);
        when(repository.findAll()).thenReturn(categories);

        List<Category> result = service.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Electronics", result.get(0).getName());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        when(repository.findById(1L)).thenReturn(Optional.of(category1));

        Category result = service.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Electronics", result.getName());
        verify(repository, times(1)).findById(1L);
    }
}

