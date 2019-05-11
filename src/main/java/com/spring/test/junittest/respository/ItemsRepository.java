package com.spring.test.junittest.respository;

import com.spring.test.junittest.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Item, Integer> {

}
