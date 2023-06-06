plugins {
    kotlin("jvm") version "1.6.0" apply false
    id("gg.essential.multi-version.root")
}

preprocess {
    val forge10809 = createNode("1.8.9-forge", 10809, "srg")
    val forge10904 = createNode("1.9.4-forge", 10904, "srg")
    val forge11002 = createNode("1.10.2-forge", 11002, "srg")
    val forge11102 = createNode("1.11.2-forge", 11102, "srg")
    val forge11202 = createNode("1.12.2-forge", 11202, "srg")
    val forge11502 = createNode("1.15.2-forge", 11502, "srg")
    val forge11605 = createNode("1.16.5-forge", 11605, "official")
    val forge11701 = createNode("1.17.1-forge", 11701, "official")
    val forge11802 = createNode("1.18.2-forge", 11802, "official")
    val forge11902 = createNode("1.19.2-forge", 11902, "official")
    val forge11904 = createNode("1.19.4-forge", 11904, "official")

    val fabric11605 = createNode("1.16.5-fabric", 11605, "official")
    val fabric11701 = createNode("1.17.1-fabric", 11701, "official")
    val fabric11802 = createNode("1.18.2-fabric", 11802, "official")
    val fabric11902 = createNode("1.19.2-fabric", 11902, "official")
    val fabric11904 = createNode("1.19.4-fabric", 11904, "official")

    forge10904.link(forge10809)
    forge11002.link(forge10904)
    forge11102.link(forge11002)
    forge11202.link(forge11102)
    forge11502.link(forge11202)
    forge11605.link(forge11502)
    forge11701.link(forge11605)
    forge11802.link(forge11701)
    forge11902.link(forge11802)
    forge11904.link(forge11902)

    fabric11605.link(forge11605)
    fabric11701.link(fabric11605)
    fabric11802.link(fabric11701)
    fabric11902.link(fabric11802)
    fabric11904.link(fabric11902)
}