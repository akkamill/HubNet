package com.example.ecommerceDemo.entities.invoices;


import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class InvoiceIdGenerator implements IdentifierGenerator {

    private static final String PREFIX = "INV-";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        int random = (int) (Math.random() * 100000);
        return PREFIX + random;
    }
}
