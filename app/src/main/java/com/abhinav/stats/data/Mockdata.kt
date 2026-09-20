package com.abhinav.stats.data
object MockData {
    val userStats = UserStats(
        globalRank = "#42,108",
        topPercentage = "Top 6.4% in Weekly Contests",
        totalSolved = 782,
        totalProblems = 3120,
        acceptanceRate = "64.2%",
        easySolved = 412,
        easyTotal = 820,
        mediumSolved = 296,
        mediumTotal = 1640,
        hardSolved = 74,
        hardTotal = 660,
        speedPercentile = "Beats avg. 86.4%",
        paceMetric = "32 Daily Solves"
    )

    val badges = listOf(
        Badge("50 Days"),
        Badge("Guardian"),
        Badge("Knight"),
        Badge("SQL 50"),
        Badge("Oct Daily", isRecent = true)
    )

    val topLanguages = listOf(
        LanguageStat("Python", 492),
        LanguageStat("TypeScript", 184),
        LanguageStat("C++", 106)
    )

    val coreTopics = listOf("DP", "Trees", "Graphs")

    val allTopics = listOf("Array", "DP", "Tree", "Binary Search", "Graph")

    val recentSubmissions = listOf(
        Submission(
            id = 2458,
            title = "Height of Binary Tree After Subtree Removal",
            difficulty = Difficulty.Hard,
            tags = listOf("Tree", "DFS"),
            timeAgo = "Today",
            runtime = "18ms",
            beatsPercentage = "98.4%"
        ),
        Submission(
            id = 146,
            title = "LRU Cache",
            difficulty = Difficulty.Medium,
            tags = listOf("Hash Table", "Linked List", "Design"),
            timeAgo = "2d ago",
            runtime = "42ms",
            beatsPercentage = "89.1%"
        ),
        Submission(
            id = 1,
            title = "Two Sum",
            difficulty = Difficulty.Easy,
            tags = listOf("Array", "Hash Table"),
            timeAgo = "3d ago",
            runtime = "2ms",
            beatsPercentage = "99.8%"
        ),
        Submission(
            id = 200,
            title = "Number of Islands",
            difficulty = Difficulty.Medium,
            tags = listOf("DFS", "BFS", "Union Find"),
            timeAgo = "Oct 26",
            runtime = "3ms",
            beatsPercentage = "92.5%"
        ),
        Submission(
            id = 42,
            title = "Trapping Rain Water",
            difficulty = Difficulty.Hard,
            tags = listOf("Two Pointers", "Monotonic Stack"),
            timeAgo = "Oct 24",
            runtime = "1ms",
            beatsPercentage = "95.0%"
        ),
        Submission(
            id = 206,
            title = "Reverse Linked List",
            difficulty = Difficulty.Easy,
            tags = listOf("Linked List", "Recursion"),
            timeAgo = "Oct 22",
            runtime = "0ms",
            beatsPercentage = "100%"
        )
    )
}