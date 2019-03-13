package br.com.claudioescobar.itemcatalog.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${person.url}", path = "v1/people/", name="PersonClient")
public interface PersonClient {

    @GetMapping("{id}")
    PersonDTO getById(@PathVariable("id")Long id);

}
