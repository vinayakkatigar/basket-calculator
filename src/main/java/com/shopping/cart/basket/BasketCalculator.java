package com.shopping.cart.basket;

import java.math.BigDecimal;
import java.util.List;

public interface BasketCalculator {

    BigDecimal calulateBasketValue(List<String> basketItems);
}
