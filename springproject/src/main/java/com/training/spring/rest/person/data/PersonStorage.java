package com.training.spring.rest.person.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.training.spring.rest.Person;

@Service
public class PersonStorage {

    private final Map<String, Person> personMap = new ConcurrentHashMap<>();

    public void add(final Person personParam) {
        this.personMap.put(personParam.getName() + personParam.getSurname(),
                           personParam);
    }

    public Person get(final String stringParam) {
        return this.personMap.get(stringParam);
    }

    public List<Person> getAll() {
        return new ArrayList<>(this.personMap.values());
    }

    public List<Person> getByName(final String nameParam) {
        Collection<Person> valuesLoc = this.personMap.values();
        List<Person> retVal = new ArrayList<>();
        for (Person personLoc : valuesLoc) {
            if (personLoc.getName()
                         .equalsIgnoreCase(nameParam)) {
                retVal.add(personLoc);
            }
        }
        return retVal;
    }


}
