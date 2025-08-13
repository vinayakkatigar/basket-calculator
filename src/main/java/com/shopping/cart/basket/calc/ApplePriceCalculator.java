package com.shopping.cart.basket.calc;

import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.valueOf;

public class ApplePriceCalculator {

    public static double discountRate = 0.5;
    public static double price = 60;

    public BigDecimal calcPrice(List<String> appleBasketItems) {
        int itemsSize = appleBasketItems.size();
        if (itemsSize > 0 ){
            if (itemsSize % 2 == 0 ){
                return BigDecimal.valueOf((itemsSize) * price * discountRate);
            }else if (itemsSize > 2){
                int remainderOfTwo = itemsSize % 2;
                return valueOf((itemsSize / 2) * price)
                        .add(valueOf((remainderOfTwo * price)));
            }else {
                return BigDecimal.valueOf((itemsSize ) * price);
            }

        }
        return BigDecimal.ZERO;
    }
}
