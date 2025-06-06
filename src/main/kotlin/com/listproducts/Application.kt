package com.listproducts

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["adapter", "application", "domain", "infra", "com"])
class Application

fun main() {
    runApplication<Application>()
}