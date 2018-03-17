package org.thecuriousdev.demo.skeleton.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thecuriousdev.demo.skeleton.db.PersonRepository;
import org.thecuriousdev.demo.skeleton.db.domain.Person;

import java.util.Optional;

@Api(value="person", description = "Operations for persons in the system")
@RequestMapping("/api")
@RestController
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @ApiOperation(value= "Retrieves a person from the system if he or she exists", response = Person.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved person"),
        @ApiResponse(code = 401, message = "You are not authorized to view the person resource"),
        @ApiResponse(code = 403, message = "Accessing the person resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/person/{name}")
    public ResponseEntity<Person> getPerson(@PathVariable String name) {
        Optional<Person> person = personRepository.findById(name);

        if (person.isPresent()) {
            return ResponseEntity.ok(person.get());
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/person")
    public ResponseEntity<HttpStatus> savePerson(@RequestBody Person person) {
        personRepository.save(person);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/person/{name}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable String name) {
        personRepository.delete(name);
        return ResponseEntity.noContent().build();
    }
}
