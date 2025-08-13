package org.example;

import redis.clients.jedis.Jedis;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.io.PrintStream;
import java.util.List;

public class CityTicketPrices {
    private static final String ZSET_CITIES = "CitiesByTicketPrice";

    public static void calculate() {

        // Устанавливаем кодировку UTF-8 для вывода
        System.setOut(new PrintStream(System.out, true));
        // Connect to Redis
        Jedis jedis = new Jedis("localhost", 6379);

        // Clear existing data in case of re-run
        jedis.del(ZSET_CITIES);

        // Adding cities with hypothetical ticket prices (in rubles) on 2.08.2025 on aviasales.ru
        jedis.zadd(ZSET_CITIES, 2429, "Moscow Москва");
        jedis.zadd(ZSET_CITIES, 7659, "Adler Адлер");
        jedis.zadd(ZSET_CITIES, 39959, "Singapour Сингапур");
        jedis.zadd(ZSET_CITIES, 37089, "London Лондон");
        jedis.zadd(ZSET_CITIES, 60861, "Tokio Токио");
        jedis.zadd(ZSET_CITIES, 26142, "Rome Рим");
        jedis.zadd(ZSET_CITIES, 28499, "Beijin Пекин");
        jedis.zadd(ZSET_CITIES, 110983, "Havana Гавана");
        jedis.zadd(ZSET_CITIES, 28802, "Shanhai Шанхай");
        jedis.zadd(ZSET_CITIES, 14205, "Antalia Анталья");

        System.out.println("List of cities Список городов:" + jedis.zrange(ZSET_CITIES, 0, -1));
        // Расположите их в порядке возрастания цены билета на самолёт из вашего города до города назначения.
        //  https://1drv.ms/b/c/5af23aa23b2f8246/EWbbkg3zthhDitIspSqGcgwB8KkBG3QtZ94E7Vi7hdaa5g?e=ItpYEf
        List<String> allCities = (List<String>)jedis.zrange(ZSET_CITIES, 0, -1);
        System.out.println("Расположите города в порядке возрастания цены билета на самолет:");
        System.out.println("Set cities in the order of the ascending order of the ticket price: ");
        allCities.forEach(city -> System.out.println(city + " - " + jedis.zscore(ZSET_CITIES, city) + " rub руб."));
        // Display all cities in ascending order of ticket price: Все города: " + allCities
        System.out.println("\nAll cities Все города: " + allCities);
        // Displaying the top 3 cheapest cities
        System.out.println("Топ-3 самых дешевых путешествий:");
        System.out.println("\nTop-3 cheapest trips:");
        List<String> cheapestCities = (List<String>)  jedis.zrange(ZSET_CITIES, 0, 2);
        cheapestCities.forEach(city -> System.out.println(city + " - " + jedis.zscore(ZSET_CITIES, city) + " rub руб."));

        // Displaying the top 3 most expensive cities
        System.out.println("\nТоп-3 самых дорогих путешествий:");
        System.out.println("\nTop-3 most expensive trips:");
        List<String> expensiveCities = (List<String>) jedis.zrevrange(ZSET_CITIES, 0, 2);
        expensiveCities.forEach(city -> System.out.println(city + " - " + jedis.zscore(ZSET_CITIES, city) + " rub руб."));

        // Close the Redis connection
        jedis.close();
    }

    //public void calculate() {

    //}
}

