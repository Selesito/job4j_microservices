package ru.job4j.microservices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.microservices.model.Passport;
import ru.job4j.microservices.service.PassportService;

import java.util.List;

@RestController
@RequestMapping("/passport")
public class PassportController {
    private final PassportService service;

    public PassportController(PassportService service) {
        this.service = service;
    }

    @PostMapping
    public Passport save(@RequestBody Passport passport) {
        return service.save(passport);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestParam int id, @RequestBody Passport passport) {
        boolean status = service.update(passport, id);
        return ResponseEntity
                .status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int id) {
        boolean status = service.delete(id);
        return ResponseEntity
                .status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .build();
    }

    @GetMapping("/getBySerial")
    public Passport getBySerial(@RequestParam int serial) {
        return service.findBySerial(serial);
    }

    @GetMapping("/getAll")
    public List<Passport> getAll() {
        return service.findAll();
    }

    @GetMapping("/unavailable")
    public List<Passport> unavailable() {
        return service.unavaliabe();
    }

    @GetMapping("/findReplaceable")
    public List<Passport> findReplaceable() {
        return service.findReplaceable();
    }
}
