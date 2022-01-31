package io.github.gabrielhgcamargo.controller;

import io.github.gabrielhgcamargo.model.Market;
import io.github.gabrielhgcamargo.repository.MarketRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/market")
public class MarketController {

    private MarketRepository marketRepository;

    public MarketController(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    // GET MARKET BY ID
    @GetMapping("{cnpj}")
    public Market getMarketById( @PathVariable String cnpj ){
        return marketRepository
                .findById(cnpj)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Market not found with this CNPJ."));
    }

    // SAVE MARKET
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Market save(@RequestBody Market market){
        return marketRepository.save(market);
    }

    // DELETE MARKET
    @DeleteMapping("{cnpj}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String cnpj){
        marketRepository
                .findById(cnpj)
                .map(market -> {
                    marketRepository.delete(market);
                    return market;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Market not found with this CNPJ."));

    }

    // UPDATE MARKET
    @PutMapping("{cnpj}")
    public void update(@PathVariable String cnpj,
                       @RequestBody Market market){
        marketRepository
                .findById(cnpj)
                .map(market1 -> {
                    market.setCnpj(market1.getCnpj());
                    marketRepository.save(market);
                    return market1;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Market not found with this CNPJ."));
    }

    @GetMapping
    public List<Market> find(Market filter){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filter,matcher);
        return marketRepository.findAll(example);
    }
}
