package com.kihwangkwon.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kihwangkwon.stock.domain.StockList;
@Repository
public interface StockListRepository extends JpaRepository<StockList, Long> {
}
