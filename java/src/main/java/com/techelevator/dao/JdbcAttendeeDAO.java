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
        String sql = "SELECT attendees.attendee_id, attendees.attendee_name, attendees.date_of_birth, attendees.gender, " +
                "attendees.age_group, attendees.payment_status, attendees.notes, attendees.registrar, " +
                "guardians.guardian_name, guardians.email, guardians.address, guardians.guardian_phone, guardians.emergency_name, " +
                "guardians.emergency_phone " +
                "From attendees JOIN guardians ON attendees.guardian_id = guardians.guardian_id ";

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
       attendee.setAttendeeName(result.getString("attendee_name"));
        if (result.getDate("date_of_birth") != null) {
            attendee.setDateOfBirth(result.getDate("date_of_birth").toLocalDate());
        }
       attendee.setGender(result.getString("gender"));
       attendee.setAgeGroup(result.getInt("age_group"));
       attendee.setPaymentStatus(result.getString("payment_status"));
       attendee.setNotes(result.getString("notes"));
       attendee.setRegistrar(result.getString("registrar"));
       attendee.setGuardianName(result.getString("guardian_name"));
       attendee.setEmail(result.getString("email"));
       attendee.setAddress(result.getString("address"));
       attendee.setGuardianPhone(result.getString("guardian_phone"));
       attendee.setEmgcyName(result.getString("emergency_name"));
       attendee.setEmgcyPhone(result.getString("emergency_phone"));

       return attendee;
    }
}

