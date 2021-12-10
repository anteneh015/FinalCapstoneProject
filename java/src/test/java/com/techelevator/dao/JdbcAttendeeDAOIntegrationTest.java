package com.techelevator.dao;

import com.techelevator.model.Attendee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

public class JdbcAttendeeDAOIntegrationTest extends DAOIntegrationTest{
    private static final int TEST_GUARDIAN_ID = 200;
    private JdbcAttendeeDAO jdbcAttendeeDAO;

    private JdbcTemplate jdbcTemplate;

    @Before
    public void setup(){
        String sqlInsert = "INSERT INTO guardians(guardian_id, guardian_name, email, address, guardian_phone, " +
                "emergency_name, emergency_phone) VALUES (?, 'Test Name', 'rachelle123@gmail.com', " +
                "'123 tech road, columbus, ohio, 43213', '614-111-2222', 'Eva rauh', '614-111-2222');";
        DataSource dataSource = this.getDataSource();
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sqlInsert, TEST_GUARDIAN_ID);
        jdbcAttendeeDAO = new JdbcAttendeeDAO(jdbcTemplate);
    }

    @Test
    public void list_all_attendees(){
        int originalRowCount = jdbcAttendeeDAO.findALl().size();
        insertAttendee();
        List<Attendee> actualResults = jdbcAttendeeDAO.findALl();

        Assert.assertEquals(originalRowCount + 1, actualResults.size());
    }

    private Attendee insertAttendee(){
        Attendee attendee = new Attendee();
        attendee.setAttendeeName("Joe Bone");
        attendee.setDateOfBirth(LocalDate.of(2014,8,23));
        attendee.setGender("male");
        attendee.setAgeGroup(2);
        attendee.setPaymentStatus("paid");
        attendee.setNotes("nothing");
        attendee.setRegistrar("James");


        String sqlInsertAttendee = "INSERT INTO attendees VALUES ( DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING attendee_id";
        Integer attendeeId = jdbcTemplate.queryForObject(sqlInsertAttendee, Integer.class, TEST_GUARDIAN_ID, 1, attendee.getAttendeeName(),
                attendee.getDateOfBirth(), attendee.getGender(), attendee.getAgeGroup(), attendee.getPaymentStatus(),
                attendee.getNotes(), attendee.getRegistrar());
        attendee.setAttendeeId(attendeeId);
        return attendee;
    }

    @Test
    public void edit_attendees(){
        Attendee attendee = insertAttendee();
        attendee.setAttendeeName("updatedName");
        attendee.setGender("updatedGender");


        Attendee attendeeFromDatabase = jdbcAttendeeDAO.updateAttendeeInfo(attendee);
        Assert.assertEquals(attendee.getAttendeeName(), attendeeFromDatabase.getAttendeeName());
    }
//    private Attendee selectAttendeeById(int attendeeId) {
//        Attendee attendee = null;
//
//        String sql = "SELECT attendee_name, date_of_birth, gender " +
//                "age_group, payment_status, notes, registrar WHERE attendee_id = ?";
//        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, attendeeId);
//        while (rows.next()) {
//            attendee = new Attendee();
//            attendee.setAttendeeId(attendeeId);
//            attendee.setAttendeeName(rows.getString("attendee_name"));
//            attendee.setDateOfBirth(rows.getDate("date_of_birth").toLocalDate());
//            attendee.setGender(rows.getString("gender"));
//            attendee.setAgeGroup(rows.getInt("age_group"));
//            attendee.setPaymentStatus(rows.getString("payment_status"));
//            attendee.setNotes(rows.getString("notes"));
//            attendee.setRegistrar(rows.getString("registrar"));
//
//
//        }
//        return attendee;
//    }
}
