package com.dogoauth.controllers;

import com.dogoauth.domain.Tenant;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ciprianosanchez on 8/2/17.
 */
@RestController
public class AccountController
{
    @RequestMapping("/tenants")
    public List<Tenant> getAllEvents()
    {
        Tenant tenant = new Tenant();

        return Arrays.asList(tenant);
    }
}
