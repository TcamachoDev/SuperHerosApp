package com.plexus.superheros.service;

import com.plexus.superheros.entity.Superhero;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface SuperherosService {

  Superhero saveHero(Superhero superhero);

  Optional<Superhero> findSuperheroById(Long id);

  Superhero modifySuperhero(Long id, Superhero superhero);

  boolean deleteSuperhero (Long id);

  List<Superhero> getAllSuperheros();
}
