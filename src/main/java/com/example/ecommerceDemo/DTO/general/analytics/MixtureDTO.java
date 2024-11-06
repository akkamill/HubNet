package com.example.ecommerceDemo.DTO.general.analytics;

import lombok.Data;


@Data
public class MixtureDTO {

    private Long mixtureId;
    private int weeklySales;
    private int newUsers;
    private int itemOrders;
    private int bugReports;
    private Long userId;

}
