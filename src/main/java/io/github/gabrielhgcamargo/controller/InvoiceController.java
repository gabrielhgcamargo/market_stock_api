package io.github.gabrielhgcamargo.controller;

import io.github.gabrielhgcamargo.dto.InvoiceDTO;
import io.github.gabrielhgcamargo.model.Invoice;
import io.github.gabrielhgcamargo.repository.InvoiceRepository;
import io.github.gabrielhgcamargo.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    private InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody InvoiceDTO dto){
        Invoice invoice = service.save(dto);
        return invoice.getInvoiceId();
    }

}
