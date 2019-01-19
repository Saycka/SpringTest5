package ru.manyatkin.SpringTest5.servise;

import ru.manyatkin.SpringTest5.model.Specifications;

import java.util.List;

public interface SpecificationsService {
    public List<Specifications> getSpecificationsByItemId(Integer id);
}
