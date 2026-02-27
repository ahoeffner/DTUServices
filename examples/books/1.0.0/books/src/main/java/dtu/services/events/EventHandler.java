package dtu.services.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dtu.services.api.model.Bog;
import org.springframework.stereotype.Component;
import dtu.services.library.config.events.DTUSubscriber;


@Component
public class EventHandler
{
    private static final Logger log = LoggerFactory.getLogger(EventHandler.class);


    @DTUSubscriber("new-book")
    public void newbook(Bog bog)
    {
        log.info("Received new book event: " + bog);
    }
}
