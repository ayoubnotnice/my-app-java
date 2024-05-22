package mossaab.ayoub.restservice.services;

import jakarta.transaction.Transactional;
import mossaab.ayoub.restservice.entities.Book;
import mossaab.ayoub.restservice.models.Author;
import mossaab.ayoub.restservice.records.BookRecord;
import mossaab.ayoub.restservice.repositories.AuthorRepository;
import mossaab.ayoub.restservice.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }
    public List<BookRecord> findAll() {
        List<BookRecord> records = new ArrayList<>();
        List<Book> books = bookRepository.findAll();

        books.forEach(book -> {
            System.out.println("the book ->"+book.getAuthorId());
            Author author = authorRepository.getAuthorById(book.getAuthorId()).orElse(null);
            System.out.println("author -> "+author);
            records.add(new BookRecord(
                    book.getIsbn(),
                    book.getTitle(),
                    book.getLastModifiedDate(),
                    book.getPublishedDate(),
                    author)
            );
        });
        return records;
    }
    public Book findById(long id) {
        return bookRepository.findById(id).orElse(null);
    }
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    public Book update(Book book, Long id ) {
        book.setId(id);
        return bookRepository.save(book);
    }
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title).orElse(null);
    }
}
