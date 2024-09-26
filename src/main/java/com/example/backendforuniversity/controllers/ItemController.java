package com.example.backendforuniversity.controllers;

import com.example.backendforuniversity.models.Item;
import com.example.backendforuniversity.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Tag(name = "Item Management", description = "APIs for managing items")
@Controller
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Operation(summary = "Get all items", description = "Retrieve a list of all items")
    @GetMapping("/")
    public String items(Model model) {
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);
        return "item-list";
    }

    @Operation(summary = "Show item creation form", description = "Display the form for creating a new item")
    @GetMapping("/item-create")
    public String createItemForm(Item item) {
        return "item-create";
    }

    @Operation(summary = "Create a new item", description = "Save a new item to the database")
    @PostMapping("/item-create")
    public String createItem(Item item) {
        itemService.saveItem(item);
        return "redirect:/";
    }

    @Operation(summary = "Delete an item", description = "Remove an item from the database by ID")
    @GetMapping("item-delete/{id}")
    public String deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItem(id);
        return "redirect:/";
    }

    @Operation(summary = "Show item update form", description = "Display the form for updating an existing item")
    @GetMapping("item-update/{id}")
    public String updateItemForm(@PathVariable("id") Long id, Model model) {
        Item item = itemService.findById(id);
        model.addAttribute("item", item);
        return "item-update";
    }

    @Operation(summary = "Update an existing item", description = "Save updates to an existing item in the database")
    @PostMapping("item-update")
    public String updateItem(Item item) {
        itemService.saveItem(item);
        return "redirect:/";
    }
}
