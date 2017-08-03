package com.dogoauth.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Columns;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Set;

/**
 * Created by ciprianosanchez on 8/1/17.
 */
@Entity
public class Tenant extends BaseClientDetails
{
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String clientId;
    private String clientSecret;
    private String scopes;
    private String grantType;
    private String authority;

    public Tenant()
    {
        super();
    }

    public Tenant(String clientId, String clientSecret, String scopes, String grantType, String authority)
    {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.scopes = scopes;
        this.grantType = grantType;
        this.authority = authority;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getClientId()
    {
        return clientId;
    }

    public void setClientId(String client)
    {
        this.clientId = client;
    }

    @Override
    public String getClientSecret()
    {
        return clientSecret;
    }

    @Override
    public void setClientSecret(String clientSecret)
    {
        this.clientSecret = clientSecret;
    }

    public String getScopes()
    {
        return scopes;
    }

    public void setScopes(String scopes)
    {
        this.scopes = scopes;
    }

    public String getGrantType()
    {
        return grantType;
    }

    public void setGrantType(String grantType)
    {
        this.grantType = grantType;
    }

    public String getAuthority()
    {
        return authority;
    }

    public void setAuthority(String authority)
    {
        this.authority = authority;
    }

}
