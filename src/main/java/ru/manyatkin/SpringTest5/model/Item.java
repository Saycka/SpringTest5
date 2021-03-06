package ru.manyatkin.SpringTest5.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "items2")
public class Item {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "vendor_code", unique = true)
    @NotNull
    private String vendorCode;

    private String name;

    public Item() {
    }

    public Item(String vendorCode, String name) {
        this.vendorCode = vendorCode;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public String getName() {
        return name;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", vendorCode='" + vendorCode + '\'' +
                ", name='" + name + '\'' +
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
