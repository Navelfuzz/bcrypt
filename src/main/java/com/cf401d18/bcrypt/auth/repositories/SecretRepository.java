package com.cf401d18.bcrypt.auth.repositories;

import com.cf401d18.bcrypt.auth.models.Secret;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretRepository extends JpaRepository<Secret, Long> {
    public Secret getSecretByCodeName(String codeName);
}