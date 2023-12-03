package com.personal.tax.svc.service;

import com.personal.tax.model.dto.TaxResponseDto;
import com.personal.tax.model.enums.TaxSlabEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TaxDomainServiceTests {

	@InjectMocks
	TaxDomainService taxDomainService;

	@Test
	void testCalculateTax() {
		TaxResponseDto testResponse = new TaxResponseDto();
		testResponse = taxDomainService.calculateTaxAmount(5000.0, testResponse);
		Assertions.assertEquals(0, testResponse.getTaxAmount());
		Assertions.assertEquals(TaxSlabEnum.CATEGORY_A, testResponse.getTaxSlab());
	}

}
