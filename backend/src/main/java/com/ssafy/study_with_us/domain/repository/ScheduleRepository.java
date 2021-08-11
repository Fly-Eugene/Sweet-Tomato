package com.ssafy.study_with_us.domain.repository;

import com.ssafy.study_with_us.domain.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Schedule save(Schedule schedule);
}
