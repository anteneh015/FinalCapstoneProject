package com.techelevator.controller;

import com.techelevator.dao.AttendeeDAO;
import com.techelevator.model.Attendee;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin

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

    @RequestMapping( path = "/attendees/{id}", method = RequestMethod.PUT)
    public Attendee update(@PathVariable("id") int attendeeId, @RequestBody Attendee attendee){
        attendeeDAO.updateAttendeeInfo(attendee);
        return attendee;
    }


}
