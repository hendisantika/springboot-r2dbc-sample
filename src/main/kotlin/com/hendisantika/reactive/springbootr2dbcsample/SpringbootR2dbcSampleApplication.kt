package com.hendisantika.reactive.springbootr2dbcsample

import com.hendisantika.reactive.springbootr2dbcsample.domain.Person
import com.hendisantika.reactive.springbootr2dbcsample.repository.PersonRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import reactor.core.publisher.Mono

@SpringBootApplication
class SpringbootR2dbcSampleApplication : CommandLineRunner {
    @Autowired
    private lateinit var personRepository: PersonRepository

    override fun run(vararg args: String?) {
        personRepository.saveAll(
                listOf(
                        Person(name = "Uzumaki Naruto", age = 25),
                        Person(name = "Uchiha Sasuke", age = 23)
                )
        ).log().subscribe()
        Thread.sleep(2000)
        personRepository.findAll().log().subscribe { log.info("findAll - $it") }
        personRepository.findAllById(Mono.just(1)).log().subscribe { log.info("findAllById - $it") }
        personRepository.findAllByName("Laura So").log().subscribe { log.info("findAllByName - $it") }
        personRepository.findAllByAge(25).log().subscribe { log.info("findAllByAge - $it") }
        Thread.sleep(5000)
    }

    private companion object {
        val log = LoggerFactory.getLogger(SpringbootR2dbcSampleApplication::class.java)
    }
}

fun main(args: Array<String>) {
    runApplication<SpringbootR2dbcSampleApplication>(*args)
}
