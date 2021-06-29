package com.assignment.dunzo.machine;

import com.assignment.dunzo.machine.controller.CoffeeMachineExecutor;
import com.assignment.dunzo.machine.util.FileReaderUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoffeeMachineApplication implements CommandLineRunner {

	public static void main(String[] args) throws Exception{

		SpringApplication.run(CoffeeMachineApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length < 1) {
			System.out.println(" Please run with input file ");
			return;
		}
		System.out.println(args[0]);
		String input = FileReaderUtil.readFileToString(args[0]);
		CoffeeMachineExecutor coffeeMachineExecutor = CoffeeMachineExecutor.getInstance(input);
		coffeeMachineExecutor.prepareItems();
		coffeeMachineExecutor.stop();
	}
}
