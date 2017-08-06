package com.dogoauth.config;

//import com.dogoauth.services.DetailsService;
import com.dogoauth.services.DetailsService;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.ClientDetailsService;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter
{
    @Autowired
    DetailsService clientDetailService;

    @Autowired
    DataSource dataSourceProduction;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception
    {
        clients.jdbc(dataSourceProduction);

//        clients.inMemory().withClient("microsoft")
//                .authorizedGrantTypes("client_credentials")
//                .authorities("TRUSTED")
//                .scopes("microsoft")
//                .secret("trustedsecret")
//                .and().withClient("google").authorizedGrantTypes("client_credentials").authorities("TRUSTED").scopes("google").secret("trustedsecret");

    }

}