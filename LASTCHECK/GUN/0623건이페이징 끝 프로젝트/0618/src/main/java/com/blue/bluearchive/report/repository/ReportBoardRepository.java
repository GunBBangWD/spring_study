package com.blue.bluearchive.report.repository;

import com.blue.bluearchive.report.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportBoardRepository extends JpaRepository<Report,Integer> {
}
