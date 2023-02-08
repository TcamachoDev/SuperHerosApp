package com.plexus.superheros.service

import com.plexus.superheros.dto.SuperheroDTO
import com.plexus.superheros.mappers.SuperheroMapper
import com.plexus.superheros.model.Superhero
import com.plexus.superheros.repository.SuperHeroRepository
import com.plexus.superheros.service.impl.SuperHerosServiceImpl
import spock.lang.Specification

class SuperHerosServiceSpec extends Specification {

    def repository = Mock(SuperHeroRepository)
    def mapper = Mock(SuperheroMapper)
    def service = new SuperHerosServiceImpl(repository as SuperHeroRepository, mapper)

    def 'setup'() {
        service.superheroRepository.metaClass = repository as MetaClass
        service.superheroMapper.metaClass = mapper as MetaClass
    }

    def 'test findAll - OK'() {
        given: 'Initialize prerequisites'
        def listDTos = new ArrayList<SuperheroDTO>()
        def hero1 = new SuperheroDTO()
        def hero2 = new Superhero()

        hero1.setId(1L)
        hero1.setName("test")
        hero1.setSuperpower("test")
        listDTos.add(hero1)

        def listEntities = new ArrayList<Superhero>()
        hero2.setId(1L)
        hero2.setName("test")
        hero2.setSuperpower("test")
        listEntities.add(hero2)

        when: 'Calling findAll'
        def result = service.getAllSuperheros()

        then: 'Expected results'
        1 * repository.findAll() >> listEntities
        1 * mapper.toDto(_) >> listDTos
        result != null
    }

    def 'test findSuperheroById - OK'() {
        given: 'Initialize prerequisites'
        def id = 1L
        def hero1 = new SuperheroDTO()
        def hero2 = new Superhero()

        hero1.setId(1L)
        hero1.setName("test")
        hero1.setSuperpower("test")

        hero2.setId(1L)
        hero2.setName("test")
        hero2.setSuperpower("test")

        when: 'Calling findSuperheroById'
        def result = service.findSuperheroById(id)

        then: 'Expected results'
        1 * repository.findById(_) >> Optional.of(hero2)
        1 * mapper.toDto(_) >> hero1
        result != null
    }

    def 'test saveHero - OK'() {
        given: 'Initialize prerequisites'
        def hero1 = new SuperheroDTO()
        def hero2 = new Superhero()

        hero1.setId(1L)
        hero1.setName("test")
        hero1.setSuperpower("test")

        hero2.setId(1L)
        hero2.setName("test")
        hero2.setSuperpower("test")

        when: 'Calling saveHero'
        def result = service.saveHero(hero2)

        then: 'Expected results'
        1 * repository.save(_) >> hero2
        1 * mapper.toDto(_) >> hero1
        result != null
    }

    def 'test modifySuperhero - OK'() {
        given: 'Initialize prerequisites'
        def hero1 = new SuperheroDTO()
        def hero2 = new Superhero()

        hero1.setId(1L)
        hero1.setName("test")
        hero1.setSuperpower("test")

        hero2.setId(1L)
        hero2.setName("test")
        hero2.setSuperpower("test")

        when: 'Calling modifySuperhero'
        def result = service.modifySuperhero(hero1)

        then: 'Expected results'
        1 * repository.save(_) >> hero2
        1 * mapper.toDto(_) >> hero1
        result != null
    }

    def 'test deleteSuperhero - OK'() {
        given: 'Initialize prerequisites'
        def id = 1L

        when: 'Calling deleteSuperhero'
        service.deleteSuperhero(id)

        then: 'Expected results'
        1 * repository.deleteById(_) >> false
    }

    def 'test findByName - OK'() {
        given: 'Initialize prerequisites'
        def listDTos = new ArrayList<SuperheroDTO>()
        def hero1 = new SuperheroDTO()
        def hero2 = new Superhero()
        def name = "te"

        hero1.setId(1L)
        hero1.setName("test")
        hero1.setSuperpower("test")
        listDTos.add(hero1)

        def listEntities = new ArrayList<Superhero>()
        hero2.setId(1L)
        hero2.setName("test")
        hero2.setSuperpower("test")
        listEntities.add(hero2)

        when: 'Calling findByName'
        def result = service.findByName(name)

        then: 'Expected results'
        1 * repository.findAllByNameContainsIgnoreCase(name) >> listEntities
        1 * mapper.toDto(_) >> listDTos
        result != null
    }
}
