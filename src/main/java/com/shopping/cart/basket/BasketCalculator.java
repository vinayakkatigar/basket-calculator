package com.shopping.cart.basket;

import java.math.BigDecimal;
import java.util.List;

public interface BasketCalculator {
    String ALLOWED_BASKET_ITEM_APPLE = "apple";
    String ALLOWED_BASKET_ITEM_ORANGE = "orange";

    BigDecimal calulateBasketValue(List<String> basketItems);
}
