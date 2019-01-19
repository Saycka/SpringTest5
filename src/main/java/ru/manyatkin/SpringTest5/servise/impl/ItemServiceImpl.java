package ru.manyatkin.SpringTest5.servise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.manyatkin.SpringTest5.model.Item;
import ru.manyatkin.SpringTest5.repository.ItemRepository;
import ru.manyatkin.SpringTest5.servise.ItemService;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Integer id) {
        return itemRepository.findItemById(id);
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void delete(Integer id) {
        itemRepository.deleteById(id);
    }

}
