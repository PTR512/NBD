
import mappers.MongoUniqueId;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.BorrowingRepository;
import repositories.IBorrowingRepository;

import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BorrowingRepositoryTest {
    private static final repositories.BorrowingRepository borrowingRepository = new repositories.BorrowingRepository();
    private static final repositories.ClientRepository clientRepository = new repositories.ClientRepository();
    private static final repositories.LiteratureRepository literatureRepository = new repositories.LiteratureRepository();
    private objects.Client c;
    private objects.Client c2;
    private objects.Literature lit1;
    private objects.Literature lit2;
    private objects.Borrowing bor1;
    private objects.Borrowing bor2;

    @BeforeEach
    public void prepareForTests() {
        IBorrowingRepository borrowingRepository = new BorrowingRepository();
        c = new objects.Client(new MongoUniqueId(new ObjectId()), "Jan", "Kowalski", "123", 10);
        lit1 = new objects.Book(new MongoUniqueId(new ObjectId()), "Pan Tadeusz", "Epopeja", "Adam Mickiewicz", 2, 2, 0);
        GregorianCalendar date = GregorianCalendar.from(ZonedDateTime.now());
        bor1 = new objects.Borrowing(new MongoUniqueId(new ObjectId()), null, null, c, lit1);
        lit2 = new objects.Magazine("Swiat Nauki", "2002/11", 8);
        bor2 = new objects.Borrowing(date, null, c, lit2);
    }

    @AfterAll
    public static void close() {
    }

    @Test
    public void borrowingCreateTest() {
        borrowingRepository.create(bor1);

    }

//    @Test
//    public void businessLogicTest() {
//        clientRepository.create(c);
//        literatureRepository.create(lit1);
//        borrowingRepository.create(bor1);
//        literatureRepository.create(lit2);
//        assertThrows(exceptions.WeightExceededException.class, () -> {
//            borrowingRepository.create(bor2);
//        });
//    }

//    @Test
//    public void endBorrowingTest() {
//        clientRepository.create(c);
//        literatureRepository.create(lit1);
//        borrowingRepository.create(bor1);
//        borrowingRepository.endBorrowing(bor1);
//        assertFalse(literatureRepository.getById(lit1.getId()).isBorrowed());
//        assertEquals(clientRepository.getById(c.getId()).getCurrentWeight(), 0);
//        List<objects.Borrowing> list = borrowingRepository.getAllBorrowingsByClientId(c.getId());
//        assertEquals(list.size(), 1);
//    }
//
//    @Test
//    public void borrowingUpdate() {
//        clientRepository.create(c);
//        literatureRepository.create(lit1);
//        borrowingRepository.create(bor1);
//        GregorianCalendar timeAfterCreation = borrowingRepository.getAll().getFirst().getEndDate();
//        bor1.setEndDate(new GregorianCalendar());
//        borrowingRepository.update(bor1);
//        GregorianCalendar newTime = borrowingRepository.getAll().getFirst().getEndDate();
//        assertNotEquals(timeAfterCreation, newTime);
//    }
//
//    @Test
//    public void borrowingDelete() {
//        clientRepository.create(c);
//        c.setMaxWeight(20);
//        clientRepository.update(c);
//        literatureRepository.create(lit1);
//        borrowingRepository.create(bor1);
//        literatureRepository.create(lit2);
//        borrowingRepository.create(bor2);
//        assertEquals(borrowingRepository.getAll().size(), 2);
//        borrowingRepository.delete(bor1.getId());
//        assertEquals(borrowingRepository.getAll().size(), 1);
//    }
}
