package com.xenostar.AdaniDB.Repositories;

import com.xenostar.AdaniDB.Entities.Btech2022;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class btech2022Repository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public btech2022Repository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Btech2022 mapRowToBtech2022(ResultSet rs, int rowNum) throws SQLException {
        Btech2022 btech2022 = new Btech2022();
        btech2022.setName(rs.getString("name"));
        btech2022.setUSN(rs.getString("usn"));
        btech2022.setContact(rs.getString("contact"));
        btech2022.setEnrollment(rs.getLong("enrollment"));
        btech2022.setDivision(rs.getString("division"));
        return btech2022;
    }

    public List<Btech2022> findAll() {
        String sql = "SELECT * FROM btech2022";
        return jdbcTemplate.query(sql, this::mapRowToBtech2022);
    }

    public List<Btech2022> findByEnrollment(long enrollment) {
        String sql = "SELECT * FROM btech2022 WHERE enrollment = ?";
        return jdbcTemplate.query(sql, this::mapRowToBtech2022, enrollment);
    }

    public List<Btech2022> findByName(String name) {
        String sql = "SELECT * FROM btech2022 WHERE LOWER(name) LIKE LOWER(?)";
        return jdbcTemplate.query(sql, this::mapRowToBtech2022, "%" + name + "%");
    }

    public List<Btech2022> findByUsn(String usn){
        String sql = "SELECT * FROM btech2022 WHERE LOWER(usn) LIKE LOWER(?)";
        return jdbcTemplate.query(sql,this::mapRowToBtech2022,"%" + usn + "%");
    }



}