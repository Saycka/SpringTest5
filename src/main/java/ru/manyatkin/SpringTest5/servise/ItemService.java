package ru.manyatkin.SpringTest5.servise;

import ru.manyatkin.SpringTest5.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();

    Item getItemById(Integer id);

    void save(Item item);

    void delete(Integer id);
}
