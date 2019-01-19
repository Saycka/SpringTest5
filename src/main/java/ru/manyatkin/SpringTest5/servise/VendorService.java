package ru.manyatkin.SpringTest5.servise;

import ru.manyatkin.SpringTest5.model.Vendor;

import java.util.List;

public interface VendorService {

    List<Vendor> getAllVendors();
    Vendor getVendorById(Integer id);
    void save(Vendor vendor);
}
