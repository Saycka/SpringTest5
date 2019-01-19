package ru.manyatkin.SpringTest5.servise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.manyatkin.SpringTest5.model.ItemPrice;
import ru.manyatkin.SpringTest5.repository.ItemPriceRepository;
import ru.manyatkin.SpringTest5.servise.ItemPriceService;

import java.util.List;

@Service
public class ItemPriceServiceImpl implements ItemPriceService {

    private ItemPriceRepository itemPriceRepository;

    @Autowired
    public void setItemPriceRepository(ItemPriceRepository itemPriceRepository) {
        this.itemPriceRepository = itemPriceRepository;
    }

    @Override
    public List<ItemPrice> getItemPricesByItemId(Integer id) {
        return itemPriceRepository.findAllByItemId(id);
    }

    @Override
    public List<ItemPrice> getItemPricesByVendorId(Integer id) {
        return itemPriceRepository.findAllByVendorId(id);
    }
}
