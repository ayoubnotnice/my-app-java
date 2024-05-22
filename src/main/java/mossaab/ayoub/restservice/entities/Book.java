package mossaab.ayoub.restservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Calendar;

@Entity
 @NoArgsConstructor
@Getter @Setter
public class Book implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    private long authorId;
    private long publishedDate;
    private long createdDate;
    private long lastModifiedDate;

    public Book(String isbn, long authorId, String title, long lastModifiedDate, long publishedDate) {
        this.lastModifiedDate = lastModifiedDate;
        this.publishedDate = publishedDate;
        this.isbn = isbn;
        this.authorId = authorId;
        this.title = title;
        this.createdDate = Calendar.getInstance().getTimeInMillis();
    }
}
