package com.hendisantika.reactive.springbootr2dbcsample.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-r2dbc-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-02-23
 * Time: 06:13
 */
@Table("people")
data class Person(
        @Id val id: Int? = null,
        val name: String,
        val age: Int
)