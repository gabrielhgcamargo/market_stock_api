package io.github.gabrielhgcamargo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Market {

    @Id
    @Column
    private String cnpj;

    @Column
    private String name;

    @Column
    private String street;

    @Column
    private Integer number;

    @Column
    private String district;

    @Column
    private String city;

    @Column
    private String country;

    @OneToMany(mappedBy = "market", fetch = FetchType.LAZY)
    private Set<Invoice> invoices;


}
