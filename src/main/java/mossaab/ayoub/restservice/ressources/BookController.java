package mossaab.ayoub.restservice.ressources;

import mossaab.ayoub.restservice.entities.Book;

// import mossaab.ayoub.restservice.messages.Message;
import mossaab.ayoub.restservice.records.BookRecord;
import mossaab.ayoub.restservice.services.BookService;
// import mossaab.ayoub.restservice.services.Producer;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/books")
public class BookController {
    private final BookService bookService;
    // private final Producer producer;

    public BookController(BookService bookService) {
        this.bookService = bookService;
        // this.producer = producer;
    }
    // public BookController(BookService bookService, Producer producer) {
    //     this.bookService = bookService;
    //     // this.producer = producer;
    // }

    @GetMapping
    public List<BookRecord> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("{id}")
    public Book getBookById(@PathVariable Long id) {
        // Récupérer le livre par son ID
        Book book = bookService.findById(id);

        // Si le livre est trouvé, créer un message et l'envoyer
        if (book != null) {
            // Message<Book> message = Message.<Book>builder()
            //         .id(UUID.randomUUID().toString())
            //         .message(book)
            //         .build();
            // producer.send(message);
        } else {
            System.out.println("Book not found");
        }

        // Retourner le livre trouvé
        return book;
    }


    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.update(book, id);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }

}
