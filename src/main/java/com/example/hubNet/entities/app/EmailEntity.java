package com.example.hubNet.entities.app;

import com.example.hubNet.entities.app.enums.EmailStatus;
import com.example.hubNet.entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Entity
@Data
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;

    private String subject;
    private String body;
    private boolean isDraft;
    private boolean isImportant;
    private boolean isRead;

    @Enumerated(EnumType.STRING)
    private EmailStatus emailStatus;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity senderEmail;

//    @ManyToOne
//    @JoinColumn(name = "recipient_id")
//    private UserEntity recipientEmail;

    @ManyToMany
    @JoinTable(
            name = "email_recipients",
            joinColumns = @JoinColumn(name = "email_id"),
            inverseJoinColumns = @JoinColumn(name = "recipient_id"))
    private List<UserEntity> recipientEmail;

    @Transient
    private MultipartFile attachment;
    private String attachmentPath;

}
