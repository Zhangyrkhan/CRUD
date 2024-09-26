package com.example.backendforuniversity.repository;

import com.example.backendforuniversity.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
