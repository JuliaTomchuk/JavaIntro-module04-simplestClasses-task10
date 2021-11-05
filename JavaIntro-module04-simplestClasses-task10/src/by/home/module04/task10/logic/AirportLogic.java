package by.home.module04.task10.logic;

import java.util.ArrayList;
import java.util.List;

import by.home.module04.task10.entity.Airline;
import by.home.module04.task10.entity.DayOfWeek;
import by.home.module04.task10.entity.Time;

public class AirportLogic {

	public List<Airline> findByDestination(String destination, List<Airline> airlines) {
		ArrayList<Airline> result = new ArrayList<>();
		for (int i = 0; i < airlines.size(); i++) {
			if (airlines.get(i).getDestination().equals(destination)) {
				result.add(airlines.get(i));
			}
		}

		return result;
	}

	public List<Airline> findByDayOfweek(DayOfWeek day, List<Airline> airlines) {

		ArrayList<Airline> result = new ArrayList<>();
		for (int i = 0; i < airlines.size(); i++) {
			if (airlines.get(i).getDay().equals(day)) {
				result.add(airlines.get(i));
			}
		}
		return result;
	}

	public List<Airline> findByTime(Time time, List<Airline> airlines) {

		ArrayList<Airline> result = new ArrayList<>();
		for (int i = 0; i < airlines.size(); i++) {
			if (airlines.get(i).getDepartureTime().getHour() > time.getHour()
					|| (airlines.get(i).getDepartureTime().getHour() == time.getHour()
							&& airlines.get(i).getDepartureTime().getMinute() > time.getMinute())) {
				result.add(airlines.get(i));

			}

		}
		return result;

	}
}