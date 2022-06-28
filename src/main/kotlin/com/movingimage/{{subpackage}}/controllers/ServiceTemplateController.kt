package com.movingimage.`{{subpackage}}`.controllers

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ServiceTemplateController {
    companion object {
        private val logger = LoggerFactory.getLogger(ServiceTemplateController::class.java)
    }

    @GetMapping("/test")
    fun test() : String {
        logger.info("test endpoint reached")
        return "test"
    }
}