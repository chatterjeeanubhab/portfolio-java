package com.portfolio.anubhab.portfolio.repository;

import com.portfolio.anubhab.portfolio.model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactMessage, Long> {
}
