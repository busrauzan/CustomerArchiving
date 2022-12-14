package com.busrauzan.customerarchiving.DataAccess;

import com.busrauzan.customerarchiving.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
