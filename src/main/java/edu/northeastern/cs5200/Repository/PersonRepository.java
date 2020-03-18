package edu.northeastern.cs5200.Repository;


import edu.northeastern.cs5200.models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface PersonRepository extends CrudRepository<Person, Integer> {
    @Query("select person from Person person")
    public List<Person> findAllUsers();
}
