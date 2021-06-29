package com.assignment.dunzo.machine;

import com.assignment.dunzo.machine.util.CoffeeMachineExecutor;
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
		String input = readFileToString(CoffeeMachineApplication.class.getClassLoader().getResource(args[0]).getFile());
		CoffeeMachineExecutor coffeeMachineExecutor = CoffeeMachineExecutor.getInstance(input);
		coffeeMachineExecutor.prepareItems();
		coffeeMachineExecutor.stop();
	}

	private String readFileToString(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		StringBuilder stringBuilder = new StringBuilder();
		char[] buffer = new char[10];
		while (reader.read(buffer) != -1) {
			stringBuilder.append(new String(buffer));
			buffer = new char[10];
		}
		reader.close();

		return stringBuilder.toString();

	}
}
