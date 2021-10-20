package de.ostfale.sbdatajdbc.config;

import de.ostfale.sbdatajdbc.model.Minion;
import de.ostfale.sbdatajdbc.repository.MinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private MinionRepository minionRepository;

    @Override
    public void run(String... args) throws Exception {
        saveMinion();
    }

    private void saveMinion() {
        System.out.println("Bootstrap: Save Minion (Default)");
        Minion before = new Minion();
        before.setName("Bob");
        System.out.println("ID: before save: " + before.getId());
        Minion after = minionRepository.save(before);
        System.out.println("ID: after save: " + after.getId());
    }
}
