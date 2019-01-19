package ru.manyatkin.SpringTest5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.manyatkin.SpringTest5.model.Specifications;

import java.util.List;

public interface SpecificationsRepository extends JpaRepository<Specifications, Integer> {

    public List<Specifications> findAllByItemId(Integer itemId);
}
