package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.addAll;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets;

    public TicketOffice(Long amount, List<Ticket> tickets) {
        this.amount = amount;
        this.tickets = new ArrayList<>(tickets);
    }

    public Ticket getTicket() {
        return tickets.removeFirst();
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
