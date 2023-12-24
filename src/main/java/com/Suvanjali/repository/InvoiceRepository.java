package com.Suvanjali.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Suvanjali.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

	List<Invoice> findAllByDateBetween(LocalDate fromDate,LocalDate toDate );
}
