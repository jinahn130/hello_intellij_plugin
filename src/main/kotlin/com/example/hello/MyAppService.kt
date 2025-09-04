package com.example.hello

import com.intellij.openapi.components.Service
import java.time.Instant

@Service(Service.Level.APP)
class MyAppService {
    private val startedAt: Instant = Instant.now()

    fun greet(): String = "AppService started at $startedAt"
}
