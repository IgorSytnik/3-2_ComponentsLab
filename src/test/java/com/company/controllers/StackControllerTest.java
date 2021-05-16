package com.company.controllers;

import com.company.services.StackService;
import com.company.services.StackServiceImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StackControllerTest {

    StackService stackServiceMock = mock(StackServiceImpl.class);
    StackController stackController = new StackController(stackServiceMock);

    @Test
    void menu_1_Equals() throws InvocationTargetException, IllegalAccessException {
        String expected = "expected";
        when(stackServiceMock.getClSuperClNames(any())).thenReturn(expected);
        assertEquals(expected,stackController.menu(1));
        verify(stackServiceMock).getClSuperClNames(any());
    }

    @Test
    void menu_2_Equals() throws InvocationTargetException, IllegalAccessException {
        String expected = "expected";
        when(stackServiceMock.invokeByAnnotation(any(),any(),any())).thenReturn(expected);
        assertEquals(expected,stackController.menu(2));
        verify(stackServiceMock).invokeByAnnotation(any(),any(),any());
    }

    @Test
    void menu_3_Equals() throws InvocationTargetException, IllegalAccessException {
        String expected = "expected";
        when(stackServiceMock.getDetails(any())).thenReturn(expected);
        assertEquals(expected,stackController.menu(3));
        verify(stackServiceMock).getDetails(any());
    }

    @Test
    void menu_4_Equals() throws InvocationTargetException, IllegalAccessException {
        String expected = "expected";
        when(stackServiceMock.getModifiers(any())).thenReturn(expected);
        assertEquals(expected,stackController.menu(4));
        verify(stackServiceMock).getModifiers(any());
    }

    @Test
    void menu_5_Equals() throws InvocationTargetException, IllegalAccessException {
        String expected = "expected";
        when(stackServiceMock.testProxy(any())).thenReturn(expected);
        assertEquals(expected,stackController.menu(5));
        verify(stackServiceMock).testProxy(any());
    }

    @Test
    void menu_MoreThan5_RuntimeException() {
        assertThrows(RuntimeException.class,
                ()->stackController.menu(6));
    }
}