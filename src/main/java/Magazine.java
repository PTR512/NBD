import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@Access(AccessType.FIELD)
@DiscriminatorValue("magazine")
public class Magazine extends Literature{
    private String issue;

    public Magazine(int maxBorrowingLength, String name, String issue) {
        super(maxBorrowingLength, name);
        this.issue = issue;
    }

    public Magazine() {

    }

    @Override
    String getLiteratureInfo() {
        return "id: "+ getLiteratureId() +" maxBorrowingLength: "+ getMaxBorrowingLength()+" name: "+getName()+" issue: "+getIssue();
    }

    public String getIssue() {
        return issue;
    }
}
