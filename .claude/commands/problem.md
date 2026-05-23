---
description: Load a NeetCode problem, scaffold its directory, open LeetCode, set as current
argument-hint: <problem-slug>
---

The user invoked `/problem $ARGUMENTS`.

**Behavior:**

1. **Look up** `$ARGUMENTS` in `problems/index.json`.
   - If empty, look at `current.txt` for the active problem and assume they want that.
   - If not found, suggest 1–3 closest matches by name/slug similarity. Don't proceed.

2. **Scaffold** `problems/$ARGUMENTS/` if it doesn't exist. Use `problems/two-sum/` as the template:
   - `PROBLEM.md` — write one with the problem name, category, difficulty, and the LeetCode URL. Don't write the problem statement (he reads it on LeetCode).
   - `Solution.java` — empty `class Solution { }` stub.
   - `Tests.java` — minimal scaffold using the tagged-`check(tag, cond)` pattern. Leave the test cases empty (a comment placeholder) — he can ask for tests, or you can write them later once he's articulated the method signature.
   - `notes.md` — empty heading: `# Scratch — $ARGUMENTS`.

3. **Set as current:** write `$ARGUMENTS` to `current.txt`.

4. **Open the LeetCode page:** run `open <leetcode_url>` (use the macOS `open` command — Bash tool).

5. **Check `progress.json` for weak patterns matching this problem's category.** If any pattern has 3+ struggles and matches:
   > "Heads up — you've struggled three times on `sliding-window`. Want to drill the pattern itself first, or push through this one?"

6. **Briefly state:** problem name, category, difficulty, premium-status if true. **Then ask:** "What's your first idea?" Do not state the pattern category as a hint — the category in the index is for tracking, not coaching.

**Anti-patterns:**
- Don't read the problem statement to him — he has the LeetCode tab open.
- Don't suggest an approach. Wait for his first idea.
- Don't write Solution code under any pretense — see Rule 1 of `CLAUDE.md`.
