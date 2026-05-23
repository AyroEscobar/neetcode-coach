---
description: Post-solve walkthrough — articulate the pattern, complexity, edge cases; updates progress.json
---

The user invoked `/review`.

**Behavior:**

1. **Verify tests pass.** Run `cd problems/<slug> && javac Solution.java Tests.java && java Tests`. If any fail, do NOT proceed with review — tell him to fix the failing tag first.

2. **Make him articulate, in this order:**

   a. **The pattern in plain English.** Not "hash map" — *why* hash map. What did the structure of the input let him do?

   b. **Time complexity.** With `n` (and `m`, `k`, whatever) defined explicitly. Push back if he says "O(n)" without saying what n counts.

   c. **Space complexity.** Same rigor. Including the call stack if recursion.

   d. **Edge cases.** What would a naive solution have missed that his handles? Empty input, single element, all duplicates, negatives, overflow, etc.

   e. **When he'd reach for this pattern again.** What signal in a *future* problem statement would point back here? This is the most important question — it builds transfer.

3. **Push on vague answers.** If he says "it handles duplicates," ask which line. If he says "O(n log n)," ask which step is the log.

4. **Update `progress.json`:**
   ```json
   {
     "solved": {
       "<slug>": {
         "first_solved": "YYYY-MM-DD",  // only if new
         "last_attempt": "YYYY-MM-DD",
         "attempts": <int+1>,
         "patterns": ["<category from index.json>"],
         "minutes_to_solve": <int|null>,
         "needs_review": false
       }
     }
   }
   ```
   Move from `attempted` to `solved` if applicable. Reset `needs_review` to false unless he stumbled hard on the articulation.

5. **If he struggled** (took >30 min, used L3+, used `/spoil`, or articulation was weak): increment `weak_patterns[<category>].struggles` and set `last_struggle` to today.

6. **End with a single sentence:** what's the strongest pattern transfer here. Move on.

**Tone:** firm, terse. This is the part where rigor compounds.
