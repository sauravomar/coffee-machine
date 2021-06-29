package com.assignment.dunzo.machine;

import com.assignment.dunzo.machine.controller.CoffeeMachineExecutor;
import com.assignment.dunzo.machine.util.FileReaderUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;

@RunWith(SpringJUnit4ClassRunner.class)
class CoffeeMachineApplicationTests {

	CoffeeMachineExecutor coffeeMachineExecutor;

	@BeforeEach
	public void setUp() {
	}

	@AfterEach
	public void tearDown() {
		coffeeMachineExecutor.stop();
		try {
			Field instance = CoffeeMachineExecutor.class.getDeclaredField("coffeeMachineExecutor");
			instance.setAccessible(true);
			instance.set(null, null);
		}catch (Exception ex){
			System.out.println(" Failed to reset CoffeeMachineExecutor object");
		}
	}


	@Test
	public void testWithGivenValidInput() throws Exception {
		final String filePath = "input.json";
		String input = FileReaderUtil.readFileToString(filePath);
		coffeeMachineExecutor = CoffeeMachineExecutor.getInstance(input);
		coffeeMachineExecutor.prepareItems();
	}

	@Test
	public void testWithEmptyQuantity() throws Exception {
		final String filePath = "empty_total_quantity.json";
		String input = FileReaderUtil.readFileToString(filePath);
		coffeeMachineExecutor = CoffeeMachineExecutor.getInstance(input);
		coffeeMachineExecutor.prepareItems();
	}

	@Test
	public void testWithInvalidIngredients() throws Exception {
		final String filePath = "invalid_ingredient.json";
		String input = FileReaderUtil.readFileToString(filePath);
		coffeeMachineExecutor = CoffeeMachineExecutor.getInstance(input);
		coffeeMachineExecutor.prepareItems();
	}


}
