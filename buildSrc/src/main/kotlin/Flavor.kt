enum class Flavor(
    val label: String,
    val dimension: Dimension,
    open val suffix: String? = null
) {
    Mock("mock", Dimension.BuildEnv) {
        override val suffix: String = ".$label"
    },
    Dev("dev", Dimension.BuildEnv) {
        override val suffix: String = ".$label"
    },
    Prd("prd", Dimension.BuildEnv),
}
