package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.model.Brand;
import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query(value = "SELECT * FROM brand_table b WHERE b.brand_name LIKE :param%", nativeQuery = true)
    List<Brand> inquiryBrand(@Param("param") String param);

    @Query(value = "SELECT * FROM brand_table b WHERE b.brand_name = :brand_name", nativeQuery = true)
    String brandIsExist(@Param("brand_name") String brand_name);
}
