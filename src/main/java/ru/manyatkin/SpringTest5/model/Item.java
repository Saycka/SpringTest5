package ru.manyatkin.SpringTest5.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "vendor_code", unique = true, nullable = false)
    private String vendorCode;
    private String name;
    private double cost;


    public Item() {
    }

    public Item(String vendorCode, String name, double cost) {
        this.vendorCode = vendorCode;
        this.name = name;
        this.cost = cost;
    }

    public Integer getItemId() {
        return itemId;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(vendorCode, item.vendorCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendorCode);
    }
}
