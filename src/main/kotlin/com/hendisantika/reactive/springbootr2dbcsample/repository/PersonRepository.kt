package com.hendisantika.reactive.springbootr2dbcsample.repository

import com.hendisantika.reactive.springbootr2dbcsample.domain.Person
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.r2dbc.repository.query.Query
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-r2dbc-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-02-23
 * Time: 06:15
 */
@Repository
interface PersonRepository : R2dbcRepository<Person, Int> {

    @Query("SELECT * FROM people WHERE name = $1")
    fun findAllByName(name: String): Flux<Person>

    @Query("SELECT * FROM people WHERE age = $1")
    fun findAllByAge(age: Int): Flux<Person>
}