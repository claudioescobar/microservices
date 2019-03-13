package br.com.claudioescobar.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/people")
public class PersonController {

    @Autowired
    private PersonService personService;


    @GetMapping
    public List<PersonData> getAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public PersonData get(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Person person) {
        person.setId(id);
        personService.save(person);
    }

    @PostMapping
    public void save(@RequestBody Person person) {
        personService.save(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        personService.delete(id);
    }

}
