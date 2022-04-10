package com.shashi.TransactionQ.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shashi.TransactionQ.entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Long>{

}
