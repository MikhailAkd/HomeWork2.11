package com.onsscart.HW21.service;

import com.onsscart.HW21.component.ProductBasket;
import com.onsscart.HW21.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StoreService {

    private final ProductBasket productBasket;
    private final Map<Integer, Product> products;

    public StoreService(ProductBasket productBasket) {
        this.productBasket = productBasket;
        this.products = Map.of(
                1, new Product(1, "Мультитул", 2000),
                2, new Product(2, "Набор KINDER", 1100),
                3, new Product(3, "Поисковый магнит", 2750),
                4, new Product(4, "Jelly Belly", 550),
                5, new Product(5, "Модули памяти Kingston", 5900),
                6, new Product(6, "Карты Таро", 950),
                7, new Product(7, "Мягкая игрушка", 1500)
        );
    }

    public void add(List<Integer> ids) {
        productBasket.add(
                ids.stream()
                        .map(products::get)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList())
        );
    }

    public List<Product> get() {
        return productBasket.get();
    }
}
