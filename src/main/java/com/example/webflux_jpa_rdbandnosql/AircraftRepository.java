package com.example.webflux_jpa_rdbandnosql;

import org.springframework.data.repository.CrudRepository;

public interface AircraftRepository extends CrudRepository<Aircraft, Long> {
}