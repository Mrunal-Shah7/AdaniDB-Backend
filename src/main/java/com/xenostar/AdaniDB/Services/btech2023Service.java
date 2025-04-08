package com.xenostar.AdaniDB.Services;

import com.xenostar.AdaniDB.Entities.Btech2023;
import com.xenostar.AdaniDB.Repositories.btech2023Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class btech2023Service {

    @Autowired
    private final btech2023Repository btech2023Repository;

    public btech2023Service(btech2023Repository btech2023Repository){
        this.btech2023Repository = btech2023Repository;
    }

    public List<Btech2023> findAll() {
        return btech2023Repository.findAll();
    }

    public List<Btech2023> findByEnrollment(Long enrollment){
        if(enrollment!=null){
            return btech2023Repository.findByEnrollment(enrollment);
        }else {
            return List.of();
        }
    }

    public List<Btech2023> findByName(String name){
        if(!name.isEmpty()){
            return btech2023Repository.findByName(name);
        }else {
            return List.of();
        }
    }

}