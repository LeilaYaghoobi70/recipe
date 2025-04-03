package app.google.common.network


class Endpoint(val path: String, val parameters: Map<String, String>? = null) {
    val url: String get() = NetworkConfig.BASE_URL + path
}