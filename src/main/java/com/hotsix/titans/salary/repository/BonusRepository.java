package com.hotsix.titans.salary.repository;

import com.hotsix.titans.salary.entity.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface BonusRepository extends JpaRepository<Bonus, String> {

    List<Bonus> findByBonusPaymentsDateBetween(Date start, Date end);
}
