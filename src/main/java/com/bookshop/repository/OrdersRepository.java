package com.bookshop.repository;

import com.bookshop.model.Order;

import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Order, Integer>{

}
