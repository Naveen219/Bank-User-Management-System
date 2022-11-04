package com.capstone.gbuma;

import com.capstone.gbuma.entity.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public class GlobalBankUserManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlobalBankUserManagementApplication.class, args);
    }

    public static interface CustomerRepo extends JpaRepository<Customer,
            String> {
    }
}
