package com.xenostar.AdaniDB.Controllers;

import ch.qos.logback.core.sift.AppenderFactoryUsingSiftModel;
import com.xenostar.AdaniDB.Entities.*;
import com.xenostar.AdaniDB.Services.btech2022Service;
import com.xenostar.AdaniDB.Services.btech2023Service;
import com.xenostar.AdaniDB.Services.btech2024Service;
import com.xenostar.AdaniDB.Services.au2024Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class MainController {

    private au2024Service au2024Service;
    private btech2022Service btech2022Service;
    private btech2023Service btech2023Service;
    private btech2024Service btech2024Service;

    @Autowired
    public MainController(au2024Service au2024Service,btech2022Service btech2022Service,btech2023Service btech2023Service,btech2024Service btech2024Service){
        this.au2024Service = au2024Service;
        this.btech2022Service = btech2022Service;
        this.btech2023Service = btech2023Service;
        this.btech2024Service = btech2024Service;
    }


    @GetMapping("api/all/au2024")
    public ResponseEntity<List<Au2024>> getAll(){
        return ResponseEntity.ok(au2024Service.findAll());
    }

    @GetMapping("api/search/au2024/enrollment")
    public ResponseEntity<List<Au2024>> searchAu2024ByEnrollment(@RequestParam Long enrollment){
            return ResponseEntity.ok(au2024Service.findByEnrollment(enrollment));
    }

    @GetMapping("api/search/au2024/name")
    public ResponseEntity<List<Au2024>> searchAu2024ByName(@RequestParam String name){
        return ResponseEntity.ok(au2024Service.findByName(name));
    }

    @GetMapping("api/search/btech2022/enrollment")
    public ResponseEntity<List<Btech2022>> searchBtech2022ByEnrollment(@RequestParam Long enrollment ){
        return ResponseEntity.ok(btech2022Service.findByEnrollment(enrollment));
    }

    @GetMapping("api/search/btech2023/enrollment")
    public ResponseEntity<List<Btech2023>> searchBtech2023ByEnrollment(@RequestParam Long enrollment ){
        return ResponseEntity.ok(btech2023Service.findByEnrollment(enrollment));
    }

    @GetMapping("api/search/btech2024/name")
    public ResponseEntity<List<Btech2024>> searchBtech2024ByName(@RequestParam String name ){
        return ResponseEntity.ok(btech2024Service.findByName(name));
    }

    @GetMapping("api/search/btech2024/enrollment")
    public ResponseEntity<List<Btech2024_2>> searchBtech2024ByEnrollment(@RequestParam Long enrollment){
        return ResponseEntity.ok(btech2024Service.findByEnrollment(enrollment));
    }









//    @GetMapping("/api/students/search")
//    public ResponseEntity<List<Object>> searchStudents(
//            @RequestParam(required = false) Long enrollment,
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String batch) {
//
//        // Validate input: at least one of enrollment or name must be provided
//        if (enrollment == null && (name == null || name.isEmpty())) {
//            return ResponseEntity.badRequest().body(null);
//        }
//
//        List<Object> results = new ArrayList<>();
//
//        // If batch is not specified, search all tables; otherwise, search the specified batch
//        if (batch == null || batch.isEmpty() || batch.equals("au2024")) {
//            results.addAll(au2024Service.searchStudents(enrollment, name));
//        }
//        if (batch == null || batch.isEmpty() || batch.equals("btech2022")) {
//            results.addAll(btech2022Service.searchStudents(enrollment != null ? enrollment : null, name));
//        }
//        if (batch == null || batch.isEmpty() || batch.equals("btech2023")) {
//            results.addAll(btech2023Service.searchStudents(enrollment, name));
//        }
//        if (batch == null || batch.isEmpty() || batch.equals("btech2024")) {
//            results.addAll(btech2024Service.searchStudents(enrollment, name));
//        }
//
//        if (results.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//
//        return ResponseEntity.ok(results);
//    }
//
//    @GetMapping("/api/students/all")
//    public ResponseEntity<List<Object>> getAllStudents(
//            @RequestParam(required = false) String batch) {
//
//        List<Object> results = new ArrayList<>();
//
//        if (batch == null || batch.isEmpty() || batch.equals("au2024")) {
//            results.addAll(au2024Service.getAllStudents());
//        }
//        if (batch == null || batch.isEmpty() || batch.equals("btech2022")) {
//            results.addAll(btech2022Service.getAllStudents());
//        }
//        if (batch == null || batch.isEmpty() || batch.equals("btech2023")) {
//            results.addAll(btech2023Service.getAllStudents());
//        }
//        if (batch == null || batch.isEmpty() || batch.equals("btech2024_2")) {
//            results.addAll(btech2024Service.getAllStudents());
//        }
//
//        if (results.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//
//        return ResponseEntity.ok(results);
//    }
//
//
//





}
