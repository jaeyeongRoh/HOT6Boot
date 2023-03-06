package com.hotsix.titans.salary.repository;

import com.hotsix.titans.salary.entity.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BonusRepository extends JpaRepository<Bonus, String> {
}
