package com.techelevator.dao;

import com.techelevator.model.Attendee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcAttendeeDAOIntegrationTest extends DAOIntegrationTest{
    private static final int TEST_PARENT_ID = 200;
    private static final int TEST_EMERGENCY_ID = 700;
    private JdbcAttendeeDAO jdbcAttendeeDAO;

    @Before
    public void setup(){
        String sqlInsertParent = "INSERT INTO parents(parent_id, first_name, last_name, email, address, phone) " +
            "VALUES (DEFAULT, 'Billy', 'Musk', 'rechelle123@gmail.com', '123 tech road, columbus, ohio, 43213', '614-111-2222');";
        String sqlInsertEmergency = "INSERT INTO emergency_contacts(emergency_contact_id, first_name, last_name, email, address, phone) " +
                "VALUES (DEFAULT, 'Larry', 'King', 'eva123@gmail.com', '123 tech road, columbus, ohio, 43213', '614-111-3333');";

        DataSource dataSource = this.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sqlInsertParent, TEST_PARENT_ID);
        jdbcTemplate.update(sqlInsertEmergency, TEST_EMERGENCY_ID);
        jdbcAttendeeDAO = new JdbcAttendeeDAO(jdbcTemplate);

    }

//    @Test
//    public void list_all_attendees(){
//
//    }
//
//    private Attendee insertAttendee(){
//        Attendee attendee = new Attendee();
//        attendee.setFirstName("Joe");
//        attendee.setLastName("Bone");
//        attendee
//
//    }

}
