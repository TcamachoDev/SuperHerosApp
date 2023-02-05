package com.plexus.superheros.service.impl;

import com.plexus.superheros.entity.Superhero;
import com.plexus.superheros.repository.SuperheroRepository;
import com.plexus.superheros.service.SuperherosService;
import java.util.Optional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SuperherosServiceImpl implements SuperherosService {

  private final SuperheroRepository superheroRepository;

  @Override
  public Superhero saveHero(Superhero superhero) {
    return null;
  }

  @Override
  public Optional<Superhero> findSuperheroById(Long id) {
    return Optional.empty();
  }

  @Override
  public Superhero modifySuperhero(Long id, Superhero superhero) {
    return null;
  }

  @Override
  public boolean deleteSuperhero(Long id) {
    return false;
  }
}
