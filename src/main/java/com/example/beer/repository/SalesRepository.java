package com.example.beer.repository;

import com.example.beer.model.SalesRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<SalesRecord, Long> {
    // 必要に応じて検索条件を追加できます（例：日付範囲検索など）
}
