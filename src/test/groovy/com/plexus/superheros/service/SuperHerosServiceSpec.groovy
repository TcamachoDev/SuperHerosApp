package com.plexus.superheros.service

import com.plexus.superheros.SuperHerosController
import com.plexus.superheros.dto.SuperheroDTO
import com.plexus.superheros.service.impl.SuperHerosServiceImpl
import spock.lang.Specification

class SuperHerosServiceSpec extends Specification {

    def service = new SuperHerosServiceImpl()
    def repository = Mock(SuperHeroRepository)

    def 'setup'() {
        service.superheroRepository = repository
    }

    def 'test findAll - OK'() {
        given: 'Initialize prerequisites'

        when: 'Calling findPaginated'
        service.getAllSuperheros()

        then: 'Expected results'
        1 * repository.findAll()
    }
}
