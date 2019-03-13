package br.com.claudioescobar.person;

import br.com.claudioescobar.person.client.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonData implements Serializable {

    private Long id;
    private String name;
    private AddressDTO addressDTO;

}
