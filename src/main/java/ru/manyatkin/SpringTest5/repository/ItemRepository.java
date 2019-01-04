package ru.manyatkin.SpringTest5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.manyatkin.SpringTest5.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
