package com.tw.capability.shoppingcartapp.service;

import com.tw.capability.shoppingcartapp.Exceptions.ItemNotFoundException;
import com.tw.capability.shoppingcartapp.model.ShoppingItem;
import com.tw.capability.shoppingcartapp.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShoppingService {
    final ItemRepository itemRepository;

    public ShoppingService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ShoppingItem> findAllItems() {return itemRepository.findAll();}

    public ShoppingItem findItemById(Long id) throws ItemNotFoundException {
        return itemRepository.findById(id)
            .orElseThrow(() -> new ItemNotFoundException("Item not Found!"));}

    public String createItem(ShoppingItem item){
        itemRepository.save(item);
        return  item.getId();
    }
}
