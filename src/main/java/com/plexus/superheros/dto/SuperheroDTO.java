package com.plexus.superheros.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class SuperheroDTO implements Serializable {
  private Long id;
  private String name;
  private String superpower;
}
