package com.narola.testspringboot.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="categorytbl")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catId")
    private int catID;

    @Column(name = "catName")
    private String catName;

    @Column(nullable = false)
    private LocalDateTime createdOn=LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime updatedOn=LocalDateTime.now();
    @Column(nullable = false)
    private boolean popular=false;
    @OneToMany(mappedBy = "category")
    private List<Medicine> medicine;

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public boolean isPopular() {
        return popular;
    }

    public void setPopular(boolean popular) {
        this.popular = popular;
    }

    public List<Medicine> getMedicine() {
        return medicine;
    }

    public void setMedicine(List<Medicine> medicine) {
        this.medicine = medicine;
    }

    @Override
    public String toString() {
        return "Category{" +
                "catID=" + catID +
                ", catName='" + catName + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", popular=" + popular +
                ", medicine=" + medicine +
                '}';
    }
}