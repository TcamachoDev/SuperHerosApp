package com.plexus.superheros.service.impl;

import com.plexus.superheros.entity.Superhero;
import com.plexus.superheros.repository.SuperheroRepository;
import com.plexus.superheros.service.SuperherosService;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SuperherosServiceImpl implements SuperherosService {

  private final SuperheroRepository superheroRepository;

  @Override
  public Superhero saveHero(Superhero superhero) {
    return superheroRepository.save(superhero);
  }

  @Override
  public Optional<Superhero> findSuperheroById(Long id) {
    return Optional.ofNullable(
        superheroRepository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new EntityNotFoundException();
                }));
  }

  @Override
  public Superhero modifySuperhero(Long id, Superhero superhero) {
    Superhero modifySuperhero = superheroRepository.findById(id).orElseThrow(
        EntityNotFoundException::new);
      modifySuperhero.setName(superhero.getName());
      modifySuperhero.setSuperpower(superhero.getSuperpower());
      return superheroRepository.save(modifySuperhero);
  }

  @Override
  public boolean deleteSuperhero(Long id) {
    try {
      superheroRepository.deleteById(id);
      return Boolean.TRUE;
    } catch (Exception e) {
      return Boolean.FALSE;
    }
  }
}
