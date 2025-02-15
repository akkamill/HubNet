package com.example.hubNet.entities.general.analytics;

import com.example.hubNet.entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "mixture")
@Data
public class MixtureEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mixtureId;

    private int weeklySales;
    private int newUsers;
    private int itemOrders;
    private int bugReports;

    @ManyToOne
    private UserEntity user;

}
