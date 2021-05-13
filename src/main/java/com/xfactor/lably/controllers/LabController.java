package com.xfactor.lably.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import com.xfactor.lably.entity.Lab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;
// -----Admin controller----
// Add Admin (POST)
// List of admins - Must return 5 admin objects (GET)
// Api to return single admin by username (GET)

@RestController
@RequestMapping("/lab")
public class LabController {

    ArrayList<Lab> labs = new ArrayList<>();

    @GetMapping("/hello")
    public String hello() {
        return "This is labs api";
    }
    @GetMapping("/getLabs")
    public ArrayList<Lab> getAdmins() {
        return labs;
    }
    @PostMapping("/addLabs")
    public Lab addLab(@RequestBody Lab lb) {
        labs.add(lb);
        return lb;
    }
    @GetMapping("/get/{name}")
    public Lab findAdmin(@PathVariable String name){
        Lab nul = new Lab();
        for( Lab x: labs){
            if( x.getName().equals(name) ){
                return x;
            }
        }
        return nul;
    }

}