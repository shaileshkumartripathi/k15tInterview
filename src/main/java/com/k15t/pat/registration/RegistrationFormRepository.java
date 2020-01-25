package com.k15t.pat.registration;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface RegistrationFormRepository extends JpaRepository<RegistrationForm, Long> {
}
