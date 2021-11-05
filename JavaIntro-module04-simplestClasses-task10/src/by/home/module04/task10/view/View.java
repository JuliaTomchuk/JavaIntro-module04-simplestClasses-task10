package by.home.module04.task10.view;

import java.util.List;

import by.home.module04.task10.entity.Airline;

public class View {

	public void print(List<Airline> airlines) {

		for (int i = 0; i < airlines.size(); i++) {
			System.out.println(airlines.get(i));
		}

	}

	public void print(List<Airline> airlines, String message) {

		System.out.println(message);

		for (int i = 0; i < airlines.size(); i++) {
			System.out.println(airlines.get(i));
		}

	}

}
