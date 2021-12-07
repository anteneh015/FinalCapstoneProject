package com.techelevator.dao;

import com.techelevator.model.Attendee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

public class JdbcAttendeeDAOIntegrationTest extends DAOIntegrationTest{
    private static final int TEST_PARENT_ID = 200;
    private JdbcAttendeeDAO jdbcAttendeeDAO;

    private JdbcTemplate jdbcTemplate;

    @Before
    public void setup(){
        String sqlInsertParent = "INSERT INTO guardians(guardian_id, guardian_name, email, address, guardian_phone, " +
                "emergency_name, emergency_phone) VALUES (DEFAULT, 'Tese Name', 'rachelle123@gmail.com', " +
                "'123 tech road, columbus, ohio, 43213', '614-111-2222', 'Eva', 'Rauh');";
        DataSource dataSource = this.getDataSource();
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sqlInsertParent, TEST_PARENT_ID);
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
        attendee.setPaymentStatus(true);
        attendee.setNotes("nothing");
        attendee.setRegistrar("James");

        String sqlInsertAttendee = "INSERT INTO attendees VALUES (default, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING attendee_id";
        Integer attendeeID = jdbcTemplate.queryForObject(sqlInsertAttendee, Integer.class, TEST_PARENT_ID, 1, attendee.getAttendeeName(),
                attendee.getDateOfBirth(), attendee.getGender(), attendee.getAgeGroup(), attendee.isPaymentStatus(),
                attendee.getNotes(), attendee.getRegistrar());
        attendee.setAttendeeId(attendeeID);
        return attendee;
    }

}
