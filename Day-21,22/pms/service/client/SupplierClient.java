package com.coforge.pms.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coforge.pms.dto.SupplierDTO;

@FeignClient(name = "SB-SMS-SERVICE")
public interface SupplierClient {

    @GetMapping("/api/v1/sms/suppliers/{supid}")
    SupplierDTO getSupplierById(@PathVariable("supid") long supid);

}

