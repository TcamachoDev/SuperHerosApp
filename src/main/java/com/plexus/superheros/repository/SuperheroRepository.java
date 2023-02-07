package com.plexus.superheros.repository;

import com.plexus.superheros.entity.Superhero;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperheroRepository extends JpaRepository<Superhero, Long> {

  List<Superhero> findAllByNameContainsIgnoreCase(String name);
}
