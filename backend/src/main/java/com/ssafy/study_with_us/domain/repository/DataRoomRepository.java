package com.ssafy.study_with_us.domain.repository;

import com.ssafy.study_with_us.domain.entity.DataRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRoomRepository extends JpaRepository<DataRoom, Long>, DataRoomRepositoryCustom {
    DataRoom save(DataRoom dataRoom);
    DataRoom getById(Long id);
}
