package dev.alexandreyoshimatsu.kotlinspring.exception

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message) {
}