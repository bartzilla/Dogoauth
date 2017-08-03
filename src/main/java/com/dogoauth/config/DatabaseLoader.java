package com.dogoauth.config;

import com.dogoauth.data.TenantRepository;
import com.dogoauth.domain.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 *  Configuration to provide some sample data.
 *
 *  @author Cipriano Sanchez
 */

@Component
public class DatabaseLoader implements ApplicationRunner
{
    private final TenantRepository tenants;

    @Autowired
    DataSource dataSourceProduction;

    @Autowired
    public DatabaseLoader(TenantRepository tenants)
    {
        this.tenants = tenants;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        ClientRegistrationService tenants = new JdbcClientDetailsService(dataSourceProduction);

        BaseClientDetails clientDetails = new BaseClientDetails("microsoft", "orange-cannon",
                "trusted", "client_credentials", "TRUSTED");

        clientDetails.setClientSecret("trustedsecret");

        tenants.addClientDetails(clientDetails);
    }
}
