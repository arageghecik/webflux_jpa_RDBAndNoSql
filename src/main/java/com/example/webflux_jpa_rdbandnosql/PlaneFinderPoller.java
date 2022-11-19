package com.example.webflux_jpa_rdbandnosql;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@EnableScheduling
public class PlaneFinderPoller {
    private WebClient client = WebClient.create("http://localhost:7634/aircraft");

    public PlaneFinderPoller(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    private final AircraftRepository aircraftRepository;

    @Scheduled(fixedRate = 9000)
    private void pollPlanes() {
        //clear JPA repos all data
        aircraftRepository.deleteAll();
        //flux reactive data type
        //flux is publisher in reactive approach, we get data from webclient in flux form
        Flux<Aircraft> aircraftFlux = client.get().retrieve().bodyToFlux(Aircraft.class);

        //storing data to JPA repo
        aircraftFlux.filter(plane -> !plane.getReg().isEmpty())
                .toStream().forEach(aircraftRepository::save);

        // taking out data from JPA repo
        aircraftRepository.findAll().forEach(System.out::println);
    }

}
