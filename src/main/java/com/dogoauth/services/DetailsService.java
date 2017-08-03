package com.dogoauth.services;

import com.dogoauth.data.TenantRepository;
import com.dogoauth.domain.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

/**
 * This class represents a concrete implementation of the {@link ClientDetailsService} interface.
 *
 *  @author Cipriano Sanchez
 */

@Component
public class DetailsService implements ClientDetailsService
{
    @Autowired
    TenantRepository tenants;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException
    {
        Tenant tenant = tenants.findTenantByClientId(clientId);

        if (tenant == null)
        {
            throw new ClientRegistrationException(clientId + " was not found.");
        }

        return tenant;
    }
}
