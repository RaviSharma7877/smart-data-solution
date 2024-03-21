package com.smartdatasolutions.test;

/**
 * Represents a member with basic information.
 */
public class Member {

    private String id;
    private String address;
    private String city;
    private String firstName;
    private String lastName;
    private String state;
    private String zip;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Converts the member information to a CSV format string.
     *
     * @return CSV format string representing the member
     */
    public String toCSVString() {
        return id + "," + firstName + "," + lastName + "," + address + "," + city + "," + state + "," + zip;
    }

}
