package com.example.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT * FROM customer_table c WHERE c.customer_name LIKE :param% OR c.id_number LIKE :param%", nativeQuery = true)
    List<Customer> inquiryCustomer(@Param("param") String param);
}
