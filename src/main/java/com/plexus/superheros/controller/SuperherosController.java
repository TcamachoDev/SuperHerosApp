package com.plexus.superheros.controller;

import static com.plexus.superheros.constants.Constants.ID;
import static com.plexus.superheros.constants.Constants.URL_SUPERHEROE;

import com.plexus.superheros.entity.Superhero;
import com.plexus.superheros.service.SuperherosService;
import java.util.List;
import java.util.Optional;
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
public class SuperherosController {

  @Autowired
  SuperherosService superherosService;

  @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<List<Superhero>> getAllSuperheros() {
    return new ResponseEntity<>(superherosService.getAllSuperheros(), HttpStatus.OK);
  }

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Superhero> saveSuperhero(@RequestBody Superhero superhero){
    return new ResponseEntity<>(superherosService.saveHero(superhero), HttpStatus.CREATED);
  }

  @GetMapping( path = ID,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Optional<Superhero>> getSuperhero(@PathVariable("id") Long id){
    return new ResponseEntity<>(superherosService.findSuperheroById(id), HttpStatus.OK);
  }

  @PutMapping(path = ID,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Superhero> modifySuperhero(@PathVariable("id") Long id, @RequestBody Superhero superhero){
    return new ResponseEntity<>(superherosService.modifySuperhero(id, superhero), HttpStatus.OK);
  }

  @DeleteMapping(path = "delete/{id}",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public ResponseEntity<Superhero> deleteSuperhero(@PathVariable("id") Long id){
    boolean response = superherosService.deleteSuperhero(id);
    if(response){
      return new ResponseEntity<>(HttpStatus.OK);
    }else{
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping( path = "findByName/{name}",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<List<Superhero>> findByName(@PathVariable("name") String name){
    return new ResponseEntity<>(superherosService.findByName(name), HttpStatus.OK);
  }
}
