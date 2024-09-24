package com.rb.ppm.core.repository;

import com.rb.ppm.core.domain.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository  extends JpaRepository<InvoiceEntity, Long> {
}
