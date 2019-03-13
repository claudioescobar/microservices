package br.com.claudioescobar.person.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name="CEPClient")
public interface CEPClient {

    @GetMapping("{cep}/json")
    AddressDTO findAddress(@PathVariable("cep")String cep);

}
