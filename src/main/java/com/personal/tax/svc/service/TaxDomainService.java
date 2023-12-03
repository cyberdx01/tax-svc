package com.personal.tax.svc.service;

import com.personal.tax.model.dto.TaxResponseDto;
import com.personal.tax.model.enums.TaxSlabEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaxDomainService {

    public TaxResponseDto calculateTaxAmount(Double annualIncome, TaxResponseDto responseDto) {
        Double remainder = annualIncome;
        Double totalTax = 0.0;
        responseDto.setTaxSlab(TaxSlabEnum.CATEGORY_A);
        for (TaxSlabEnum slab : TaxSlabEnum.values()) {
            if (remainder > 0) {
                Double taxable = remainder > slab.getRange() ? slab.getRange() : remainder;
                totalTax += taxable * slab.getRate();
                remainder = Math.max(0, remainder - slab.getRange());
                responseDto.setTaxSlab(slab);
            } else {
                break;
            }
        }

        responseDto.setTaxAmount(totalTax);
        return responseDto;
    }
}
