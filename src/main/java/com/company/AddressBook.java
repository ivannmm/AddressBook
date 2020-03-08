package com.company;

import java.util.HashMap;


public class AddressBook {
    private HashMap<String, Address> book = new HashMap<>();


    public boolean addPersonAddress(String person, String street, String numberHome, String numberFlat) {
        if (book.get(person) == null) {
            Address address = new Address(street, numberHome, numberFlat);
            book.put(person, address);
            return true;
        }
        return false;
    }

    public boolean deletePerson (String personDelete) {
        if (book.get(personDelete) != null) {
            book.remove(personDelete);
            return true;
        }
        return false;
    }

    public boolean changeAddress (String changePerson, String newStreet, String newNumberHome, String newNumberFlat) {
        if (book.get(changePerson) != null) {
            Address address = new Address(newStreet, newNumberHome, newNumberFlat);
            book.replace(changePerson, address);
            return true;
        }
        return false;
    }

    public Address getAddress (String giveAddressPerson) {
        if (book.get(giveAddressPerson) != null) {
            return book.get(giveAddressPerson);
        }
        return null;
    }

    public HashMap<String, String> getPersonToStreet (String needStreet) {
        HashMap<String, String> result;
        result = new HashMap<>();
        for (String key: book.keySet()){
            if (book.get(key).getStreet().equals(needStreet)) {
                result.put(key, book.get(key).toString());
            }
        }
        return result;
    }

    public HashMap<String, String> getPersonToHome (String needStreet, String needHome) {
        HashMap<String, String> result;
        result = new HashMap<>();
        for (String key: book.keySet()){
            if (book.get(key).getStreet().equals(needStreet) && book.get(key).getNumberHome().equals(needHome)) {
                result.put(key, book.get(key).toString());
            }
        }
        return result;
    }
}