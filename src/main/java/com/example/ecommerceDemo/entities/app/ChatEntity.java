    package com.example.ecommerceDemo.entities.app;

    import com.example.ecommerceDemo.entities.UserEntity;
    import jakarta.persistence.*;
    import jakarta.transaction.Transactional;
    import lombok.Data;
    import org.hibernate.annotations.CreationTimestamp;
    import org.springframework.web.multipart.MultipartFile;

    import java.time.LocalDateTime;
    import java.util.List;

    @Data
    @Entity
    public class ChatEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String chatText;

        @ManyToOne
        @JoinColumn(name = "sender_id")
        private UserEntity senderChat;

        @ManyToMany
        @JoinTable(
                name = "chat_recipients",
                joinColumns = @JoinColumn(name = "chat_id"),
                inverseJoinColumns = @JoinColumn(name = "recipient_id"))
        private List<UserEntity> recipientChat;

        @Transient
        private MultipartFile attachFile;
        private String attachFilePath;

        @Transient
        private MultipartFile voiceMessage;
        private String voiceMessagePath;

        @CreationTimestamp
        private LocalDateTime createdAt;


    }
