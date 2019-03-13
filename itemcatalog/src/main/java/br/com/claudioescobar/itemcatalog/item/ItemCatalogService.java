package br.com.claudioescobar.itemcatalog.item;

import br.com.claudioescobar.itemcatalog.clients.PersonClient;
import br.com.claudioescobar.itemcatalog.clients.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemCatalogService {

    @Autowired
    private PersonClient personClient;

    @Autowired
    private ItemCatalogRepository itemCatalogRepository;

    public ItemCatalogData findById(Long id) {
        Optional<ItemCatalog> itemCatalogOptional = itemCatalogRepository.findById(id);
        ItemCatalogData result = null;
        if (itemCatalogOptional.isPresent()) {
            ItemCatalog itemCatalog = itemCatalogOptional.get();
            result = buildItemCatalogData(itemCatalog, personClient.getById(itemCatalog.getCreatorId()));
        }

        return result;
    }

    private ItemCatalogData buildItemCatalogData(ItemCatalog itemCatalog, PersonDTO personDTO) {
        return ItemCatalogData.builder()
                .id(itemCatalog.getId())
                .name(itemCatalog.getName())
                .creatorName(personDTO.getName()).build();
    }

    public void save(ItemCatalog itemCatalog) {
        itemCatalogRepository.save(itemCatalog);
    }

    public void update(ItemCatalog itemCatalog) {
        itemCatalogRepository.save(itemCatalog);
    }

    public void delete(Long id) {
        itemCatalogRepository.deleteById(id);
    }

    public List<ItemCatalogData> findAll() {
        List<ItemCatalog> items = itemCatalogRepository.findAll();
        return itemCatalogRepository.findAll().stream()
                    .map(itemCatalog -> buildItemCatalogData(itemCatalog, personClient.getById(itemCatalog.getCreatorId())))
                    .collect(Collectors.toList());
    }

}
