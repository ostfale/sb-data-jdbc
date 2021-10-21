package de.ostfale.sbdatajdbc.repository;

import de.ostfale.sbdatajdbc.model.Minion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Minion Repository services")
@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(value = OrderAnnotation.class) // to run tests in order
class MinionRepositoryTest {

    @Autowired
    private MinionRepository minionRepository;

    @Test
    @Order(1)
    void injectedComponentsAreNotNull() {
        assertNotNull(minionRepository);
    }

    @Test
    @DisplayName("Test creation of a Minion object")
    @Order(2)
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

    @Test
    @DisplayName("Test update of a Minion object")
    @Order(3)
    void updateMinionTest() {
        // when
        final Iterable<Minion> minions = minionRepository.findAll();
        final List<Minion> minionList = toList(minions);
        final Minion firstMinion = minionList.get(0);
        firstMinion.setName("Igor");
        final Minion updatedMinion = minionRepository.save(firstMinion);
        // then
        assertEquals(1, minionList.size());
        assertEquals("Igor", updatedMinion.getName());
    }

    @Test
    @DisplayName("Test deleting a Minion object")
    @Order(4)
    void deleteMinionObject() {
        // given
        final Iterable<Minion> minions = minionRepository.findAll();
        final List<Minion> minionList = toList(minions);
        final Minion firstMinion = minionList.get(0);
        // when
        minionRepository.delete(firstMinion);
        // then
        final Iterable<Minion> currentMinions = minionRepository.findAll();
        assertEquals(0, currentMinions.spliterator().estimateSize());
    }

    private List<Minion> toList(Iterable<Minion> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}