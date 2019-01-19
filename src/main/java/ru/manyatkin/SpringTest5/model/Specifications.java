package ru.manyatkin.SpringTest5.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "specifications",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"item_id", "characteristic_id"})})
public class Specifications {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "item_id")
    @NotNull
    private Item item;

    @ManyToOne
    @JoinColumn(name = "characteristic_id")
    @NotNull
    private Characteristic characteristic;

    private Integer value;

    public Specifications() {
    }

    public Specifications(Item item, Characteristic characteristic, Integer value) {
        this.item = item;
        this.characteristic = characteristic;
        this.value = value;
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

    public Characteristic getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Specifications{" +
                "id=" + id +
                ", item=" + item +
                ", characteristic=" + characteristic +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specifications that = (Specifications) o;
        return item.equals(that.item) &&
                characteristic.equals(that.characteristic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, characteristic);
    }
}
