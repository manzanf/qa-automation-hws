package com.playtika.automation.persons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.function.Function.identity;
import static java.util.function.Predicate.isEqual;
import static java.util.stream.Collectors.*;

public class PersonStatistics {
    private static final Logger logger = LogManager.getLogger(PersonStatistics.class);

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Ivan", 31, "Kyiv"),
                new Person("Sidor", 14, "Kyiv"),
                new Person("Mark", 31, "Odessa"),
                new Person("Dave", 53, "NY"),
                new Person("Nick", 27, "Odessa"),
                new Person("Petr", 40, "Odessa"));
        try {
            double averageAge = persons.stream()
                    .mapToInt(Person::getAge)
                    .average()
                    .orElseThrow(() -> new IllegalArgumentException());
            logger.info("Average age is " + averageAge);
        } catch (IllegalArgumentException e) {
            logger.error("Empty list of persons");
        }
        try {
            Person oldestPerson = persons.stream()
                    .max(comparing(Person::getAge))
                    .orElseThrow(() -> new IllegalArgumentException());
            logger.info("The oldest person is " + oldestPerson.getName());
        } catch (IllegalArgumentException e) {
            logger.error("Empty list of persons");
        }
        logger.info("The number of people with name Dave is " +
                persons.stream()
                        .map(Person::getName)
                        .filter(isEqual("Dave"))
                        .count());
        logger.info("The statistics about age to number of people with this age: " +
                persons.stream()
                        .collect(groupingBy(Person::getAge, counting())));
        try {
            String topCityByPopulation = persons.stream()
                    .map(Person::getCity)
                    .collect(groupingBy(identity(), counting()))
                    .entrySet().stream()
                    .max(comparing(Map.Entry::getValue))
                    .map(Map.Entry::getKey)
                    .orElseThrow(IllegalArgumentException::new);
            logger.info("Top city by population is " +
                    topCityByPopulation);
        } catch (IllegalArgumentException e) {
            logger.error("Empty list of persons");
        }
        logger.info("Average adults age per city is: " +
                persons.stream()
                        .filter(person -> person.getAge() > 17)
                        .collect(groupingBy(Person::getCity, averagingInt(Person::getAge))));
    }
}
