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
    private static final int TEST_EMERGENCY_ID = 700;
    private JdbcAttendeeDAO jdbcAttendeeDAO;

    private JdbcTemplate jdbcTemplate;

    @Before
    public void setup(){
        String sqlInsertParent = "INSERT INTO parents(parent_id, first_name, last_name, email, address, phone) " +
            "VALUES (?, 'Billy', 'Musk', 'rechelle123@gmail.com', '123 tech road, columbus, ohio, 43213', '614-111-2222');";
        String sqlInsertEmergency = "INSERT INTO emergency_contacts(emergency_contact_id, first_name, last_name, email, address, phone) " +
                "VALUES (?, 'Larry', 'King', 'eva123@gmail.com', '123 tech road, columbus, ohio, 43213', '614-111-3333');";

        DataSource dataSource = this.getDataSource();
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sqlInsertParent, TEST_PARENT_ID);
        jdbcTemplate.update(sqlInsertEmergency, TEST_EMERGENCY_ID);
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
        attendee.setFirstName("Joe");
        attendee.setLastName("Bone");
        attendee.setDateOfBirth(LocalDate.of(2014,8,23));
        attendee.setGender("male");
        attendee.setAgeGroup(2);
        attendee.setAllergies("peanut butter");
        attendee.setPaymentStatus(true);
        attendee.setAdditionalInfo("nothing");
        attendee.setAssignedRegistrar("James");

        String sqlInsertAttendee = "INSERT INTO attendees VALUES (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING attendee_id";
        Integer attendeeID = jdbcTemplate.queryForObject(sqlInsertAttendee, Integer.class, TEST_PARENT_ID, 1, TEST_EMERGENCY_ID, attendee.getFirstName(),
                attendee.getLastName(), attendee.getDateOfBirth(), attendee.getGender(), attendee.getAgeGroup(), attendee.getAllergies(),
                attendee.isPaymentStatus(), attendee.getAdditionalInfo(), attendee.getAssignedRegistrar());
        attendee.setAttendeeId(attendeeID);
        return attendee;
    }

}
