package ru.manyatkin.SpringTest5.servise;

import ru.manyatkin.SpringTest5.model.ItemPrice;

import java.util.List;

public interface ItemPriceService {
    public List<ItemPrice> getItemPricesByItemId(Integer id);
    public List<ItemPrice> getItemPricesByVendorId(Integer id);
}
