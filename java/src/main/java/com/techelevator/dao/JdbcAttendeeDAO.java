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
        String sql = "select * from attendees";

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
       return attendee;
    }
}

