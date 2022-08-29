package com.example.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.model.Car;


@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
    @Query(value = "SELECT * FROM car_table c WHERE c.car_name LIKE :param% OR c.license_number LIKE :param%", nativeQuery = true)
    List<Car> inquiryCar(@Param("param") String param);
}
