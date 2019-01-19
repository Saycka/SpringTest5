package ru.manyatkin.SpringTest5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.manyatkin.SpringTest5.model.Vendor;

import java.util.List;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

    public List<Vendor> findAll();
    public Vendor findVendorById(Integer vendorId);
}
