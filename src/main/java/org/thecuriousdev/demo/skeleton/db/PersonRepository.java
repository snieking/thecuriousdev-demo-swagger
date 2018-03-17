package org.thecuriousdev.demo.skeleton.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.thecuriousdev.demo.skeleton.db.domain.Person;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PersonRepository {

    private static final Logger LOG = LoggerFactory.getLogger(PersonRepository.class);

    private Map<String, Person> personCache = new ConcurrentHashMap<>();

    public Optional<Person> findById(String name) {
        Optional<Person> person = Optional.ofNullable(SimulatedDatabase.getPerson(name));

        if (person.isPresent()) {
            LOG.info("Found person: {}", person.get());
        } else {
            LOG.warn("No person with name {} was found", name);
        }

        return person;
    }

    public void save(Person person) {
        SimulatedDatabase.savePerson(person);
        LOG.info("Saved user: {}", person);
    }

    public void delete(String name) {
        Person person = SimulatedDatabase.deletePerson(name);
        LOG.info("Deleted person: {}", person);
    }
}
