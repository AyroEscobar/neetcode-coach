# neetcode-coach

A personal Socratic coach for grinding the NeetCode 150 in Java.

Open the repo in Claude Code, ask it to load a problem, and it acts as a mentor — it asks leading questions, escalates hints when you're stuck, and runs your tests for you. It will not write the solution for you. That's the point.

## How it works

1. Open the repo in Claude Code: `cd neetcode-coach && claude`
2. Pick a problem: `/problem two-sum` (it scaffolds the directory, opens the LeetCode page in your browser, and sets it as the current problem)
3. Write your attempt in `problems/<slug>/Solution.java`. Jot your thinking in `notes.md`.
4. Stuck? `/hint` escalates one level:
   - **L1** — reframe / leading question
   - **L2** — name a category of technique
   - **L3** — name the specific technique
   - **/spoil** — last-resort prose sketch of the algorithm (still no code)
5. Solved? `/review` walks you through articulating the pattern, complexity, edge cases.

The coach never writes Solution code. Ever.

## Commands

| command         | what it does                                                 |
| --------------- | ------------------------------------------------------------ |
| `/problem <slug>` | scaffold a problem dir, open LeetCode, set as current        |
| `/hint`         | escalate one hint level (capped at L3)                       |
| `/stuck`        | coach asks diagnostic questions about your current approach  |
| `/review`       | post-solve walkthrough (only after passing tests)            |
| `/open`         | re-open current problem's LeetCode URL                       |
| `/spoil`        | reveal L4 prose sketch (the "I give up nicely" exit)         |

## Layout

```
neetcode-coach/
├── CLAUDE.md           # coach behavior — Claude Code reads this on open
├── PATTERNS.md         # DSA patterns reference + when-to-reach-for-it
├── problems/
│   ├── index.json      # canonical list of all 150 problems
│   └── <slug>/
│       ├── PROBLEM.md
│       ├── Solution.java   # you write
│       ├── Tests.java      # tagged-check pattern (coach reads results)
│       └── notes.md        # scratch thinking
├── progress.json       # solved / attempted / weak patterns
└── .claude/commands/   # slash command definitions
```

## Tests

Each problem has a `Tests.java` that uses a tagged-check pattern:

```java
check("duplicates", java.util.Arrays.equals(sol.twoSum(new int[]{3,3}, 6), new int[]{0,1}));
```

When the coach runs your tests, it sees which **tags** failed (e.g. `duplicates`, `negative`, `empty-input`) — and asks you diagnostic questions about that category of input without ever revealing the failing case itself.

Run them yourself:

```bash
cd problems/two-sum
javac Solution.java Tests.java && java Tests
```

## Not affiliated with NeetCode

NeetCode 150 refers to the curated problem list. This project is independent of neetcode.io and Navi Deol.

## License

MIT
