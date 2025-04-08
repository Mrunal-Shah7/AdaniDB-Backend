package com.xenostar.AdaniDB.Services;


import com.xenostar.AdaniDB.Entities.Btech2024;
import com.xenostar.AdaniDB.Entities.Btech2024_2;
import com.xenostar.AdaniDB.Repositories.btech2024Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class btech2024Service {

    @Autowired
    private btech2024Repository btech2024Repository;

    public btech2024Service(btech2024Repository btech2024Repository){
        this.btech2024Repository = btech2024Repository;
    }


    public List<Btech2024> findAll() {
        return btech2024Repository.findAll();
    }

    public List<Btech2024> findByTemp(String temp){
        if(!temp.isEmpty()){
            return btech2024Repository.findByTemp(temp);
        }else {
            return List.of();
        }
    }

    public List<Btech2024> findByName(String name){
        if(!name.isEmpty()){
            return btech2024Repository.findByName(name);
        }else {
            return List.of();
        }
    }

    public List<Btech2024_2> findByEnrollment(Long enrollment){
        if(enrollment!=null){
            return btech2024Repository.findByEnrollment(enrollment);
        }
        else {
            return List.of();
        }
    }

}
