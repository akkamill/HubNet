package com.example.ecommerceDemo.entities.invoices;

import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.entities.invoices.enums.InvoiceStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "invoice")
public class InvoiceEntity {

    @Id
    @GeneratedValue(generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.example.ecommerceDemo.entities.invoices.InvoiceIdGenerator")
    private String invoiceId;

    private LocalDate dueDate;

    @CreationTimestamp
    private LocalDate createDate;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus invoiceStatus;

    @OneToMany(mappedBy = "invoiceEntity", cascade = CascadeType.ALL)
    private List<InvoiceDetailsEntity> invoiceDetails;

    @OneToOne(mappedBy = "invoice", cascade = CascadeType.ALL)
    @JsonIgnore
    private InvoiceCartEntity invoiceCart;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity invoiceSender;

    @ManyToMany
    @JoinTable(
            name = "invoice_recipient",
            joinColumns = @JoinColumn(name = "invoice_id"),
            inverseJoinColumns = @JoinColumn(name = "recipient_id"))
    private List<UserEntity> recipientInvoice;


}
