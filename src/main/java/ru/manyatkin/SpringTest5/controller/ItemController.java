package ru.manyatkin.SpringTest5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.manyatkin.SpringTest5.model.Item;
import ru.manyatkin.SpringTest5.model.ItemPrice;
import ru.manyatkin.SpringTest5.model.Specifications;
import ru.manyatkin.SpringTest5.servise.ItemPriceService;
import ru.manyatkin.SpringTest5.servise.ItemService;
import ru.manyatkin.SpringTest5.servise.SpecificationsService;

import java.util.List;

@Controller
public class ItemController {

    private ItemService itemService;
    private ItemPriceService itemPriceService;
    private SpecificationsService specificationsService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @Autowired
    public void setItemPriceService(ItemPriceService itemPriceService) {
        this.itemPriceService = itemPriceService;
    }

    @Autowired
    public void setSpecificationsService(SpecificationsService specificationsService) {
        this.specificationsService = specificationsService;
    }

    @GetMapping("/items")
    public String items(Model model) {
        model.addAttribute("page_title", "Items list");
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "pages/item/items";
    }

    @GetMapping("/items/{id}")
    public String item(@PathVariable Integer id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("page_title", item.getName());
        model.addAttribute("item", item);

        List<Specifications> specifications = specificationsService.getSpecificationsByItemId(id);
        model.addAttribute("specifications", specifications);

        List<ItemPrice> itemPrices = itemPriceService.getItemPricesByItemId(id);
        model.addAttribute("itemPrices", itemPrices);
        return "pages/item/item";
    }

    @GetMapping("/items/new")
    public String newItem(Model model) {
        model.addAttribute("page_title", "New item");
        model.addAttribute(new Item());
        return "pages/item/new";
    }

    @PostMapping("/items/new")
    public String newItemSave(@ModelAttribute Item item) {
        itemService.save(item);
        return "redirect:/items";
    }

    @GetMapping("/items/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("page_title", item.getName());
        model.addAttribute("item", item);
        return "pages/item/edit";
    }

    @PostMapping("/items/{id}/edit")
    public String editSave(@PathVariable Integer id, @ModelAttribute Item itemFromModel) {
        Item itemFromDB = itemService.getItemById(id);
        itemFromDB.setVendorCode(itemFromModel.getVendorCode());
        itemFromDB.setName(itemFromModel.getName());
        itemService.save(itemFromDB);
        return "redirect:/items/" + id;
    }

    @GetMapping("/items/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
        model.addAttribute("page_title", "Delete item");
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "pages/item/delete";
    }

    @PostMapping("/items/{id}/delete")
    public String deleteSave(@PathVariable Integer id) {
        itemService.delete(id);
        return "redirect:/items";
    }
}
