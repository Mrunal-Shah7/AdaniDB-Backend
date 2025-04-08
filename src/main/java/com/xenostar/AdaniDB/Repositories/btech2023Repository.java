package com.xenostar.AdaniDB.Repositories;


import com.xenostar.AdaniDB.Entities.Btech2023;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class btech2023Repository {
    private final JdbcTemplate jdbcTemplate;

    public btech2023Repository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Btech2023 mapRowToBtech2023(ResultSet rs,int rowNum) throws SQLException{
        Btech2023 btech2023 = new Btech2023();
        btech2023.setEnrollment(rs.getLong("enrollment"));
        btech2023.setName(rs.getString("name"));
        btech2023.setDivision(rs.getString("division"));
        return btech2023;
    }
    public List<Btech2023> findAll() {
        String sql = "SELECT * FROM btech2023";
        return jdbcTemplate.query(sql, this::mapRowToBtech2023);
    }

    public List<Btech2023> findByEnrollment(Long enrollment) {
        String sql = "SELECT * FROM btech2023 WHERE enrollment = ?";
        return jdbcTemplate.query(sql, this::mapRowToBtech2023, enrollment);
    }

    public List<Btech2023> findByName(String name) {
        String sql = "SELECT * FROM btech2023 WHERE LOWER(name) LIKE LOWER(?)";
        return jdbcTemplate.query(sql, this::mapRowToBtech2023, "%" + name + "%");
    }


}
