package mossaab.ayoub.restservice.repositories;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import mossaab.ayoub.restservice.models.Author;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Optional;


@Repository
@Log
public class AuthorRepositoryImpl implements  AuthorRepository {

    @Value("${graphql.url}")
    private String API_URL;

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public AuthorRepositoryImpl(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<Author> getAuthorByEmail(String email) {
        String getAuthorByEmailQuery = "{\"query\": " +
                "\"query findAuthorByEmail($email: String!) { " +
                " findAuthorByEmail(email: $email) {" +
                " id " +
                " firstName " +
                " lastName " +
                " email " +
                " phone " +
                " birthday " +
                "} }\", " +
                "\"variables\": { " +
                "\"email\": \"" + email + "\"" +
                "} " +
                "}";

        /*
        * cette ligne de code crée une entité contenant la requête GraphQL au format JSON,
        * prête à être envoyée au serveur via la requête HTTP POST
        */
        StringEntity entity = new StringEntity(getAuthorByEmailQuery, ContentType.APPLICATION_JSON);
        HttpUriRequest request = RequestBuilder.post(API_URL)
                .setUri(API_URL)
                .setEntity(entity)
                .build();

        try {
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(response.getEntity().getContent());
                JsonNode authorNode = rootNode.path("data").path("findAuthorByEmail");

                if (!authorNode.isMissingNode()) {
                    Author author = new Author();
                    author.setId(authorNode.path("id").asLong());
                    author.setFirstName(authorNode.path("firstName").asText());
                    author.setLastName(authorNode.path("lastName").asText());
                    author.setEmail(authorNode.path("email").asText());
                    author.setPhone(authorNode.path("phone").asText());
                    author.setBirthday(authorNode.path("birthday").asLong());
                    System.out.println("response"+author.getBirthday());
                    return Optional.of(author);
                } else {
                    log.severe("Author not found for email: " + email);
                    return Optional.empty();
                }
            } else {
                log.severe("Couldn't retrieve author by email: " + email);
                return Optional.empty();
            }
        } catch (IOException e) {
            log.severe("Error occurred while retrieving author by email: " + email);
            log.severe(e.toString());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        String getAuthorById = "{\"query\": " +
                "\"query findAuthorById($id: ID!) { " +
                " findAuthorById(id: $id) {" +
                " id " +
                " firstName " +
                " lastName " +
                " email " +
                " phone " +
                " birthday " +
                "} }\", " +
                "\"variables\": { " +
                "\"id\": \"" + id + "\"" +
                "} " +
                "}";
        StringEntity entity = new StringEntity(getAuthorById, ContentType.APPLICATION_JSON);
        HttpUriRequest request = RequestBuilder.post(API_URL)
                .setUri(API_URL)
                .setEntity(entity)
                .build();

        try {
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(response.getEntity().getContent());
                JsonNode authorNode = rootNode.path("data").path("findAuthorById");

                if (!authorNode.isMissingNode()) {
                    Author author = new Author();
                    author.setId(authorNode.path("id").asLong());
                    author.setFirstName(authorNode.path("firstName").asText());
                    author.setLastName(authorNode.path("lastName").asText());
                    author.setEmail(authorNode.path("email").asText());
                    author.setPhone(authorNode.path("phone").asText());
                    author.setBirthday(authorNode.path("birthday").asLong());
                    System.out.println("response"+author.getBirthday());
                    return Optional.of(author);
                } else {
                    log.severe("Author not found for id: " + id);
                    return Optional.empty();
                }
            } else {
                log.severe("Couldn't retrieve author by id: " + id);
                return Optional.empty();
            }
        } catch (IOException e) {
            log.severe("Error occurred while retrieving author by id: " + id);
            log.severe(e.toString());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Author> getAuthorByFirstNameAndLastName(String firstName, String lastName) {
        return Optional.empty();
    }

}
