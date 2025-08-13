package com.shopping.cart.basket.calc.impl;

import com.shopping.cart.basket.calc.PriceCalculator;

import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.valueOf;

public class OrangePriceCalculator implements PriceCalculator {
    public static double price = 25;
    public static double threeForTwoDiscountRate = 2;

    public BigDecimal calcPrice(List<String> orangeBasketItems) {
        int itemsSize = orangeBasketItems.size();
        if (itemsSize > 0 ){
            if (itemsSize % 3 == 0 ){
                return valueOf((itemsSize / 3) * price * threeForTwoDiscountRate);
            }else if (itemsSize > 3){
                int remainderOfThree = itemsSize % 3;
                return valueOf((itemsSize / 3) * price * threeForTwoDiscountRate)
                        .add(valueOf((remainderOfThree * price)));
            }else {
                return valueOf((itemsSize) * price );
            }

        }
        return BigDecimal.ZERO;
    }
}
