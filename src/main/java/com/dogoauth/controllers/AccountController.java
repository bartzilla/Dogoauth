package com.dogoauth.controllers;

import com.dogoauth.domain.Tenant;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ciprianosanchez on 8/2/17.
 */
@RestController
public class AccountController
{
    @RequestMapping("{clientId}/accounts")
    public List<Tenant> getAllAccounts(@PathVariable String clientId)
    {
        Tenant tenant = new Tenant();

        System.out.println("The client id is: " + clientId);
        return Arrays.asList(tenant);
    }
}
