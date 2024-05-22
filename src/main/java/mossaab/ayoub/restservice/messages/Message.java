// package mossaab.ayoub.restservice.messages;

// import lombok.Builder;
// import lombok.Data;

// import java.io.Serializable;
// import java.util.UUID;

// @Data
// @Builder
// public class Message<T> implements Serializable {
//     private String id;
//     private T message;

//     public Message(String id, T message) {
//         this.id = id;
//         this.message = message;
//     }

//     // Constructeur par défaut initialisant l'ID avec UUID
//     public Message() {
//         this.id = UUID.randomUUID().toString();
//     }
// }
