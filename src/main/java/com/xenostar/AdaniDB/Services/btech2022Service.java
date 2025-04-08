package com.xenostar.AdaniDB.Services;


import com.xenostar.AdaniDB.Entities.Btech2022;
import com.xenostar.AdaniDB.Repositories.btech2022Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class btech2022Service {

    @Autowired
    private btech2022Repository btech2022Repository;

    public List<Btech2022> findAll(){
        return btech2022Repository.findAll();
    }

    public List<Btech2022> findByEnrollment(Long enrollment){
        if(enrollment!=null){
            return btech2022Repository.findByEnrollment(enrollment);
        }else {
            return List.of();
        }
    }

    public List<Btech2022> findByName(String name){
        if(!name.isEmpty()){
            return btech2022Repository.findByName(name);
        }else {
            return List.of();
        }
    }

    public List<Btech2022> findByUsn(String usn){
        if(!usn.isEmpty()){
            return btech2022Repository.findByUsn(usn);
        }else {
            return List.of();
        }
    }







}
