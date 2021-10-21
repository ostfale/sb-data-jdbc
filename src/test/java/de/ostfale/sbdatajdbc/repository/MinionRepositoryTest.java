package de.ostfale.sbdatajdbc.repository;

import de.ostfale.sbdatajdbc.model.Minion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Minion Repository services")
@SpringBootTest
class MinionRepositoryTest {

    @Autowired
    private MinionRepository minionRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertNotNull(minionRepository);
    }

    @Test
    @DisplayName("Test creation of a Minion object")
    void createMinionTest() {
        // given
        Minion minion = new Minion();
        minion.setName("Bob");
        // when
        assertNull(minion.getId());
        Minion createdMinion = minionRepository.save(minion);
        // then
        assertNotNull(createdMinion);
        assertNotNull(createdMinion.getId());
        assertEquals("Bob", createdMinion.getName());
    }

/*    @Test
    void TestMinionDefaultSavings() {
        Minion before = new Minion();

        assertNull(before.getId());
        Minion after = minionRepository.save(before);
        assertNotNull(after.getId());
    }*/
}