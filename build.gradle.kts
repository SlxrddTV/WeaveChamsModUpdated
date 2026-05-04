plugins {
    kotlin("jvm") version "2.3.0"
    id("net.weavemc.gradle") version "1.1.0"
}

group = "me.tryfle.chams"
version = "1.1"

weave {
    configure {
        name = "WeaveChamsMod"
        modId = "weavechams"
        entryPoints = listOf("me.tryfle.chams.Main")
        mcpMappings()
    }
    version("1.8.9")
}

repositories {
    mavenCentral()
    maven("https://repo.spongepowered.org/maven/")
}

dependencies {
    compileOnly(files("C:\\Users\\Kalairna\\Pictures\\Weave-Loader-1.1.0\\Weave-Loader-1.1.0\\api\\build\\libs\\weave-api.jar"))
    compileOnly(files("C:\\Users\\Kalairna\\Pictures\\Weave-Loader-1.1.0\\Weave-Loader-1.1.0\\api\\v1_8\\build\\libs\\weave-v1_8.jar"))
}

kotlin {
    jvmToolchain(8)
}
