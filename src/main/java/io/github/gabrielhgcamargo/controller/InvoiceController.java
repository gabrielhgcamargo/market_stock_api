package io.github.gabrielhgcamargo.controller;

import io.github.gabrielhgcamargo.dto.InfoInvoiceDTO;
import io.github.gabrielhgcamargo.dto.InfoProductInvoiceDTO;
import io.github.gabrielhgcamargo.dto.InvoiceDTO;
import io.github.gabrielhgcamargo.model.Invoice;
import io.github.gabrielhgcamargo.model.ProductInvoice;
import io.github.gabrielhgcamargo.repository.InvoiceRepository;
import io.github.gabrielhgcamargo.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    private InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    // SAVE-CREATE A INVOICE
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody InvoiceDTO dto){
        Invoice invoice = service.save(dto);
        return invoice.getInvoiceId();
    }

    // GET INVOICE DETAILS
    @GetMapping("{id}")
    public InfoInvoiceDTO getById(@PathVariable Integer id){
        return service.getCompleteInvoice(id)
                .map(p -> convert(p))
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invoice not found."));
    }

    private InfoInvoiceDTO convert(Invoice invoice){
       return InfoInvoiceDTO
                .builder()
                .idInvoice(invoice.getInvoiceId())
                .marketName(invoice.getMarket().getName())
                .marketCNPJ(invoice.getMarket().getCnpj())
                .dateIssue(invoice.getDateIssue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .deliveryForecast(invoice.getDeliveryForecast().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .total(invoice.getTotalPrice())
                .status(invoice.getStatus().name())
                .items(converts(invoice.getProductInvoices()))
                .build();
    }

    private List<InfoProductInvoiceDTO> converts(List<ProductInvoice> itens){
           if(CollectionUtils.isEmpty(itens)){
               return Collections.emptyList();
           }
           return itens
                           .stream()
                           .map(item -> InfoProductInvoiceDTO
                           .builder()
                           .id(item.getId())
                           .upc(item.getBody().getUpc())
                           .name(item.getBody().getTitle())
                           .unitPrice(item.getBody().getPrice())
                           .quantity(item.getQuantity())
                           .build()

                           ).collect(Collectors.toList());
    }

}
