package ru.job4j.microservices.service;

import org.springframework.stereotype.Service;
import ru.job4j.microservices.model.Passport;
import ru.job4j.microservices.repository.PassportRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PassportService {
    private final PassportRepository repository;

    public PassportService(PassportRepository repository) {
        this.repository = repository;
    }

    public Passport save(Passport passport) {
        return repository.save(passport);
    }

    public boolean update(Passport passport, int id) {
        Passport pass = repository.findById(id).get();
        if (pass != null) {
            pass.setSerial(passport.getSerial());
            pass.setNumber(passport.getNumber());
            pass.setCreated(passport.getCreated());
            repository.save(pass);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        return repository.deleteById(id);
    }

    public Passport findBySerial(int serial) {
        return repository.findBySerial(serial);
    }

    public List<Passport> findAll() {
        return (List<Passport>) repository.findAll();
    }

    public List<Passport> unavaliabe() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return repository.findPassportByCreatedBefore(timestamp);
    }

    public List<Passport> findReplaceable() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long time = 1000 * 60 * 60 * 24 * 90 + timestamp.getTime();
        return repository.findReplaceable(new Timestamp(time), new Timestamp(System.currentTimeMillis()));
    }
}
