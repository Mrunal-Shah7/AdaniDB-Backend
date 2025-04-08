package com.xenostar.AdaniDB.Services;

import com.xenostar.AdaniDB.Entities.Au2024;
import com.xenostar.AdaniDB.Repositories.au2024Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class au2024Service {

    @Autowired
    private final au2024Repository au2024Repository;


    public au2024Service(au2024Repository au2024Repository){
            this.au2024Repository = au2024Repository;
    }


    public List<Au2024> findAll(){
        return au2024Repository.findAll();
    }

    public List<Au2024> findByEnrollment(Long enrollment){
        if(enrollment!=null){
            return au2024Repository.findByEnrollment(enrollment);
        }else {
            return List.of();
        }
    }

    public List<Au2024> findByName(String name){
        if(!name.isEmpty()){
            return au2024Repository.findByName(name);
        }else {
            return List.of();
        }

    }

    public List<Au2024> findByYear(Integer year){
        return au2024Repository.findByYear(year);
    }   


}
