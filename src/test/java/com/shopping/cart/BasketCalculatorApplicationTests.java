package com.shopping.cart;

import com.shopping.cart.basket.BasketCalculator;
import com.shopping.cart.basket.impl.BasketCalculatorImpl;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.util.AssertionErrors;

import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BasketCalculatorApplicationTests {

    public static final String APPLE = "apple";
    public static final String ORANGE = "orange";
    private static BasketCalculator objectUnderTest;

    @BeforeAll
    public static void setUp(){
        objectUnderTest = new BasketCalculatorImpl();
    }

	@Test
	void testEmptyItems() {
        RuntimeException  thrown = assertThrows(
                RuntimeException.class,
                () -> objectUnderTest.calulateBasketValue(null),
                "Empty basket."
        );

        assertTrue(thrown.getMessage().equalsIgnoreCase("Empty basket."));
	}

	@Test
	void testNotAppleNotOrangesItems() {
        List<String> basketItems = List.of("grapes");
        RuntimeException  thrown = assertThrows(
                RuntimeException.class,
                () -> objectUnderTest.calulateBasketValue(basketItems),
                "Only Apples and oranges are allowed as basket items."
        );

        assertTrue(thrown.getMessage().equalsIgnoreCase("Only Apples and oranges are allowed as basket items."));
	}

	@Test
	void testEvenAppleBasketItems() {
        List<String> basketItems = List.of(APPLE, APPLE);
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(0.6)) == 0);
        basketItems =  List.of(APPLE, APPLE, APPLE, APPLE);
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(1.2)) == 0);
	}

	@Test
	void testOddAppleBasketItems() {
        List<String> basketItems = List.of(APPLE);
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(0.6)) == 0);
        basketItems =  List.of(APPLE, APPLE, APPLE);
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(1.2)) == 0);
    }

	@Test
	void testOnlyOrangeBasketItems() {
        List<String> basketItems = List.of(ORANGE);
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(0.25)) == 0);
        basketItems =  List.of(ORANGE, ORANGE);
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(0.50)) == 0);
        basketItems =  List.of(ORANGE, ORANGE, ORANGE);
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(0.50)) == 0);
        basketItems =  List.of(ORANGE, ORANGE, ORANGE, ORANGE);
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(0.75)) == 0);
        basketItems =  List.of(ORANGE, ORANGE, ORANGE, ORANGE, ORANGE);
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(1.0)) == 0);
        basketItems =  List.of(ORANGE, ORANGE, ORANGE, ORANGE, ORANGE, ORANGE);
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(1.0)) == 0);
    }

	@Test
	void testAppleAndOrangeBasketItems() {
        List<String> basketItems = List.of(APPLE, ORANGE);
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(0.85)) == 0);
        basketItems =  List.of(APPLE, APPLE, ORANGE);
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(0.85)) == 0);
        basketItems =  List.of(APPLE, APPLE, APPLE, ORANGE);
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(1.45)) == 0);
        basketItems =  List.of(APPLE, APPLE, APPLE, APPLE, ORANGE, ORANGE);
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(1.7)) == 0);
        basketItems =  List.of(APPLE, APPLE, APPLE, APPLE, ORANGE, ORANGE, ORANGE);
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(1.7)) == 0);
        basketItems =  List.of(APPLE, APPLE, APPLE, APPLE, ORANGE, ORANGE, ORANGE, ORANGE);
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(1.95)) == 0);
        basketItems =  List.of(APPLE, APPLE, APPLE, APPLE, APPLE, ORANGE, ORANGE, ORANGE, ORANGE, ORANGE);
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(2.8)) == 0);
        basketItems =  List.of(APPLE, APPLE, APPLE, APPLE, APPLE, ORANGE, ORANGE, ORANGE, ORANGE, ORANGE, "grapes");
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(valueOf(2.8)) == 0);
    }

}
