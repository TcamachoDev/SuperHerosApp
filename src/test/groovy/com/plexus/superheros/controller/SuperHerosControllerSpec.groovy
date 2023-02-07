package com.plexus.superheros.controller

import com.plexus.superheros.SuperHerosController
import com.plexus.superheros.dto.SuperheroDTO
import com.plexus.superheros.service.SuperHerosService
import spock.lang.Specification

class SuperHerosControllerSpec extends Specification {
    def controller = new SuperHerosController()
    def service = Mock(SuperHerosService)

    def 'setup'() {
        controller.superherosService = service
    }

    def 'test getAllSuperheros'() {
        given: 'Initialize prerequisites'
        def resultList = Mock(List)

        when: 'Calling getAllSuperheros'
        def result = controller.getAllSuperheros()

        then: 'Expected results'
        result != null
        1 * service.getAllSuperheros() >> resultList
    }

    def 'test findById'() {
        given: 'Initialize prerequisites'
        def id = 1L

        when: 'Calling findById'
        def result = controller.findById(id)

        then: 'Expected results'
        result != null
        1 * service.findSuperheroById(_) >> Optional.of(new SuperheroDTO())
    }

    def 'test modifySuperhero'() {
        given: 'Initialize prerequisites'
        def superHero = new SuperheroDTO()

        when: 'Calling modifySuperhero'
        def result = controller.modifySuperhero(superHero)

        then: 'Expected results'
        result != null
        1 * service.modifySuperhero(_) >> superHero
    }

    def 'test deleteSuperhero'() {
        given: 'Initialize prerequisites'
        def id = 1L

        when: 'Calling deleteSuperhero'
        def result = controller.deleteSuperhero(id)

        then: 'Expected results'
        result != null
        1 * service.deleteSuperhero(_) >> true
    }

    def 'test findByName'() {
        given: 'Initialize prerequisites'
        def name = "man"
        def resultList = Mock(List)

        when: 'Calling findByName'
        def result = controller.findByName(name)

        then: 'Expected results'
        result != null
        1 * service.findByName(_) >> resultList
    }

//    def 'test createdSuperhero'() {
//        given: 'Initialize prerequisites'
//        def superHero = new Superhero()
//        superHero.setId(1L)
//        superHero.setName("test")
//        superHero.setSuperpower("test")
//
//        when: 'Calling createdSuperhero'
//        def result = controller.createdSuperhero(superHero)
//
//        then: 'Expected results'
//        result != null
//        1 * service.saveHero(_) >> new Superhero()
//    }
}
