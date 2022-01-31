package io.github.gabrielhgcamargo.service.impl;

import io.github.gabrielhgcamargo.dto.InvoiceDTO;
import io.github.gabrielhgcamargo.dto.ProductInvoiceDTO;
import io.github.gabrielhgcamargo.enums.InvoiceStatus;
import io.github.gabrielhgcamargo.exception.RuleException;
import io.github.gabrielhgcamargo.model.Invoice;
import io.github.gabrielhgcamargo.model.Market;
import io.github.gabrielhgcamargo.model.Product;
import io.github.gabrielhgcamargo.model.ProductInvoice;
import io.github.gabrielhgcamargo.repository.InvoiceRepository;
import io.github.gabrielhgcamargo.repository.MarketRepository;
import io.github.gabrielhgcamargo.repository.ProductInvoiceRepository;
import io.github.gabrielhgcamargo.repository.ProductRepository;
import io.github.gabrielhgcamargo.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final MarketRepository marketRepository;
    private final ProductRepository productRepository;
    private final ProductInvoiceRepository productInvoiceRepository;

    @Override
    @Transactional
    public Invoice save(InvoiceDTO dto) {
       String cnpjMarket = dto.getMarket();
       Market market = marketRepository
               .findById(cnpjMarket)
               .orElseThrow(()-> new RuleException
                       ("Invalid market cnpj"));



        Invoice invoice = new Invoice();
        invoice.setTotalPrice(dto.getTotal());
        invoice.setDateIssue(LocalDate.now());
        invoice.setDeliveryForecast(LocalDate.now().plusDays(15));
        invoice.setMarket(market);
        invoice.setStatus(InvoiceStatus.ON_THE_WAY);

        List<ProductInvoice> productInvoices = convertItems(invoice, dto.getItems());

        invoiceRepository.save(invoice);
        productInvoiceRepository.saveAll(productInvoices);
        invoice.setProductInvoices(productInvoices);

        return invoice;
    }

    private List<ProductInvoice> convertItems(Invoice invoice, List<ProductInvoiceDTO> items){
        if(items.isEmpty()){
            throw new RuleException("To make a invoice, it is necessary insert one or more Products");
        }
        return items
                .stream()
                .map(dto -> {
                    Integer productId = dto.getProduct();
                    Product product = productRepository
                                    .findById(productId)
                                    .orElseThrow(() -> new RuleException(
                                            "Invalid product ID : " + productId));



                    ProductInvoice productInvoice = new ProductInvoice();
                    productInvoice.setQuantity(dto.getQuantity());
                    productInvoice.setInvoice(invoice);
                    productInvoice.setProduct(product);
                    return  productInvoice;
                }).collect(Collectors.toList());
    }

    @Override
    public Optional<Invoice> getCompleteInvoice(Integer id) {
        return invoiceRepository.findByIdFetchItems(id);
    }
}
