package com.techelevator.dao;

import com.techelevator.model.Attendee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcAttendeeDAO implements AttendeeDAO {

   private JdbcTemplate jdbcTemplate;
   public JdbcAttendeeDAO(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}



    @Override
    public List<Attendee> findALl() {
        List<Attendee> attendees = new ArrayList<>();
        String sql = "SELECT attendees.attendee_id, attendees.first_name, attendees.last_name, attendees.date_of_birth, attendees.gender, attendees.age_group, attendees.allergies, attendees.payment_status, " +
                "attendees.additonal_information, attendees.assigned_registrar, parents.first_name AS parent_first_name, parents.last_name AS parent_last_name, parents.email AS parent_email, parents.address AS parent_address, parents.phone AS parent_phone, emergency_contacts.first_name AS emergency_first_name, emergency_contacts.last_name AS emergency_last_name, emergency_contacts.phone AS emergency_phone " +
                "from attendees JOIN parents ON attendees.parent_id = parents.parent_id JOIN emergency_contacts ON attendees.emergency_contact_id = emergency_contacts.emergency_contact_id;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Attendee attendee = mapRowToAttendee(results);
            attendees.add(attendee);
        }

       return attendees;
    }

    private Attendee mapRowToAttendee(SqlRowSet result) {
       Attendee attendee = new Attendee();
       attendee.setAttendeeId(result.getInt("attendee_id"));
       attendee.setFirstName(result.getString("first_name"));
       attendee.setLastName(result.getString("last_name"));
        if (result.getDate("date_of_birth") != null) {
            attendee.setDateOfBirth(result.getDate("date_of_birth").toLocalDate());
        }
       attendee.setGender(result.getString("gender"));
       attendee.setAgeGroup(result.getInt("age_group"));
       attendee.setAllergies(result.getString("allergies"));
       attendee.setPaymentStatus(result.getBoolean("payment_status"));
       attendee.setAdditionalInfo(result.getString("additonal_information"));
       attendee.setAssignedRegistrar(result.getString("assigned_registrar"));
       attendee.setParentFirstName(result.getString("parent_first_name"));
       attendee.setParentLastName(result.getString("parent_last_name"));
       attendee.setParentEmail(result.getString("parent_email"));
       attendee.setAddress(result.getString("parent_address"));
       attendee.setParentPhone(result.getString("parent_phone"));
       attendee.setEmgcyFirstName(result.getString("emergency_first_name"));
       attendee.setEmgcyLastName(result.getString("emergency_last_name"));
       attendee.setEmgcyPhone(result.getString("emergency_phone"));

       return attendee;
    }
}

