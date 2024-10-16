import java.util.List;

public interface IBorrowingRepository {
    void create(Borrowing borrowing);
    List<Borrowing> getAll();
    List<Borrowing> getAllBorrowingsByClientId(long id);

}
