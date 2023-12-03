package com.personal.tax.svc.controller;

import com.personal.tax.model.dto.TaxRequestDto;
import com.personal.tax.model.dto.TaxResponseDto;
import com.personal.tax.svc.service.TaxDomainService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TaxDomainControllerTests {

	@InjectMocks
    TaxDomainController taxDomainController;

	@Mock
	TaxDomainService taxDomainService;

	@Test
	void testCalculateTax() {
		Mockito.when(taxDomainService.calculateTaxAmount(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(new TaxResponseDto());
		TaxResponseDto testResponse = taxDomainController.calculateTax(new TaxRequestDto());
		Assertions.assertEquals(25, testResponse.getTaxClaimOptions().size());

	}

}
