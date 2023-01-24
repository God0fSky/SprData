package com.example.sprdata.service;

import com.example.sprdata.dto.OrderDto;
import com.example.sprdata.dto.ProductDto;
import com.example.sprdata.model.Order;
import com.example.sprdata.model.Product;
import com.example.sprdata.repository.OrderRepository;
import com.example.sprdata.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    public OrderDto createOrder(OrderDto orderDto) {
        Order order = objectMapper.convertValue(orderDto, Order.class);
        orderRepository.save(order);
        orderDto.setId(order.getId());
        return orderDto;
    }

    public ProductDto addProduct(int orderId, String name, BigDecimal cost) {
        var productModel = new Product();
        productModel.setName(name);
        productModel.setCost(cost);
        Optional<Order> order = orderRepository.findById(orderId);
        productModel.setOrder(order.orElseThrow(
                () -> new EntityNotFoundException("User with id=" + orderId + " wasnt found"))
        );
        productRepository.save(productModel);
        return objectMapper.convertValue(productModel, ProductDto.class);
    }

    public List<OrderDto> getAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(item -> objectMapper.convertValue(item, OrderDto.class))
                .collect(Collectors.toList());
    }

    public OrderDto getById(int id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return objectMapper.convertValue(order, OrderDto.class);
    }

    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }

}
