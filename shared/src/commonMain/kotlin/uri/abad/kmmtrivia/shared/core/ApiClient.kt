package uri.abad.kmmtrivia.shared.core

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.observer.*
import io.ktor.http.cio.*

val client = HttpClient(CIO) {
    Json {
        serializer = KotlinxSerializer()
    }

    ResponseObserver { response ->
        println("HTTP status: ${response.status.value}")
    }
}
