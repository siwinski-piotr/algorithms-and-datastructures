rootProject.name = "Algorithms-and-data-structures"
include("src:main:numbers")
findProject(":src:main:numbers")?.name = "numbers"
include("src:main:arrays")
findProject(":src:main:arrays")?.name = "arrays"
include("src:main:trees")
findProject(":src:main:trees")?.name = "trees"

include("src:main:backtracking")

include("src:main:designPatterns")
findProject(":src:main:designPatterns")?.name = "designPatterns"
include("src:main:object-oriented-design")
findProject(":src:main:object-oriented-design")?.name = "object-oriented-design"
include("src:main:object-oriented-design:unix-file-system")
findProject(":src:main:object-oriented-design:unix-file-system")?.name = "unix-file-system"
