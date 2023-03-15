package org.example.Main;

import org.example.GsonParser.GsonParser;
import org.example.Root.Root;
import org.example.Tickets.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String ... args){
        GsonParser parser = new GsonParser();

        Root root = parser.parser("src/main/resources/tickets.json");

        ArrayList<Integer> array = new ArrayList<>();

        for (Ticket tickets : root.getTickets()){
            array.add(flightTime(tickets));
        }

        System.out.println("Cреднее время полета между городами Владивосток и Тель-Авив " + Duration.ofMinutes(averageTime(array)));

        System.out.println("90-й процентиль времени полета между городами  Владивосток и Тель-Авив " + Duration.ofMinutes(percentile(array, 90)));
    }

    public static int averageTime(List<Integer> array){
        int value = array.stream().mapToInt(a -> a).sum()/(array.size());
        return  value;
    }

    public static int percentile(List<Integer> array, double percentile) {
        Collections.sort(array);
        int i = (int) Math.ceil(percentile / 100.0 * array.size());
        return array.get(i - 1);
    }

    public static int flightTime (Ticket tickets){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "dd.MM.uu H:mm" );

        String input1 = tickets.getArrivalDate() + " " + tickets.getDepartureTime();
        LocalDateTime ldt = LocalDateTime.parse(input1 , formatter);

        ZoneId zon1 = ZoneId.of("Asia/Vladivostok");
        ZonedDateTime zdt1 = ldt.atZone(zon1);

        String input2 = tickets.getArrivalDate() + " " + tickets.getArrivalTime();
        LocalDateTime ldt2 = LocalDateTime.parse(input2 , formatter);

        ZoneId zon2 = ZoneId.of("Etc/GMT-3");
        ZonedDateTime zdt2 = ldt2.atZone(zon2);

        return (int) ChronoUnit.MINUTES.between(zdt1, zdt2);
    }
}


