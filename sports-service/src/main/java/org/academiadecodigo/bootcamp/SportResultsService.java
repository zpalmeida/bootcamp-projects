package org.academiadecodigo.bootcamp;

import java.util.ArrayList;
import java.util.Collection;

public class SportResultsService {

    private Collection<Client> clients = new ArrayList<>();

    public void addSubscriber(Client client) {

        if(!clients.contains(client)) {
            clients.add(client);
        }
    }

    public void removeSubscriber(Client client) {

        clients.remove(client);
    }

    public void send(Message message) {

        for(Client client : clients) {
            client.receive(message);
        }
    }
}
