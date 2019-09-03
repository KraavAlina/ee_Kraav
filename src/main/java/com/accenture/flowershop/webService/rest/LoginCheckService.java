package com.accenture.flowershop.webService.rest;


import com.accenture.flowershop.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Service
@Path("/check_login")
public class LoginCheckService {

    @Autowired
    UserService userService;

    @Path("/{login}")
    @GET
    public boolean checkLogin(@PathParam("login") String login) {
        return userService.findByLogin(login) != null;
    }
}