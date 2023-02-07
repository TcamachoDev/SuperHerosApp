package com.plexus.superheros.service;

import com.plexus.superheros.dto.SuperheroDTO;
import com.plexus.superheros.model.Superhero;
import java.util.List;
import java.util.Optional;

public interface SuperHerosService {

  SuperheroDTO saveHero(Superhero superhero);

  Optional<SuperheroDTO> findSuperheroById(Long id);

  SuperheroDTO modifySuperhero(SuperheroDTO superheroDTO);

  boolean deleteSuperhero (Long id);

  List<SuperheroDTO> getAllSuperheros();

  List<SuperheroDTO> findByName(String name);

}
