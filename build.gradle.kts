plugins {
    id("fabric-mod-conventions")
}

version = project.property("mod_version") as String
group = project.property("maven_group") as String

base {
    archivesName.set(project.property("archives_base_name") as String)
}

dependencies {
    // To change the versions see the gradle/libs.versions.toml file
    minecraft(libs.minecraft)
    mappings(loom.officialMojangMappings())
    modImplementation(libs.fabric.loader)

    // Fabric API. This is technically optional, but you probably want it anyway.
    modImplementation(libs.fabric.api)
    modImplementation(libs.cobblemon.fabric)
    modImplementation(libs.gooeylibs.fabric)
    modImplementation(fileTree("libs") {
        include("CobbledOutBreaks-1.0.2-SNAPSHOT.jar")
    })
}
