package br.com.claudioescobar.person;

import br.com.claudioescobar.person.client.AddressDTO;
import br.com.claudioescobar.person.client.CEPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CEPClient cepClient;

    public List<PersonData> findAll() {
        return personRepository.findAll().stream()
                .map(person -> buildPersonData(person, cepClient.findAddress(person.getCep())))
                .collect(Collectors.toList());
    }

    public PersonData findById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        PersonData personData = null;
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            personData =  buildPersonData(person, cepClient.findAddress(person.getCep()));
        }

        return personData;
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void update(Person person) {
        personRepository.save(person);
    }

    public void delete(Long personId) {
        personRepository.deleteById(personId);
    }

    private PersonData buildPersonData(Person person, AddressDTO address) {
        return PersonData.builder()
                .id(person.getId())
                .name(person.getName())
                .addressDTO(address)
                .build();
    }

}
