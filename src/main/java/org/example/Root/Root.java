package org.example.Root;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.Tickets.Ticket;

import java.util.List;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Root
{
        private List<Ticket> tickets;
}

