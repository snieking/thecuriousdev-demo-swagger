package org.thecuriousdev.demo.skeleton.db;

import org.thecuriousdev.demo.skeleton.db.domain.Person;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimulatedDatabase {

    private static final Map<String, Person> PERSON_CACHE = new ConcurrentHashMap<>();

    public static void savePerson(Person person) {
        PERSON_CACHE.put(person.getName(), person);
    }

    public static Person getPerson(String name) {
        return PERSON_CACHE.get(name);
    }

    public static Person deletePerson(String name) {
        return PERSON_CACHE.remove(name);
    }

}
