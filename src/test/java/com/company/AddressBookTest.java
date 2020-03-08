package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {
    /** Тесты основного класса*/
    private AddressBook actual = new AddressBook();
    @BeforeEach
    void setUp() {
        actual.addPersonAddress("Иванов", "Кантемировская", "19", "112");
        actual.addPersonAddress("Петров", "Невский", "34", "53");
        actual.addPersonAddress("Морозов", "Лиговский", "14", "64");
        actual.addPersonAddress("Сидоров", "Большой проспект В.О.", "24", "12");
        actual.addPersonAddress("Никитин", "Лиговский", "14", "84");
        actual.addPersonAddress("Сергеев", "Полюстровский", "54", "87");
    }
    @Test
    void addPersonAddress() {
        assertFalse(actual.addPersonAddress("Иванов", "wwerwr","wrwerw","werwr"));
        assertTrue(actual.addPersonAddress("werwer","werewr","werewr","wwrwer"));
    }

    @Test
    void deletePerson() {
        assertTrue(actual.deletePerson("Петров"));
        assertFalse(actual.deletePerson("Петров"));
        assertFalse(actual.deletePerson("Иванова"));
    }

    @Test
    void changeAddress() {
        assertTrue(actual.changeAddress("Сидоров", "Невский", "34",
                "53"));
        assertFalse(actual.changeAddress("Морозова", "Мебельная", "324",
                "273"));
    }



    @Test
    void getPersonToStreet() {
        HashMap<String, String> expected = new HashMap<>();
        expected.put("Морозов", "Лиговский 14 64");
        expected.put("Никитин", "Лиговский 14 84");
        assertEquals(expected, actual.getPersonToStreet("Лиговский"));
        assertNull(actual.getPersonToStreet("Водяная"));
    }

    @Test
    void getPersonToHome() {
        HashMap<String, String> expected = new HashMap<>();
        expected.put("Морозов", "Лиговский 14 64");
        expected.put("Никитин", "Лиговский 14 84");
        assertEquals(expected, actual.getPersonToHome("Лиговский","14"));
        assertNull(actual.getPersonToHome("Лиговский","24"));
    }
    @Test
    void getAddress() {
        Address expected = new Address("Невский", "34", "53");
        assertEquals(expected,actual.getAddress("Петров"));
        Address expectedTwo = new Address("Лиговский", "14", "64");
        assertEquals(expectedTwo,actual.getAddress("Морозов"));
        assertNull(actual.getAddress("Жуков"));
    }

    /** Тесты вспомогательного класса*/
    private Address forTests = new Address("Тестовая", "1", "10");
    @Test
    void getStreet() {
        assertEquals("Тестовая", forTests.getStreet());
    }

    @Test
    void getNumberHome() {
        assertEquals("1", forTests.getNumberHome());
    }

    @Test
    void getNumberFlat() {
        assertEquals("10", forTests.getNumberFlat());
    }

    @Test
    void String() {
        assertEquals("Тестовая 1 10", forTests.toString());
    }
}