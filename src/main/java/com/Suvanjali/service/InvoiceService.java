package com.Suvanjali.service;

import java.time.LocalDate;
import java.util.List;

import com.Suvanjali.dto.OrderDetailsDto;
import com.Suvanjali.entity.Cart;
import com.Suvanjali.entity.Invoice;

public interface InvoiceService {

	Invoice findById(int id);
	List<Invoice> findAll();
	Invoice save(Invoice invoice, Cart cart);
	List<OrderDetailsDto> findByDate(LocalDate fromDate, LocalDate toDate);
	List<OrderDetailsDto> invoiceGenerator(List<Invoice> invoices);
	List<OrderDetailsDto> findByCategory(int categoryId);
	Invoice save(Invoice invoice);
	List<OrderDetailsDto> findAllOrders();
	
}
