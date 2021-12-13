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
        String sql = "SELECT attendees.attendee_id, attendees.attendee_name, attendees.date_of_birth, attendees.gender, attendees.age_group, attendees.payment_status, attendees.notes, attendees.registrar, attendees.img_url, " +
                "guardians.guardian_name, guardians.email, guardians.address, guardians.guardian_phone, guardians.emergency_name, guardians.emergency_phone, dorm_name From attendees JOIN guardians ON attendees.guardian_id = guardians.guardian_id " +
                "JOIN dorms ON attendees.dorm_id = dorms.dorm_id ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Attendee attendee = mapRowToAttendee(results);
            attendees.add(attendee);
        }

       return attendees;
    }
    @Override
    public Attendee updateAttendeeInfo(Attendee attendee){
            String sql = "Update attendees SET attendee_name = ?, date_of_birth = ?, gender = ?, payment_status = ?, " +
                    "notes = ?, registrar = ?, img_url = ? WHERE attendee_id = ?";
            jdbcTemplate.update(sql,attendee.getAttendeeName(),attendee.getDateOfBirth(),attendee.getGender(),attendee.getPaymentStatus(),
                    attendee.getNotes(), attendee.getRegistrar(), attendee.getImgURL(), attendee.getAttendeeId());
            String guardianSql = "Update guardians SET email = ?, address = ?, guardian_phone = ?, emergency_name = ?, " +
                "emergency_phone = ? WHERE guardian_name = ?";
            jdbcTemplate.update(guardianSql,attendee.getEmail(),attendee.getAddress(),attendee.getGuardianPhone(),attendee.getEmgcyName(),
                attendee.getEmgcyPhone(), attendee.getGuardianName());
//            String dormSql = "Update dorms SET dorm_name = ? WHERE dorm_id = ?";
//            jdbcTemplate.update(dormSql,attendee.getDormName());
//
//
//        Attendee newAttendee = null;
//
//        String newSql = "SELECT attendee_name, date_of_birth, gender " +
//                "age_group, payment_status, notes, registrar WHERE attendee_id = ?";
//        SqlRowSet rows = jdbcTemplate.queryForRowSet(newSql, attendee.getAttendeeId());
//        while (rows.next()) {
//            attendee = new Attendee();
//            attendee.setAttendeeId(attendee.getAttendeeId());
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
        return attendee;

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
       attendee.setImgURL(result.getString("img_url"));
       attendee.setDormName(result.getString("dorm_name"));
       //attendee.setDormId(result.getInt("dorm_id"));


       return attendee;
    }

}


