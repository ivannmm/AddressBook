package com.company;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {
    private AddressBook actual = new AddressBook();
    @Test
    void addPersonAddress() {
        actual.addPersonAddress("Иванов", "Кантемировская", "19", "112");
        actual.addPersonAddress("Петров", "Невский", "34", "53");
        actual.addPersonAddress("Морозов", "Лиговский", "14", "64");
        actual.addPersonAddress("Сидоров", "Большой проспект В.О.", "24", "12");
        actual.addPersonAddress("Никитин", "Ворошилова", "16", "84");
        assertFalse(actual.addPersonAddress("Иванов", "wwerwr","wrwerw","werwr"));
        assertTrue(actual.addPersonAddress("werwer","werewr","werewr","wwrwer"));
    }

    @Test
    void deletePerson() {
        actual.addPersonAddress("Иванов", "Кантемировская", "19", "112");
        actual.addPersonAddress("Петров", "Невский", "34", "53");
        actual.addPersonAddress("Морозов", "Лиговский", "14", "64");
        actual.addPersonAddress("Сидоров", "Большой проспект В.О.", "24", "12");
        actual.addPersonAddress("Никитин", "Ворошилова", "16", "84");
        assertTrue(actual.deletePerson("Петров"));
        assertFalse(actual.deletePerson("Петров"));
        assertFalse(actual.deletePerson("Иванова"));
    }

    @Test
    void changeAddress() {
        actual.addPersonAddress("Иванов", "Кантемировская", "19", "112");
        actual.addPersonAddress("Петров", "Невский", "34", "53");
        actual.addPersonAddress("Морозов", "Лиговский", "14", "64");
        actual.addPersonAddress("Сидоров", "Большой проспект В.О.", "24", "12");
        actual.addPersonAddress("Никитин", "Ворошилова", "16", "84");
        assertTrue(actual.changeAddress("Сидоров", "Невский", "34",
                "53"));
        assertFalse(actual.changeAddress("Морозова", "Мебельная", "324",
                "273"));
    }



    @Test
    void getPersonToStreet() {
        actual.addPersonAddress("Иванов", "Кантемировская", "19", "112");
        actual.addPersonAddress("Петров", "Невский", "34", "53");
        actual.addPersonAddress("Морозов", "Лиговский", "14", "64");
        actual.addPersonAddress("Сидоров", "Большой проспект В.О.", "24", "12");
        actual.addPersonAddress("Никитин", "Лиговский", "16", "84");
        HashMap<String, String> expected = new HashMap<>();
        expected.put("Морозов", "Лиговский 14 64");
        expected.put("Никитин", "Лиговский 16 84");
        assertEquals(expected, actual.getPersonToStreet("Лиговский"));
        HashMap<String, String> expectedTwo = new HashMap<>();
        assertEquals(expectedTwo, actual.getPersonToStreet("Полюстровский"));
    }

    @Test
    void givePersonToHome() {
        actual.addPersonAddress("Иванов", "Кантемировская", "19", "112");
        actual.addPersonAddress("Петров", "Невский", "34", "53");
        actual.addPersonAddress("Морозов", "Лиговский", "14", "64");
        actual.addPersonAddress("Сидоров", "Большой проспект В.О.", "24", "12");
        actual.addPersonAddress("Никитин", "Лиговский", "14", "84");
        HashMap<String, String> expected = new HashMap<>();
        expected.put("Морозов", "Лиговский 14 64");
        expected.put("Никитин", "Лиговский 14 84");
        assertEquals(expected, actual.getPersonToHome("Лиговский","14"));
    }

    @Test
    void getAddress() {
        actual.addPersonAddress("Иванов", "Кантемировская", "19", "112");
        actual.addPersonAddress("Петров", "Невский", "34", "53");
        actual.addPersonAddress("Морозов", "Лиговский", "14", "64");
        actual.addPersonAddress("Сидоров", "Большой проспект В.О.", "24", "12");
        actual.addPersonAddress("Никитин", "Лиговский", "14", "84");
        Address expected = new Address("Невский", "34", "53");
        assertEquals(expected,actual.getAddress("Петров"));
        Address expectedTwo = new Address("Лиговский", "14", "64");
        assertEquals(expectedTwo,actual.getAddress("Морозов"));
        assertNull(actual.getAddress("Жуков"));
    }
}