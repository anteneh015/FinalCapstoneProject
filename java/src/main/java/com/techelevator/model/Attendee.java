package com.techelevator.model;

import java.time.LocalDate;
import java.util.Objects;

public class Attendee {

    private int attendeeId;
    private String attendeeName;
    private LocalDate dateOfBirth;
    private String gender;
    private int ageGroup;
    private boolean paymentStatus;
    private String notes;
    private String registrar;
    private String guardianName;
    private String email;
    private String address;
    private String guardianPhone;
    private String emgcyName;
    private String emgcyPhone;

    public int getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(int attendeeId) {
        this.attendeeId = attendeeId;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public void setAttendeeName(String attendeeName) {
        this.attendeeName = attendeeName;
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

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRegistrar() {
        return registrar;
    }

    public void setRegistrar(String registrar) {
        this.registrar = registrar;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGuardianPhone() {
        return guardianPhone;
    }

    public void setGuardianPhone(String guardianPhone) {
        this.guardianPhone = guardianPhone;
    }

    public String getEmgcyName() {
        return emgcyName;
    }

    public void setEmgcyName(String emgcyName) {
        this.emgcyName = emgcyName;
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
        return attendeeId == attendee.attendeeId && ageGroup == attendee.ageGroup && paymentStatus == attendee.paymentStatus
                && Objects.equals(attendeeName, attendee.attendeeName) && Objects.equals(dateOfBirth, attendee.dateOfBirth)
                && Objects.equals(gender, attendee.gender) && Objects.equals(notes, attendee.notes)
                && Objects.equals(registrar, attendee.registrar) && Objects.equals(guardianName, attendee.guardianName)
                && Objects.equals(email, attendee.email) && Objects.equals(address, attendee.address)
                && Objects.equals(guardianPhone, attendee.guardianPhone) && Objects.equals(emgcyName, attendee.emgcyName)
                && Objects.equals(emgcyPhone, attendee.emgcyPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attendeeId, attendeeName, dateOfBirth, gender, ageGroup, paymentStatus, notes, registrar, guardianName, email, address, guardianPhone, emgcyName, emgcyPhone);
    }
}
