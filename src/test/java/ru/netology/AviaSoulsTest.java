package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void shouldSortByPrice() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "UFA", 1_500, 8, 12);
        Ticket ticket2 = new Ticket("MSK", "KZN", 2_000, 9, 11);
        Ticket ticket3 = new Ticket("MSK", "KZN", 3_500, 10, 12);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1_800, 11, 13);
        Ticket ticket5 = new Ticket("MSK", "UFA", 5_000, 12, 15);
        Ticket ticket6 = new Ticket("MSK", "KZN", 3_500, 13, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 4_500, 13, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("MSK", "KZN");
        Ticket[] expected = {ticket2, ticket3, ticket6};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "UFA", 1_500, 8, 12);
        Ticket ticket2 = new Ticket("MSK", "KZN", 2_000, 9, 11);
        Ticket ticket3 = new Ticket("MSK", "KZN", 3_500, 10, 12);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1_800, 11, 13);
        Ticket ticket5 = new Ticket("MSK", "UFA", 5_000, 12, 15);
        Ticket ticket6 = new Ticket("MSK", "KZN", 3_500, 13, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 4_500, 13, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("MSK", "SPB");
        Ticket[] expected = {ticket7};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNoTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "UFA", 1_500, 8, 12);
        Ticket ticket2 = new Ticket("MSK", "KZN", 2_000, 9, 11);
        Ticket ticket3 = new Ticket("MSK", "KZN", 3_500, 10, 12);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1_800, 11, 13);
        Ticket ticket5 = new Ticket("MSK", "UFA", 5_000, 12, 15);
        Ticket ticket6 = new Ticket("MSK", "KZN", 3_500, 13, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 4_500, 13, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("SPB", "MSK");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "UFA", 1_500, 8, 12);
        Ticket ticket2 = new Ticket("MSK", "KZN", 2_000, 9, 11);
        Ticket ticket3 = new Ticket("MSK", "KZN", 3_500, 10, 12);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1_800, 11, 13);
        Ticket ticket5 = new Ticket("MSK", "UFA", 5_000, 12, 15);
        Ticket ticket6 = new Ticket("MSK", "KZN", 3_500, 13, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 4_500, 13, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("MSK", "UFA", comparator);
        Ticket[] expected = {ticket4, ticket5, ticket1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortOneTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "UFA", 1_500, 8, 12);
        Ticket ticket2 = new Ticket("MSK", "KZN", 2_000, 9, 11);
        Ticket ticket3 = new Ticket("MSK", "KZN", 3_500, 10, 12);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1_800, 11, 13);
        Ticket ticket5 = new Ticket("MSK", "UFA", 5_000, 12, 15);
        Ticket ticket6 = new Ticket("MSK", "KZN", 3_500, 13, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 4_500, 13, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("MSK", "SPB", comparator);
        Ticket[] expected = {ticket7};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortNoTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "UFA", 1_500, 8, 12);
        Ticket ticket2 = new Ticket("MSK", "KZN", 2_000, 9, 11);
        Ticket ticket3 = new Ticket("MSK", "KZN", 3_500, 10, 12);
        Ticket ticket4 = new Ticket("MSK", "UFA", 1_800, 11, 13);
        Ticket ticket5 = new Ticket("MSK", "UFA", 5_000, 12, 15);
        Ticket ticket6 = new Ticket("MSK", "KZN", 3_500, 13, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 4_500, 13, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("SPB", "MSK", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}