package ru.manyatkin.SpringTest5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.manyatkin.SpringTest5.model.ItemPrice;

import java.util.List;

public interface ItemPriceRepository extends JpaRepository<ItemPrice, Integer> {
    List<ItemPrice> findAllByItemId(Integer id);
    List<ItemPrice> findAllByVendorId(Integer id);
}
