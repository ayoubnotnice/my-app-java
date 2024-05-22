package mossaab.ayoub.restservice.models;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class Author {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private long birthday;
}
