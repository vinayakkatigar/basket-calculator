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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BasketCalculatorApplicationTests {

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
        List<String> basketItems = List.of("apple", "apple");
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(BigDecimal.valueOf(0.3)) == 0);
        basketItems =  List.of("apple", "apple", "apple", "apple");
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(BigDecimal.valueOf(0.6)) == 0);
	}

	@Test
	void testOddAppleBasketItems() {
        List<String> basketItems = List.of("apple");
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(BigDecimal.valueOf(0.6)) == 0);
        basketItems =  List.of("apple", "apple", "apple");
        assertTrue(objectUnderTest.calulateBasketValue(basketItems).compareTo(BigDecimal.valueOf(0.9)) == 0);
    }

	@Test
	void testOnlyOrangeBasketItems() {
        AssertionErrors.fail("To-Do");
	}
	@Test
	void testAppleAndOrangeBasketItems() {
        AssertionErrors.fail("To-Do");
	}

}
