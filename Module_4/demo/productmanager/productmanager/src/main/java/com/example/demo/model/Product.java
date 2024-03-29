package com.example.demo.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 5,max =50,message = "{name.validate}")
    private String name;
    @Min(value = 500000,message = "{price.validate}")
    private  Double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datePublish;
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_productType")
    ProductType productType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(Date datePublish) {
        this.datePublish = datePublish;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
