package com.shopping.cart.basket.calc;

import java.math.BigDecimal;
import java.util.List;

public interface PriceCalculator {
    BigDecimal calcPrice(List<String> basketItems);
}
