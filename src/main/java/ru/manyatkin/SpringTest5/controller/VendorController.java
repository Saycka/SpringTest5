package ru.manyatkin.SpringTest5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.manyatkin.SpringTest5.model.ItemPrice;
import ru.manyatkin.SpringTest5.model.Vendor;
import ru.manyatkin.SpringTest5.servise.ItemPriceService;
import ru.manyatkin.SpringTest5.servise.VendorService;

import java.util.List;

@Controller
public class VendorController {

    private VendorService vendorService;
    private ItemPriceService itemPriceService;

    @Autowired
    public void setVendorService(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @Autowired
    public void setItemPriceService(ItemPriceService itemPriceService) {
        this.itemPriceService = itemPriceService;
    }

    @GetMapping("/vendors")
    public String vendors(Model model) {
        model.addAttribute("page_title", "Vendors");
        List<Vendor> vendors = vendorService.getAllVendors();
        model.addAttribute("vendors", vendors);
        return "pages/vendor/vendors";
    }

    @GetMapping("/vendors/{id}")
    public String vendor(@PathVariable Integer id, Model model) {
        Vendor vendor = vendorService.getVendorById(id);
        model.addAttribute("page_title", vendor.getName());
        model.addAttribute("vendor", vendor);

        List<ItemPrice> itemPrices = itemPriceService.getItemPricesByVendorId(id);
        model.addAttribute("itemPrices", itemPrices);
        return "pages/vendor/vendor";
    }

    @GetMapping("vendors/new")
    public String newVendor(Model model) {
        model.addAttribute("page_title", "New vendor");
        Vendor vendor = new Vendor();
        model.addAttribute("vendor", vendor);
        return "pages/vendor/new";
    }

    @PostMapping("vendors/new")
    public String newVendorSave(@ModelAttribute Vendor vendor) {
        vendorService.save(vendor);
        return "redirect:/vendors";
    }
}
