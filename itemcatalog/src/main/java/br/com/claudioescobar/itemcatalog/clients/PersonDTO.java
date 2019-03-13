package br.com.claudioescobar.itemcatalog.clients;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class PersonDTO implements Serializable {
    private Long id;
    private String name;
}
