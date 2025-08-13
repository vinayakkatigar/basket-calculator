package com.shopping.cart.basket.impl;

import com.shopping.cart.basket.BasketCalculator;
import com.shopping.cart.basket.calc.PriceCalculator;
import com.shopping.cart.basket.calc.impl.ApplePriceCalculator;
import com.shopping.cart.basket.calc.impl.OrangePriceCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BasketCalculatorImpl implements BasketCalculator {
    private final String ALLOWED_BASKET_ITEM_APPLE = "apple";
    private final String ALLOWED_BASKET_ITEM_ORANGE = "orange";

    private final PriceCalculator applePriceCalculator = new ApplePriceCalculator();
    private final PriceCalculator orangePriceCalculator = new OrangePriceCalculator();

    @Override
    public BigDecimal calulateBasketValue(List<String> basketItems) {
        if (basketItems == null || basketItems.isEmpty()){
            throw new RuntimeException("Empty basket.");
        }

        List<String> filteredBasketItems = basketItems.stream().filter(Objects::nonNull)
                .filter(x -> ( (x.toLowerCase().equals(ALLOWED_BASKET_ITEM_ORANGE))
                        || (x.toLowerCase().equals(ALLOWED_BASKET_ITEM_APPLE)))).collect(Collectors.toList());

        if (filteredBasketItems == null || filteredBasketItems.isEmpty()){
            throw new RuntimeException("Only Apples and oranges are allowed as basket items.");
        }


        BigDecimal basketValue = BigDecimal.ZERO;

        List<String> appleBasketItems = basketItems.stream().filter(Objects::nonNull)
                .filter(x -> ((x.toLowerCase().equals(ALLOWED_BASKET_ITEM_APPLE)))).collect(Collectors.toList());

        if (appleBasketItems != null && (!appleBasketItems.isEmpty())){
            basketValue = basketValue.add(applePriceCalculator.calcPrice(appleBasketItems));
        }

        List<String> orangeBasketItems = basketItems.stream().filter(Objects::nonNull)
                .filter(x -> ((x.toLowerCase().equals(ALLOWED_BASKET_ITEM_ORANGE)))).collect(Collectors.toList());

        if (orangeBasketItems != null && (!orangeBasketItems.isEmpty())){
            basketValue = basketValue.add(orangePriceCalculator.calcPrice(orangeBasketItems));
        }

        basketValue = basketValue.divide(BigDecimal.valueOf(100d), 2, RoundingMode.HALF_EVEN);

        return basketValue;
    }
}
