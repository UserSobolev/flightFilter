package com.gridnine.testing;

import com.gridnine.testing.filter.FlightsFilter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlightsFilter Flightsfilter = new FlightsFilter();
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("""
                        Выберите пункт для фильтрации рейсов:
                        1 - исключить рейсы с вылетом до текущего момента времени
                        2 - исключить рейсы с датой прилёта раньше даты вылета
                        3 - исключить рейсы с пересадками более 2 часов
                        4 - для завершения работы""");

                int temp = scanner.nextInt();
                if (temp > 0 && temp < 4) {
                    Flightsfilter.getFilters(temp);
                } else if (temp == 4) {
                    break;
                } else {
                    System.out.println("Несуществующий тип фильтрации, попробуйте еще раз");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Некорректные параметры ввода, попробуйте еще раз" + exception.fillInStackTrace());
            }
        }
    }
}