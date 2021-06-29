package com.assignment.dunzo.machine;

import com.assignment.dunzo.machine.controller.CoffeeMachineExecutor;
import com.assignment.dunzo.machine.util.FileReaderUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class CoffeeMachineApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeMachineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (args.length < 1) {
			System.out.println(" Please run with input file ");
			return;
		}
		String input = FileReaderUtil.readFileToString(CoffeeMachineApplication.class.getClassLoader().getResource(args[0]).getFile());
		CoffeeMachineExecutor coffeeMachineExecutor = CoffeeMachineExecutor.getInstance(input);
		coffeeMachineExecutor.prepareItems();
		coffeeMachineExecutor.stop();
	}


}
