package com.himanshu.tacos.data;

import com.himanshu.tacos.model.Order;

public interface OrderRepository {
	Order save(Order order);
}
