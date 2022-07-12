package com.narola.testspringboot.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categorytbl")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catId")
    private int categoryID;

    @Column(name = "catName")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Medicine> medicine;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Medicine> getMedicine() {
        return medicine;
    }

    public void setMedicine(List<Medicine> medicine) {
        this.medicine = medicine;
    }
}