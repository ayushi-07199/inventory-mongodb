package com.dxctraining.mongo.suppliermgt.supplier.util;

import org.springframework.stereotype.Component;

import com.dxctraining.mongo.suppliermgt.supplier.dto.*;
import com.dxctraining.mongo.suppliermgt.supplier.entities.*;

@Component
public class SupplierUtil {

	public SupplierDto supplierDto(Supplier supplier) {
		SupplierDto dto = new SupplierDto(supplier.getId(), supplier.getName(), supplier.getPassword());
		return dto;
	}
}
