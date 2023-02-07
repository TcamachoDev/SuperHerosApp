package com.plexus.superheros.mappers;

import com.plexus.superheros.model.Superhero;
import com.plexus.superheros.dto.SuperheroDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface SuperheroMapper extends EntityMapper<SuperheroDTO, Superhero> {

}
