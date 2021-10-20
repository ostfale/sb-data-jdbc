package de.ostfale.sbdatajdbc.repository;

import de.ostfale.sbdatajdbc.model.Minion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJdbcTest
class MinionRepositoryTest {

    @Autowired
    private MinionRepository minionRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertNotNull(minionRepository);
    }

    @Test
    void TestMinionDefaultSavings() {
        Minion before = new Minion();

        assertNull(before.getId());
        Minion after = minionRepository.save(before);
        assertNotNull(after.getId());
    }
}