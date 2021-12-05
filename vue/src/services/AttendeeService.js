import axios from 'axios';

export default {
    getAllAttendees(){
        return axios.get("/attendees");
    }



    
}