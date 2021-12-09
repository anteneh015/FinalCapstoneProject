import axios from 'axios';

export default {
    getAllAttendees(){
        return axios.get("/attendees");
    },

    updateAttendee(attendee){
        return axios.put(`/attendees/${attendee.id}`, attendee);
    }



    
}