package org.academiadecodigo.bootcamp;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class SportResultsServiceTest {

    SportResultsService sportResults = new SportResultsService();
    Client client1 = mock(Client.class, "client1");
    Client client2 = mock(Client.class, "client2");
    Message message = mock(Message.class);

    @Test
    public void subscribedClientShouldReceiveMessage() {

        //exercise
        sportResults.addSubscriber(client1);
        sportResults.send(message);

        //verification
        verify(client1).receive(message);
    }

    @Test
    public void messageShouldBeSentToAllSubscribedClients() {

        //exercise
        sportResults.addSubscriber(client1);
        sportResults.addSubscriber(client2);
        sportResults.send(message);

        //verification
        verify(client1).receive(message);
        verify(client2).receive(message);
    }

    @Test
    public void notSubscribedClientShouldNotReceiveMessage() {

        //exercise
        sportResults.addSubscriber(client1);
        sportResults.removeSubscriber(client1);
        sportResults.send(message);

        //verification
        verify(client1, never()).receive(message);
    }

    @Test
    public void shouldSendOnlyOneMessageToMultiSubscriber() {

        //exercise
        sportResults.addSubscriber(client1);
        sportResults.addSubscriber(client1);
        sportResults.send(message);

        //verification
        verify(client1, times(1)).receive(message);
    }
}
