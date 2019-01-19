package ru.manyatkin.SpringTest5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.manyatkin.SpringTest5.model.Characteristic;

public interface CharacteristicRepository extends JpaRepository<Characteristic, Integer> {
}
