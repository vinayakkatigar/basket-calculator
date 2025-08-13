package com.shopping.cart.basket.calc;

import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.valueOf;

public class ApplePriceCalculator {

    public static double twoForOneDiscountRate = 0.5;
    public static double price = 60;

    public BigDecimal calcPrice(List<String> appleBasketItems) {
        int itemsSize = appleBasketItems.size();
        if (itemsSize > 0 ){
            if (itemsSize % 2 == 0 ){
                return valueOf((itemsSize) * price * twoForOneDiscountRate);
            }else if (itemsSize > 2){
                int remainderOfTwo = itemsSize % 2;
                return valueOf((itemsSize / 2) * price)
                        .add(valueOf((remainderOfTwo * price)));
            }else {
                return valueOf((itemsSize ) * price);
            }

        }
        return BigDecimal.ZERO;
    }
}
