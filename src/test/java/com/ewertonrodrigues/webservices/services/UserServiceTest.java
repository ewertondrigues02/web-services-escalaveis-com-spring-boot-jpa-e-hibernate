package com.ewertonrodrigues.webservices.services;

import com.ewertonrodrigues.webservices.entities.User;
import com.ewertonrodrigues.webservices.repositories.UserRepository;
import com.ewertonrodrigues.webservices.services.exceptions.DatabaseException;
import com.ewertonrodrigues.webservices.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        user1 = new User(1L, "Ewerton Rodrigues", "ewerton@example.com", "999999999", "password123");
        user2 = new User(2L, "Carlos Silva", "carlos@example.com", "888888888", "password456");
    }

    @Test
    void testFindAll() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userService.findAll();

        assertEquals(2, users.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));

        User foundUser = userService.findById(1L);

        assertEquals("Ewerton Rodrigues", foundUser.getName());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testFindByIdNotFound() {
        when(userRepository.findById(3L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userService.findById(3L));
    }

    @Test
    void testInsert() {
        when(userRepository.save(any(User.class))).thenReturn(user1);

        User savedUser = userService.insert(user1);

        assertNotNull(savedUser);
        assertEquals("Ewerton Rodrigues", savedUser.getName());
        verify(userRepository, times(1)).save(user1);
    }

    @Test
    void testDeleteSuccess() {
        doNothing().when(userRepository).deleteById(1L);

        assertDoesNotThrow(() -> userService.delete(1L));
        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteThrowsDatabaseException() {
        doThrow(DataIntegrityViolationException.class).when(userRepository).deleteById(1L);

        assertThrows(DatabaseException.class, () -> userService.delete(1L));
    }

    @Test
    void testUpdateSuccess() {
        when(userRepository.getReferenceById(1L)).thenReturn(user1);
        when(userRepository.save(any(User.class))).thenReturn(user1);

        User updatedUser = userService.update(1L, user2);

        assertNotNull(updatedUser);
        assertEquals(user2.getName(), updatedUser.getName());
        verify(userRepository, times(1)).getReferenceById(1L);
        verify(userRepository, times(1)).save(user1);
    }

    @Test
    void testUpdateThrowsDatabaseException() {
        when(userRepository.getReferenceById(1L)).thenThrow(RuntimeException.class);

        assertThrows(DatabaseException.class, () -> userService.update(1L, user2));
    }
}
