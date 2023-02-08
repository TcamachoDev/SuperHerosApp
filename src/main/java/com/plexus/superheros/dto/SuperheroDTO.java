package com.plexus.superheros.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SuperheroDTO implements Serializable {
  private Long id;
  private String name;
  private String superpower;

  public SuperheroDTO(SuperheroDTO superheroDTO){
    this.id = superheroDTO.getId();
    this.name = superheroDTO.getName();
    this.superpower = superheroDTO.getSuperpower();
  }

}
