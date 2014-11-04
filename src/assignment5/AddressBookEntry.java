package assignment5;

/**
 * Course: CS 3401
 * Section:
 * Name: Thomas Hamilton
 * Processor: Alan Shaw
 * Assignment #: 5
 */

public class AddressBookEntry implements Comparable<AddressBookEntry> {
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String cityStateZip;
    private String phoneNumber;

    public AddressBookEntry(String fName, String lName, String sAddress, String cStateZip, String pNumber) {
        this.firstName = fName;
        this.lastName = lName;
        this.streetAddress = sAddress;
        this.cityStateZip = cStateZip;
        this.phoneNumber = pNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCityStateZip() {
        return cityStateZip;
    }

    public void setCityStateZip(String cityStateZip) {
        this.cityStateZip = cityStateZip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return "";
    }

    public int compareTo(AddressBookEntry other) {
        int val = this.getLastName().compareTo(other.getLastName());
        if (val == 0) {
            return this.getFirstName().compareTo(other.getFirstName());
        }
        return val;
    }
}