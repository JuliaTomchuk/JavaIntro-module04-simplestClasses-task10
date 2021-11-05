package by.home.module04.task10.main;

/*Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы get- и set- методы и метод toString().
 *  Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами.Задать критерии выбора данных и вывести эти данные на консоль. 
 *  Airline: пункт назначения, номер рейса,тип самолёта, время вылета,дни недели.
 *  Найти и вывести: 
 * список рейсов для заданного пункта назначения;
 * список рейсов для заданного дня недели; 
 * список рейсов для заданного дня недели, время вылета для которых больше заданного.*/

import java.util.ArrayList;

import by.home.module04.task10.entity.Airline;
import by.home.module04.task10.entity.Airport;
import by.home.module04.task10.entity.DayOfWeek;
import by.home.module04.task10.entity.Time;
import by.home.module04.task10.logic.AirportLogic;
import by.home.module04.task10.view.View;

public class Main {

	public static void main(String[] args) {
		Airport airport = new Airport();

		airport.addAirline(new Airline("London", 1, "Boeing", new Time(9, 40), DayOfWeek.FRIDAY));

		airport.addAirline(new Airline("Lima", 2, "Boeing", new Time(10, 40), DayOfWeek.MONDAY));
		airport.addAirline(new Airline("Athens", 3, "Airbus", new Time(12, 30), DayOfWeek.TUESDAY));
		airport.addAirline(new Airline("Berlin", 4, "Boeing", new Time(17, 37), DayOfWeek.SATURDAY));
		airport.addAirline(new Airline("Athens", 5, "Airbus", new Time(15, 0), DayOfWeek.SUNDAY));
		airport.addAirline(new Airline("Hong Kong", 6, "Airbus", new Time(10, 0), DayOfWeek.THURSDAY));
		airport.addAirline(new Airline("London", 7, "Airbus", new Time(19, 27), DayOfWeek.WEDNESDAY));
		airport.addAirline(new Airline("Milan", 8, "Airbus", new Time(23, 0), DayOfWeek.SATURDAY));
		airport.addAirline(new Airline("Berlin", 9, "Boeing", new Time(14, 15), DayOfWeek.WEDNESDAY));
		airport.addAirline(new Airline("Hong Kong", 10, "Airbus", new Time(12, 35), DayOfWeek.FRIDAY));
		airport.addAirline(new Airline("Athens", 11, "Boeing", new Time(14, 0), DayOfWeek.FRIDAY));
		airport.addAirline(new Airline("Madrid", 12, "Airbus", new Time(8, 40), DayOfWeek.SATURDAY));
		airport.addAirline(new Airline("Milan", 13, "Boeing", new Time(7, 40), DayOfWeek.FRIDAY));
		airport.addAirline(new Airline("Madrid", 14, "Airbus", new Time(4, 40), DayOfWeek.SATURDAY));

		View view = new View();

		view.print(airport.getAirlines());

		AirportLogic logic = new AirportLogic();

		ArrayList<Airline> toLima = (ArrayList<Airline>) logic.findByDestination("Lima", airport.getAirlines());

		view.print(toLima, "Пунк назначения:Лима");

		ArrayList<Airline> fridayFlights = (ArrayList<Airline>) logic.findByDayOfweek(DayOfWeek.FRIDAY,
				airport.getAirlines());

		view.print(fridayFlights, "День вылета:пятница");

		Time time = new Time(12, 20);

		ArrayList<Airline> byTime = (ArrayList<Airline>) logic.findByTime(time, fridayFlights);

		view.print(byTime, "День вылета:пятница. Время вылета: после " + time.getHour() + ":" + time.getMinute());

	}

}