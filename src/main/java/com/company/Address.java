package com.company;

public class Address {

    private String street;
    private String numberHome;
    private String numberFlat;

    public Address(String street, String numberHome, String numberFlat) {
        this.street = street;
        this.numberHome = numberHome;
        this.numberFlat = numberFlat;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Address)) return false;
        Address other = (Address) o;
        return (this.street.equals(other.street)) && (this.numberHome.equals(other.numberHome)) &&
                (this.numberFlat.equals(other.numberFlat));
    }

    public String getStreet(){
        return street;
    }

    public String getNumberHome(){
        return numberHome;
    }

    public String getNumberFlat(){
        return numberFlat;
    }

    @Override
    public String toString() {
        return street + " " + numberHome + " " + numberFlat;
    }
}

