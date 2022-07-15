package com.narola.testspringboot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "medicinetbl")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medId")
    private int id;
    @Column(name="medName",length = 100,nullable = false)
    private String medicineName;
    @Column(name="medPrice",nullable = false)
    private double cost;
    @Column(name="medManufacturer",length = 100,nullable = false)
    private String manufacturer;
    @Column(name="medDescription",length = 200,nullable = false)
    private String description;
    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinColumn(name="catId",referencedColumnName = "catId")
    private Category category;
    @Column(name="medMfgDate",nullable = false)
    private LocalDate mfgDate;
    @Column(name="medExpDate",nullable = false)
    private LocalDate expDate;
    @Column(name="quantity",nullable = false)
    private int quantity;
    @Column(nullable = false)
    private LocalDateTime createdOn=LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime updatedOn=LocalDateTime.now();
    @Column(nullable = false)
    private boolean popular=false;
    @Column(nullable = false)
    private double discount=0;


}
