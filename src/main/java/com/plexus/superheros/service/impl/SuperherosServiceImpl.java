package com.plexus.superheros.service.impl;

import com.plexus.superheros.entity.Superhero;
import com.plexus.superheros.repository.SuperheroRepository;
import com.plexus.superheros.service.SuperherosService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service("superHeroesService")
public class SuperherosServiceImpl implements SuperherosService {

  @Autowired SuperheroRepository superheroRepository;

  @Override
  public Superhero saveHero(Superhero superhero) {
    log.info("Save New super Hero : " + superhero.toString());
    return superheroRepository.save(superhero);
  }

  @Override
  public Optional<Superhero> findSuperheroById(Long id) {
    log.info("Find by Id Super Hero : " + id);
    return Optional.ofNullable(
        superheroRepository
            .findById(id)
            .orElseThrow(
                () -> {
                  log.error("Entity not found");
                  throw new EntityNotFoundException();
                }));
  }

  @Override
  public Superhero modifySuperhero(Long id, Superhero superhero) {
    Superhero modifySuperhero = superheroRepository.findById(id).orElseThrow(
        EntityNotFoundException::new);
      modifySuperhero.setName(superhero.getName());
      modifySuperhero.setSuperpower(superhero.getSuperpower());
    log.info("Modified Super Hero : " + modifySuperhero);
      return superheroRepository.save(modifySuperhero);
  }

  @Override
  public boolean deleteSuperhero(Long id) {
    try {
      superheroRepository.deleteById(id);
      log.info("Delete Superhero whit id: " + id);
      return Boolean.TRUE;
    } catch (Exception e) {
      log.error(e.getLocalizedMessage());
      return Boolean.FALSE;
    }
  }

  @Override
  public List<Superhero> getAllSuperheros() {
    return superheroRepository.findAll();
  }

}
