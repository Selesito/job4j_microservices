package ru.job4j.microservices.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.microservices.model.Passport;

import java.sql.Timestamp;
import java.util.List;

public interface PassportRepository extends CrudRepository<Passport, Integer> {
    boolean deleteById(int id);

    Passport findBySerial(int serial);

    List<Passport> findPassportByCreatedBefore(Timestamp created);

    @Query("select s from #{#entityName} s where s.created < ?1 and s.created > ?2")
    List<Passport> findReplaceable(Timestamp created, Timestamp now);
}
