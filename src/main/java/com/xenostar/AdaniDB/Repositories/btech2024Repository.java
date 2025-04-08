package com.xenostar.AdaniDB.Repositories;


import com.xenostar.AdaniDB.Entities.Btech2024;
import com.xenostar.AdaniDB.Entities.Btech2024_2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class btech2024Repository {

    private final JdbcTemplate jdbcTemplate;

    public btech2024Repository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Btech2024 mapRowToBtech2024(ResultSet rs, int rowNum) throws SQLException {
        Btech2024 btech2024 = new Btech2024();
        btech2024.setSR(rs.getLong("sr"));
        btech2024.setTEMP(rs.getString("temp"));
        btech2024.setNAME(rs.getString("name"));
        btech2024.setPROGRAM(rs.getString("program"));
        btech2024.setDIVISION(rs.getString("division"));
        return btech2024;
    }

    private Btech2024_2 mapRowToBtech2024_2(ResultSet rs,int rowNum)throws SQLException{
        Btech2024_2 btech2024_2 = new Btech2024_2();
        btech2024_2.setEnrollment(rs.getLong("enrollment"));
        btech2024_2.setName(rs.getString("name"));
        btech2024_2.setYear(rs.getInt("year"));
        btech2024_2.setDivision(rs.getString("division"));
        btech2024_2.setTemp(rs.getString("temp"));
        return btech2024_2;
    }




    public List<Btech2024> findAll() {
        String sql = "SELECT * FROM btech2024";
        return jdbcTemplate.query(sql, this::mapRowToBtech2024);
    }

    public List<Btech2024> findByTemp(String temp){
        String sql = "SELECT * FROM btech2024 WHERE LOWER(temp) like LOWER(?)";
        return jdbcTemplate.query(sql,this::mapRowToBtech2024,"%" + temp + "%");
    }

    public List<Btech2024> findByName(String name) {
        String sql = "SELECT * FROM btech2024 WHERE LOWER(name) LIKE LOWER(?)";
        return jdbcTemplate.query(sql, this::mapRowToBtech2024, "%" + name + "%");
    }

    public List<Btech2024_2> findByEnrollment(Long enrollment){
        String sql = "SELECT * FROM btech2024_2 WHERE enrollment = ?";
        return jdbcTemplate.query(sql,this::mapRowToBtech2024_2,enrollment);
    }


}
