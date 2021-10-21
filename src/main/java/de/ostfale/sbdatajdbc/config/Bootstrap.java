package de.ostfale.sbdatajdbc.config;

import de.ostfale.sbdatajdbc.model.Minion;
import de.ostfale.sbdatajdbc.repository.MinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


@Component
@Profile("!test")
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private MinionRepository minionRepository;

    @Override
    public void run(String... args) throws Exception {
        saveMinion();
    }

    private void saveMinion() throws ParseException {
        System.out.println("Bootstrap: Save Minion (Default)");
        Minion before = new Minion();
        before.setName("Bob");
        before.setDateOfBirth(getBirthDate());
        System.out.println("ID: before save: " + before.getId() + " and Date of Birth as String: " + before.getDateOfBirthString());
        Minion after = minionRepository.save(before);
        System.out.println("ID: after save: " + after.getId());
        after.setName("Bobsley");
        minionRepository.save(after);
    }

    private Date getBirthDate() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String dateInString = "3-Aug-2010";
        return formatter.parse(dateInString);
    }
}
