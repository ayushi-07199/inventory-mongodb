package com.dxctraining.mongo.suppliermgt;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.mongo.suppliermgt.supplier.entities.*;
import com.dxctraining.mongo.suppliermgt.supplier.service.*;

@Component
public class UI {

	@Autowired
	private ISupplierService service;

	@PostConstruct
	public void start() {
		Supplier supplier1 = new Supplier("Ayushi", "qwerty");
		supplier1 = createSupplier(supplier1);
		String id1 = supplier1.getId();
		displaySupplierById(id1);

		Supplier supplier2 = new Supplier("Anmol", "qwerty");
		supplier2 = createSupplier(supplier2);
		String id2 = supplier2.getId();
		displaySupplierById(id2);

		
	}

	public void displayAll() {
		System.out.println("---Inside displayAll---");
		List<Supplier> list = service.findAll();
		for (Supplier supplier : list) {
			displaySupplier(supplier);
		}
	}

	public Supplier createSupplier(Supplier supplier) {
		System.out.println("---Inside createSupplier---");
		supplier = service.save(supplier);
		displaySupplier(supplier);
		return supplier;

	}

	public void displaySupplier(Supplier supplier) {
		System.out.println(supplier.getId() + " Name= " + supplier.getName() + " Password= " + supplier.getPassword());
	}

	public void displaySupplierById(String id) {
		System.out.println("---Inside displaySupplierById---");
		Supplier supplier = service.findById(id);
		displaySupplier(supplier);
	}
	
	public void displaySupplierByName(String name) {
		System.out.println("---Inside displaySupplierByName---");
		List<Supplier>list=service.findByName(name);
		for(Supplier supplier:list) {
			displaySupplier(supplier);
		}
	}
}
