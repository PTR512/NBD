package objects;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


import java.util.UUID;

@Entity(defaultKeyspace = "rent_a_literature")
@CqlName("literatures")
public class Book extends Literature {
    @CqlName("genre")
    private String genre;

    @CqlName("author")
    private String author;

    @CqlName("tier")
    private int tier;

    public Book() {
    }

    public Book(UUID literatureId, String name, int weight, int isBorrowed, String discriminator, String genre, String author, int tier) {
        super(literatureId, name, weight, isBorrowed, discriminator);
        this.genre = genre;
        this.author = author;
        this.tier = tier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(tier, book.tier).append(genre, book.genre).append(author, book.author).isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString())
                .append("genre", genre)
                .append("author", author)
                .append("tier", tier)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(genre).append(author).append(tier).toHashCode();
    }

    @Override
    String getLiteratureInfo() {
        return "id: " + getLiteratureId() + " name: " + getName() + " genre: " + getGenre() + " author: " + getAuthor();
    }

    @Override
    public int getTotalWeight() {
        return getWeight() * getTier();
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

}
