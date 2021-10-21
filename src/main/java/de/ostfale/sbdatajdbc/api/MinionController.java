package de.ostfale.sbdatajdbc.api;

import de.ostfale.sbdatajdbc.model.Minion;
import de.ostfale.sbdatajdbc.repository.MinionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/minion")
public class MinionController {

    private final MinionRepository repository;

    public MinionController(MinionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Minion> getAllMinions() {
        return (List<Minion>) repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Minion> getById(@PathVariable(value = "id") final Long minionId) {
        Minion minion = repository.findById(minionId)
                .orElseThrow(
                        () -> new NoSuchElementException("Minion not available for ID: " + minionId)
                );
        return ResponseEntity.ok(minion);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody Minion minion) {
        System.out.println(minion); // Just to inspect values for demo
        repository.save(minion);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMinion(@PathVariable("id") final long id, @RequestBody final Minion minion) {
        Minion foundMinion = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Minion not available for Id :" + id));
        repository.save(foundMinion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMinion(@PathVariable final long id) {
        Minion foundMinion = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Minion not available for Id :" + id));
        repository.delete(foundMinion);
    }
}