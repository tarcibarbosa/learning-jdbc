package com.tarcirabarbosa.lil.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecutor {
    public static void main(String... args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                                                               "hplussport",
                                                                  "postgres",
                                                                   "PASSWORD");
        try {
            //Create Connection
            Connection connection = dcm.getConnection();
            //Data access object
            CustomerDAO customerDAO = new CustomerDAO(connection);
            //New Customer object populate
            Customer customer = new Customer();
            customer.setFirstName("Lula");
            customer.setLastName("Da Silva");
            customer.setEmail("lulinha_presidente@palacio.com.br");
            customer.setPhone("+55 62 963521478");
            customer.setAddress("Pálio do Planalto, cadeira presidencial 2022");
            customer.setCity("Brasília");
            customer.setState("Goiás");
            customer.setZipCode("000000-000");
            //CREATE customer in database
            Customer dbCustomer = customerDAO.create(customer);
            System.out.println(dbCustomer);
            // GET customer in database
            dbCustomer = customerDAO.findById(dbCustomer.getId());
            System.out.println(dbCustomer);
            //UPDATE customer in database
            dbCustomer.setEmail("inacio_lulinha_presidenta@palacio.com.br");
            dbCustomer = customerDAO.update(dbCustomer);
            System.out.println(dbCustomer);
            //DELETE customer in database
            customerDAO.delete(dbCustomer.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
