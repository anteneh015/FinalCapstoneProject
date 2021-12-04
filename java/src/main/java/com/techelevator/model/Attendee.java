package com.techelevator.model;

import java.time.LocalDate;
import java.util.Objects;

public class Attendee {

    private int attendeeId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private int ageGroup;
    private String allergies;
    private boolean paymentStatus;
    private String additionalInfo;
    private String assignedRegistrar;
    private String parentFirstName;
    private String parentLastName;
    private String parentEmail;
    private String address;
    private String parentPhone;
    private String emgcyFirstName;
    private String emgcyLastName;
    private String emgcyPhone;


    public int getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(int attendeeId) {
        this.attendeeId = attendeeId;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getAssignedRegistrar() {
        return assignedRegistrar;
    }

    public void setAssignedRegistrar(String assignedRegistrar) {
        this.assignedRegistrar = assignedRegistrar;
    }

    public String getParentFirstName() {
        return parentFirstName;
    }

    public void setParentFirstName(String parentFirstName) {
        this.parentFirstName = parentFirstName;
    }

    public String getParentLastName() {
        return parentLastName;
    }

    public void setParentLastName(String parentLastName) {
        this.parentLastName = parentLastName;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    public String getEmgcyFirstName() {
        return emgcyFirstName;
    }

    public void setEmgcyFirstName(String emgcyFirstName) {
        this.emgcyFirstName = emgcyFirstName;
    }

    public String getEmgcyLastName() {
        return emgcyLastName;
    }

    public void setEmgcyLastName(String emgcyLastName) {
        this.emgcyLastName = emgcyLastName;
    }

    public String getEmgcyPhone() {
        return emgcyPhone;
    }

    public void setEmgcyPhone(String emgcyPhone) {
        this.emgcyPhone = emgcyPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendee attendee = (Attendee) o;
        return attendeeId == attendee.attendeeId && ageGroup == attendee.ageGroup && paymentStatus == attendee.paymentStatus && Objects.equals(firstName, attendee.firstName) && Objects.equals(lastName, attendee.lastName)
                && Objects.equals(dateOfBirth, attendee.dateOfBirth) && Objects.equals(gender, attendee.gender) && Objects.equals(allergies, attendee.allergies) && Objects.equals(additionalInfo, attendee.additionalInfo) && Objects.equals(assignedRegistrar, attendee.assignedRegistrar) && Objects.equals(parentFirstName, attendee.parentFirstName)
                && Objects.equals(parentLastName, attendee.parentLastName) && Objects.equals(parentEmail, attendee.parentEmail) && Objects.equals(address, attendee.address) && Objects.equals(parentPhone, attendee.parentPhone) && Objects.equals(emgcyFirstName, attendee.emgcyFirstName) && Objects.equals(emgcyLastName, attendee.emgcyLastName) && Objects.equals(emgcyPhone, attendee.emgcyPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attendeeId, firstName, lastName, dateOfBirth, gender, ageGroup, allergies, paymentStatus, additionalInfo, assignedRegistrar, parentFirstName, parentLastName, parentEmail, address, parentPhone, emgcyFirstName, emgcyLastName, emgcyPhone);
    }
}
