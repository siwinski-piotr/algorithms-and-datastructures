rootProject.name = "Algorithms-and-data-structures"
include("src:main:numbers")
findProject(":src:main:numbers")?.name = "numbers"
include("src:main:arrays")
findProject(":src:main:arrays")?.name = "arrays"
