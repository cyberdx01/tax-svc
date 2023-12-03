package com.personal.tax.svc.controller;

import com.personal.tax.model.dto.TaxReliefDto;
import com.personal.tax.model.dto.TaxRequestDto;
import com.personal.tax.model.dto.TaxResponseDto;
import com.personal.tax.model.enums.TaxReliefEnum;
import com.personal.tax.svc.service.TaxDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tax-svc")
public class TaxDomainController {

    @Autowired
    private TaxDomainService taxDomainService;

    @PostMapping(value = "/calculate")
    public TaxResponseDto calculateTax (@RequestBody TaxRequestDto requestDto) {
        TaxResponseDto responseDto = new TaxResponseDto();
        responseDto = taxDomainService.calculateTaxAmount(requestDto.getAnnualIncome(), responseDto);
        responseDto.setTaxClaimOptions(Arrays.stream(TaxReliefEnum.values()).map(this::mapTaxReliefEnumToDto).collect(Collectors.toList()));

        return responseDto;
    }

    private TaxReliefDto mapTaxReliefEnumToDto(TaxReliefEnum reliefEnum) {
        TaxReliefDto taxReliefDto = new TaxReliefDto();
        taxReliefDto.setDescription(reliefEnum.getDescription());
        taxReliefDto.setAmount(reliefEnum.getAmount());
        return taxReliefDto;
    }

}
