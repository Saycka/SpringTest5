package ru.manyatkin.SpringTest5.servise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.manyatkin.SpringTest5.model.Specifications;
import ru.manyatkin.SpringTest5.repository.SpecificationsRepository;
import ru.manyatkin.SpringTest5.servise.SpecificationsService;

import java.util.List;

@Service
public class SpecificationsServiceImpl implements SpecificationsService {

    private SpecificationsRepository specificationsRepository;

    @Autowired
    public void setSpecificationsRepository(SpecificationsRepository specificationsRepository) {
        this.specificationsRepository = specificationsRepository;
    }

    @Override
    public List<Specifications> getSpecificationsByItemId(Integer id) {
        return specificationsRepository.findAllByItemId(id);
    }
}
