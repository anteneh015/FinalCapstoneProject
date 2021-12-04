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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendee attendee = (Attendee) o;
        return attendeeId == attendee.attendeeId && ageGroup == attendee.ageGroup && paymentStatus == attendee.paymentStatus
                && Objects.equals(firstName, attendee.firstName) && Objects.equals(lastName, attendee.lastName) && Objects.equals(dateOfBirth, attendee.dateOfBirth) &&
                Objects.equals(gender, attendee.gender) && Objects.equals(allergies, attendee.allergies) && Objects.equals(additionalInfo, attendee.additionalInfo) && Objects.equals(assignedRegistrar, attendee.assignedRegistrar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attendeeId, firstName, lastName, dateOfBirth, gender, ageGroup, allergies, paymentStatus, additionalInfo, assignedRegistrar);
    }
}
