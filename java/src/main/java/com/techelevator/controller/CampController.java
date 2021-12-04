package com.techelevator.controller;

import com.techelevator.dao.AttendeeDAO;
import com.techelevator.model.Attendee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController

public class CampController {

    private AttendeeDAO attendeeDAO;

    public CampController(AttendeeDAO attendeeDAO){
        this.attendeeDAO = attendeeDAO;

    }

    @RequestMapping( path = "/attendees", method = RequestMethod.GET)
    public List<Attendee> attendeeList() {
        List<Attendee>  attendeesList = attendeeDAO.findALl();
        return attendeesList;
    }
}
