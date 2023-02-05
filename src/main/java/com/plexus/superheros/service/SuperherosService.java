package com.plexus.superheros.service;

import com.plexus.superheros.entity.Superhero;
import java.util.Optional;

public interface SuperherosService {

  Superhero saveHero(Superhero superhero);

  Optional<Superhero> findSuperheroById(Long id);

  Superhero modifySuperhero(Long id, Superhero superhero);

  boolean deleteSuperhero (Long id);

}
