package com.cf401d18.bcrypt.auth.repositories;

import com.cf401d18.bcrypt.auth.models.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {
    public SiteUser findSiteUserByUserName(String userName);
}