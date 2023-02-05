package com.plexus.superheros.repository;

import com.plexus.superheros.entity.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperheroRepository extends JpaRepository<Superhero, Long> {

}
