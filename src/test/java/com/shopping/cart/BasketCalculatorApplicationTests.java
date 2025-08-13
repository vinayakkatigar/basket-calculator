package com.shopping.cart;

import com.shopping.cart.basket.BasketCalculator;
import com.shopping.cart.basket.impl.BasketCalculatorImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.util.AssertionErrors;

@SpringBootTest
class BasketCalculatorApplicationTests {

    private BasketCalculator objectUnderTest;

    @BeforeTestClass
    public void setUp(){
        objectUnderTest = new BasketCalculatorImpl();
    }

	@Test
	void testEmptyItems() {
        AssertionErrors.fail("To-Do");
	}

	@Test
	void testOnlyAppleBasketItems() {
        AssertionErrors.fail("To-Do");
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
