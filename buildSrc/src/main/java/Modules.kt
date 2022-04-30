/**
 * @created 30-04-2022 05:53
 * @author yoviekaputra
 * @project eFishery
 **/

object Modules {

    const val database = ":database"

    object Core {
        const val network = ":core:network"
        const val abstractions = ":core:abstractions"
        const val themes = ":core:themes"
    }

    object Features {
        const val home = ":features:home"
        const val syncronize = ":features:syncronize"
    }
}