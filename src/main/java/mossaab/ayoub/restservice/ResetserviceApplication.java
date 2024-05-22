package mossaab.ayoub.restservice;

import com.fasterxml.jackson.core.JsonProcessingException;

import mossaab.ayoub.restservice.entities.Book;
import mossaab.ayoub.restservice.repositories.AuthorRepository;
import mossaab.ayoub.restservice.repositories.BookRepository;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableRabbit
public class ResetserviceApplication {


    private final AuthorRepository authorRepository;

    public ResetserviceApplication(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ResetserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository) throws JsonProcessingException {

        authorRepository.getAuthorById(1L);
        /*String email = "johndoe@example.com";
        List<Author> author = authorService.findAuthorByEmail(email);*/
    //    authorService.findAuthorByEmail("johndoe@example.com");

        /*graphqlRespPayload.gerGraphQlRespPayload();*/

        return args -> {
            Book book1 = new Book("9780743273565", 1, "The Great Gatsby", 1722086400000L, 1678944000000L);
            Book book2 = new Book("9780061120084", 1, "To Kill a Mockingbird", 1661558400000L, 1625097600000L);
            Book book3 = new Book("9780451524935", 2, "1984", 1640995200000L, 1609459200000L);
            Book book4 = new Book("9780141439518", 2, "Pride and Prejudice", 1569888000000L, 1506816000000L);
            Book book5 = new Book("9780316769488", 2, "The Catcher in the Rye", 1524678400000L, 1451606400000L);
            bookRepository.save(book1);
            bookRepository.save(book2);
            bookRepository.save(book3);
            bookRepository.save(book4);
            bookRepository.save(book5);
        };
    }
}

