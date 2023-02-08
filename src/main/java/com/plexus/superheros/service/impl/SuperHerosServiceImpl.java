package com.plexus.superheros.service.impl;

import com.plexus.superheros.dto.SuperheroDTO;
import com.plexus.superheros.mappers.SuperheroMapper;
import com.plexus.superheros.model.Superhero;
import com.plexus.superheros.repository.SuperHeroRepository;
import com.plexus.superheros.service.SuperHerosService;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SuperHerosServiceImpl implements SuperHerosService {
  private final SuperHeroRepository superheroRepository;
  private final SuperheroMapper superheroMapper;

  @Override
  public SuperheroDTO saveHero(Superhero superhero) {
    log.info("Save New super Hero : " + superhero.toString());
    return superheroMapper.toDto(superheroRepository.save(superhero));
  }

  @Override
  public Optional<SuperheroDTO> findSuperheroById(Long id) {
    log.info("Find by Id Super Hero : " + id);
    return superheroRepository.findById(id).map(superheroMapper::toDto);
  }

  @Override
  public SuperheroDTO modifySuperhero(SuperheroDTO superheroDTO) {
    Superhero superheroModify = superheroRepository.save(superheroMapper.toEntity(superheroDTO));
    log.info("Modified Super Hero : " + superheroModify);
    return superheroMapper.toDto(superheroModify);
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
  public List<SuperheroDTO> getAllSuperheros() {
    return superheroRepository.findAll().stream()
        .map(superheroMapper::toDto)
        .collect(Collectors.toCollection(LinkedList::new));
  }

  @Override
  public List<SuperheroDTO> findByName(String name) {
    return superheroRepository.findAllByNameContainsIgnoreCase(name).stream()
        .map(superheroMapper::toDto)
        .collect(Collectors.toCollection(LinkedList::new));
  }
}
