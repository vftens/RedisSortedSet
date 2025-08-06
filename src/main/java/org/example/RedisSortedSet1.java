package org.example;

/*
 23.5 Практическая работа №2
        Задание №1
        Цель задания

        Научиться работать с сортированным множеством в Redis.

        Что нужно сделать

        Создайте Redis Sorted Set, сохраните туда список из 10 городов, которые хотели бы посетить
        в путешествие из Петербурга (например: Петербурга - Москва, Адлер, Сингапур, Лондон, Токио, Рим, Пекин, Гавана, Пхеньян, Анталья.)
        Расположите их в порядке возрастания цены билета на самолёт из вашего города до города назначения.
        Выведите топ-3 самых дешевых и самых дорогих путешествий.
        Пришлите скриншот консоли с добавлением городов и их сортировкой, загрузив файл в форму ответа.
        Критерии оценки

        «Зачёт» — скриншот с выполненными командами приложен к ответу.
        «Незачёт» — задание не выполнено.
        Please write a Java code, code:

   //
        To complete the assignment focused on working with Redis Sorted Sets in Java, we'll create a Java program that interacts with Redis to store a list of cities with corresponding ticket prices. Then we will retrieve and display the top three cheapest and the most expensive flights.

        To achieve this, follow the steps below to set up your environment and execute the program.

        ### Step-by-Step Guide

        1. **Prerequisites**:
        - Ensure that Redis is installed and running. You can download and install it from [Redis.io](https://redis.io/download).
        - Set up a Java development environment. You could use IntelliJ IDEA, Eclipse, or any IDE that supports Java.

        2. **Add Jedis Dependency**:
        If you are using Maven, add the following dependency to your `pom.xml` to include the Jedis library, which is a Java client for Redis:

        <dependency>
        <groupId>redis.clients</groupId>
        <artifactId>jedis</artifactId>
        <version>4.0.1</version> <!-- Check for the latest version -->
        </dependency>

        GPTNeuralBot, [01.08.2025 16:38]
        3. **Java Code**:
        Below is the complete Java code that creates a Redis Sorted Set, adds cities with their corresponding ticket prices, and retrieves
        the desired information.


 */
