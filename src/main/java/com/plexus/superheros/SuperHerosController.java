package com.plexus.superheros;

import static com.plexus.superheros.constants.Constants.SWG_CREATE;
import static com.plexus.superheros.constants.Constants.SWG_DELETE;
import static com.plexus.superheros.constants.Constants.SWG_FIND_ALL;
import static com.plexus.superheros.constants.Constants.SWG_FIND_BY_ID;
import static com.plexus.superheros.constants.Constants.SWG_FIND_BY_NAME;
import static com.plexus.superheros.constants.Constants.SWG_UPDATE;
import static com.plexus.superheros.constants.Constants.URL_SUPERHEROE;

import com.plexus.superheros.util.ResponseUtil;
import com.plexus.superheros.dto.SuperheroDTO;
import com.plexus.superheros.model.Superhero;
import com.plexus.superheros.service.SuperHerosService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(URL_SUPERHEROE)
@Tag(name = "SuperHeros API", description = "CRUD the superheros")
public class SuperHerosController {

  @Autowired private SuperHerosService superherosService;

  @GetMapping(
      path = SWG_FIND_ALL,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public List<SuperheroDTO> getAllSuperheros() {
    return superherosService.getAllSuperheros();
  }

  @PostMapping(
      path = SWG_CREATE,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<SuperheroDTO> createdSuperhero(@RequestBody Superhero superhero) {
    return ResponseEntity.ok().body(superherosService.saveHero(superhero));
  }

  @GetMapping(
      path = SWG_FIND_BY_ID,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<SuperheroDTO> findById(@PathVariable("id") Long id) {
    return ResponseUtil.wrapOrNotFound(superherosService.findSuperheroById(id));
  }

  @PutMapping(
      path = SWG_UPDATE,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<SuperheroDTO> modifySuperhero(@RequestBody SuperheroDTO superhero) {
    return new ResponseEntity<>(superherosService.modifySuperhero(superhero), HttpStatus.OK);
  }

  @DeleteMapping(
      path = SWG_DELETE,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public ResponseEntity<SuperheroDTO> deleteSuperhero(@PathVariable("id") Long id) {
    boolean response = superherosService.deleteSuperhero(id);
    if (response) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(
      path = SWG_FIND_BY_NAME,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public List<SuperheroDTO> findByName(@PathVariable("name") String name) {
    return superherosService.findByName(name);
  }
}
