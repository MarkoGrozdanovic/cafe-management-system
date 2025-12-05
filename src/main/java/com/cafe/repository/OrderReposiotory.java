package com.cafe.repository;

import com.cafe.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReposiotory extends JpaRepository<Order, Long> {
}
