package com.demo.security.dao;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testIsValidUser_PreparedStatementUsed() {
        when(jdbcTemplate.queryForObject(anyString(), eq(Integer.class), any(), any())).thenReturn(1);
        
        boolean result = userDao.isValidUser("admin", "password123");
        
        assertTrue(result);
        verify(jdbcTemplate, times(1)).queryForObject(
            eq("SELECT COUNT(*) FROM users WHERE username = ? AND password = ?"),
            eq(Integer.class),
            any(), any()
        );
    }

    @Test
    void testIsValidUser_SQLInjectionAttempt() {
        when(jdbcTemplate.queryForObject(anyString(), eq(Integer.class), any(), any())).thenReturn(0);
        
        boolean result = userDao.isValidUser("admin' OR '1'='1", "password");
        
        assertFalse(result);
    }
}
