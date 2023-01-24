package com.example.sprdata.controller;

import com.example.sprdata.dto.OrderDto;
import com.example.sprdata.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping(value = "{id}")
    public OrderDto getById(@PathVariable Integer id) {
        if (id < 0) {
            throw new IllegalArgumentException("Invalid id");
        }
        return orderService.getById(id);
    }

    @GetMapping(value = "/all")
    public List<OrderDto> getAllOrders() {
        return orderService.getAll();
    }

    @DeleteMapping (value = "{id}")
    public void deleteById(@PathVariable Integer id) {
        if (id < 0) {
            throw new IllegalArgumentException("Invalid id");
        }
        orderService.deleteById(id);
    }

}