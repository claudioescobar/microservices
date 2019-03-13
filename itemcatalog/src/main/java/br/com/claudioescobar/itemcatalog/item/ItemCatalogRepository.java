package br.com.claudioescobar.itemcatalog.item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCatalogRepository extends JpaRepository<ItemCatalog,Long> {
}
