package mossaab.ayoub.restservice.records;

import mossaab.ayoub.restservice.models.Author;

public record BookRecord(String isbn, String title, long lastModifiedDate, long publishedDate, Author author) {
}
