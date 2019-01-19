package ru.manyatkin.SpringTest5.servise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.manyatkin.SpringTest5.model.Vendor;
import ru.manyatkin.SpringTest5.repository.VendorRepository;
import ru.manyatkin.SpringTest5.servise.VendorService;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    private VendorRepository vendorRepository;

    @Autowired
    public void setVendorRepository(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    @Override
    public Vendor getVendorById(Integer vendorId) {
        return vendorRepository.findVendorById(vendorId);
    }

    @Override
    public void save(Vendor vendor) {
        vendorRepository.save(vendor);
    }
}
