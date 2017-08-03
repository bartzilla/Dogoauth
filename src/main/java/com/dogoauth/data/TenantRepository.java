package com.dogoauth.data;

import com.dogoauth.domain.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ciprianosanchez on 8/1/17.
 */
public interface TenantRepository extends JpaRepository<Tenant, Long>
{
    Tenant findTenantByClientId(String clientId);
}
