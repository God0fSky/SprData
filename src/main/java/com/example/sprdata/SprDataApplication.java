package com.example.sprdata;

import com.example.sprdata.repository.OrderRepository;
import com.example.sprdata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class SprDataApplication {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(SprDataApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        /*List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(new ProductDto("Product3", BigDecimal.valueOf(25)));
        productDtoList.add(new ProductDto("Product4", BigDecimal.valueOf(75)));
        var dto = new OrderDto(null, LocalDate.now(), BigDecimal.valueOf(100), productDtoList);
        orderService.createOrder(dto);

        orderService.addProduct(dto.getId(), "Product3", BigDecimal.valueOf(25));
        orderService.addProduct(dto.getId(), "Product4", BigDecimal.valueOf(75));*/

    }

}
