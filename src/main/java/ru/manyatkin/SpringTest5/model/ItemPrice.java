package ru.manyatkin.SpringTest5.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name="items_price",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"item_id", "vendor_id"})})
public class ItemPrice {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="item_id")
    @NotNull
    private Item item;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="vendor_id")
    @NotNull
    private Vendor vendor;

    private Double cost;

    public ItemPrice() {
    }

    public ItemPrice(Item item, Vendor vendor, Double cost) {
        this.item = item;
        this.vendor = vendor;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ItemPrice{" +
                "id=" + id +
                ", item=" + item +
                ", vendor=" + vendor +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPrice itemPrice = (ItemPrice) o;
        return Objects.equals(item, itemPrice.item) &&
                Objects.equals(vendor, itemPrice.vendor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, vendor);
    }
}
