rootProject.name = "Algorithms-and-data-structures"
// Numbers module
include("src:main:numbers")
findProject(":src:main:numbers")?.name = "numbers"

// Arrays module
include("src:main:arrays")
findProject(":src:main:arrays")?.name = "arrays"

// Trees module
include("src:main:trees")
findProject(":src:main:trees")?.name = "trees"

// Backtracking module
include("src:main:backtracking")

// Design patterns module
include("src:main:designPatterns")
findProject(":src:main:designPatterns")?.name = "designPatterns"

// Object oriented design module
include("src:main:object-oriented-design")
findProject(":src:main:object-oriented-design")?.name = "object-oriented-design"

// OOD -> Unix file system search module
include("src:main:object-oriented-design:unix-file-system")
findProject(":src:main:object-oriented-design:unix-file-system")?.name = "unix-file-system"

// CSES.fi tasks
include("src:main:cses")
findProject(":src:main:cses")?.name = "cses"
include("src:main:object-oriented-design:parking-lot")
include("src:main:bits-integers-primitive-types")