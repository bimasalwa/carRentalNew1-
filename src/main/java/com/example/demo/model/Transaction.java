package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Reader;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "transaction_table")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transaction_id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users user_id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer_id;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    private Car car_id;

    @NotBlank
    private Instant checkin_time;

    @NotBlank
    private Instant checkout_time;

    @ManyToOne
    @JoinColumn(name = "payment_type", referencedColumnName = "system_code")
    private SystemMaster payment_type;

    @ManyToOne
    @JoinColumn(name = "car_return_status", referencedColumnName = "system_code")
    private SystemMaster car_return_status;

    @ManyToOne
    @JoinColumn(name = "transaction_driver_type", referencedColumnName = "system_code")
    private SystemMaster transaction_driver_type;

    // OPTIONAL
    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "driver_id")
    private Driver driver_id;

    @Size(max = 50)
    private String driver_price_day;

    @Size(max = 50)
    private String driver_price_hour;

    @Autowired
    DateTracker dateTracker;

    BigDecimal fineAmount = BigDecimal.valueOf(10.000);

    public BigDecimal getFineOfCar(Order order) {
        long daysTooLate = dateTracker.daysTooLate(order.getReturnCar());
        BigDecimal fine = fineAmount.multiply(BigDecimal.valueOf(daysTooLate));
        return fine;
    }

    //Returns a map of all users with the amount of fines in $.
    public LinkedHashMap<Reader, BigDecimal> getAllUsersWithFines(List<Reader> readers) {
        LinkedHashMap<Reader, BigDecimal> allUsersWithFines = new LinkedHashMap<Reader, BigDecimal>();

        for (Reader reader : readers) {

            if (reader.getOrder().size() == 0) {
                allUsersWithFines.put(reader, BigDecimal.valueOf(0.00));

            } else {
                long totalDaysTooLate = 0;
                for (Order order : reader.getOrder()) {
                    long daysTooLate = dateTracker.differenceInDays(order.getReturnCar());
                    if (daysTooLate > 0) totalDaysTooLate += daysTooLate;
                }

                BigDecimal totalDaysTooLateInBD = new BigDecimal(totalDaysTooLate);
                BigDecimal totalFineInDollar = fineAmount.multiply(totalDaysTooLateInBD);
                allUsersWithFines.put(reader, totalFineInDollar);
            }
        }
        return allUsersWithFines;
    }

    //Returns a map of car
    public LinkedHashMap<Order, BigDecimal> getBooksWithFines(List<Order> orders) {
        LinkedHashMap<Order, BigDecimal> ordersWithFines = new LinkedHashMap<Order, BigDecimal>();

        for (Order order : orders) {
            long daysTooLate = dateTracker.differenceInDays(order.getReturnCar());
            if (daysTooLate > 0) {
                BigDecimal daysTooLateInBD = new BigDecimal(daysTooLate);
                BigDecimal totalFineInRp = fineAmount.multiply(daysTooLateInBD);
                ordersWithFines.put(order, totalFineInRp);
            } else {
                BigDecimal noFine = BigDecimal.valueOf(0.00);
                ordersWithFines.put(order, noFine);
            }
        }
        return ordersWithFines;
    }

    //Returns a map containing only books that have a fine > $0.00.
    public LinkedHashMap<Order, BigDecimal> selectBooksWithFines(List<Order> orders) {
        LinkedHashMap<Order, BigDecimal> ordersWithFines = new LinkedHashMap<Order, BigDecimal>();

        for (Order order : orders) {
            long daysTooLate = dateTracker.differenceInDays(order.getReturnCar());
            if (daysTooLate > 0) {
                BigDecimal daysTooLateInBD = new BigDecimal(daysTooLate);
                BigDecimal totalFineInRp = fineAmount.multiply(daysTooLateInBD);
                ordersWithFines.put(order, totalFineInRp);
            }
        }
        return ordersWithFines;
    }

    public boolean hasFineOrNot(Reader reader) {
        boolean hasFine = false;
        for (Order order : reader.getOrder()) {
            if (order.getReturnCar().compareTo(LocalDate.now()) < 0) {
                hasFine = true;
            }
        }
        return hasFine;
    }

    public BigDecimal getTotalFine(List<Order> orders) {

        BigDecimal totalFine = BigDecimal.valueOf(0.0);

        for (Order order : orders) {
            long daysTooLate = dateTracker.differenceInDays(order.getReturnCar());
            if (daysTooLate > 0) {
                BigDecimal daysTooLateInBD = new BigDecimal(daysTooLate);
                BigDecimal fineOfPinjam = fineAmount.multiply(daysTooLateInBD);
                totalFine = totalFine.add(fineOfPinjam);
            }
        }
        return totalFine;
    }

}