package com.shopping.cart.basket.calc;

import java.math.BigDecimal;
import java.util.List;

public class ApplePriceCalculator {

    public static double discountRate = 0.5;
    public static double price = 60;

    public BigDecimal calcPrice(List<String> appleBasketItems) {
        int itemsSize = appleBasketItems.size();
        if (itemsSize > 0 ){
            if (itemsSize % 2 == 0 ){
                return BigDecimal.valueOf((itemsSize / 2) * price * discountRate);
            }else {
                return BigDecimal.valueOf((itemsSize / 2) * price * discountRate).add(BigDecimal.valueOf(price));
            }

        }
        return BigDecimal.ZERO;
    }
}
