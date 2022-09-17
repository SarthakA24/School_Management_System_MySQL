package com.sarthak.model;

import java.util.Objects;

public class Student {
    private int rollNumber;
    private String firstName;
    private String lastName;
    private String address;
    private String pinCode;
    private String guardianName;
    private long contactNumber;
    private long guardianContactNumber;

    public Student() {
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public long getGuardianContactNumber() {
        return guardianContactNumber;
    }

    public void setGuardianContactNumber(long guardianContactNumber) {
        this.guardianContactNumber = guardianContactNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getRollNumber() == student.getRollNumber() && getContactNumber() == student.getContactNumber() && getGuardianContactNumber() == student.getGuardianContactNumber() && Objects.equals(getFirstName(), student.getFirstName()) && Objects.equals(getLastName(), student.getLastName()) && Objects.equals(getAddress(), student.getAddress()) && Objects.equals(getPinCode(), student.getPinCode()) && Objects.equals(getGuardianName(), student.getGuardianName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRollNumber(), getFirstName(), getLastName(), getAddress(), getPinCode(), getGuardianName(), getContactNumber(), getGuardianContactNumber());
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", guardianName='" + guardianName + '\'' +
                ", contactNumber=" + contactNumber +
                ", guardianContactNumber=" + guardianContactNumber +
                '}';
    }
}
