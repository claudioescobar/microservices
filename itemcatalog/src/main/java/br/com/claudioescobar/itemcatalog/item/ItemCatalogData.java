package br.com.claudioescobar.itemcatalog.item;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemCatalogData {

    private Long id;

    private String name;

    private String creatorName;

}
