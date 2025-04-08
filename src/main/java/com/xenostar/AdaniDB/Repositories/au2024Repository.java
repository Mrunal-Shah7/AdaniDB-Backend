package com.xenostar.AdaniDB.Repositories;

import com.xenostar.AdaniDB.Entities.Au2024;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class au2024Repository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public au2024Repository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Au2024 mapRowToAu2024(ResultSet rs, int rowNum) throws SQLException {
        Au2024 au2024 = new Au2024();
        au2024.setEnrollment(rs.getLong("enrollment")); // Use exact case "Enrollment"
        au2024.setName(rs.getString("name"));           // Use exact case "Name"
        au2024.setYear(rs.getInt("year"));              // Use exact case "Year"
        au2024.setDivision(rs.getString("division"));   // Use exact case "Division"
        return au2024;
    }

    public List<Au2024> findAll() {
        String sql = "SELECT * FROM au2024";
        return jdbcTemplate.query(sql, this::mapRowToAu2024);
    }

    public List<Au2024> findByYear(Integer year){
        String sql = "SELECT * FROM au204 WHERE year = ?";
        return jdbcTemplate.query(sql,this::mapRowToAu2024);
    }


    public List<Au2024> findByEnrollment(Long enrollment) {
        String sql = "SELECT * FROM au2024 WHERE enrollment = ?"; // Use quoted "Enrollment" for case sensitivity
        return jdbcTemplate.query(sql, this::mapRowToAu2024, enrollment);
    }

    public List<Au2024> findByName(String name) {
        String sql = "SELECT * FROM au2024 WHERE LOWER(name) LIKE LOWER(?)"; // Use quoted "Name" for case sensitivity
        return jdbcTemplate.query(sql, this::mapRowToAu2024, "%" + name + "%");
    }
}