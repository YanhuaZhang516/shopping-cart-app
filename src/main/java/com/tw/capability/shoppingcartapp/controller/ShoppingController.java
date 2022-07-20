package com.tw.capability.shoppingcartapp.controller;

import com.tw.capability.shoppingcartapp.Exceptions.ItemNotFoundException;
import com.tw.capability.shoppingcartapp.model.ShoppingItem;
import com.tw.capability.shoppingcartapp.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingController {
    @Autowired
    private final ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @GetMapping("/items")
    @CrossOrigin
    public List<ShoppingItem> getItems() {
        return shoppingService.findAllItems();
    }

    @GetMapping("/items/{id}")
    @CrossOrigin
    public ShoppingItem getItem(@PathVariable Long id) throws ItemNotFoundException {
        return shoppingService.findItemById(id);
    }

    @PostMapping("/items")
    @CrossOrigin
    public String createItem(@RequestBody ShoppingItem item){
        return shoppingService.createItem(item);
    }

}
