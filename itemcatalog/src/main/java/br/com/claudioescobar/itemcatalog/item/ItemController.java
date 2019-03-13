package br.com.claudioescobar.itemcatalog.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/items")
public class ItemController {

    @Autowired
    private ItemCatalogService itemCatalogService;

    @GetMapping
    public List<ItemCatalogData> getAll() {
        return itemCatalogService.findAll();
    }

    @GetMapping("/{id}")
    public ItemCatalogData get(@PathVariable("id") Long id) {
        return itemCatalogService.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody ItemCatalog itemCatalog) {
        itemCatalogService.update(itemCatalog);
    }

    @PostMapping
    public void save(@RequestBody ItemCatalog itemCatalog) {
        itemCatalogService.save(itemCatalog);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        itemCatalogService.delete(id);
    }

}
