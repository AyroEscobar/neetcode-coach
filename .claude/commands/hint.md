---
description: Escalate one hint level on the current problem (L1 reframe → L2 category → L3 technique name; capped here, use /spoil for L4)
---

The user invoked `/hint`.

**Behavior:**

1. **Read** `current.txt` to find the active problem. If empty, ask which problem.

2. **Read** `problems/<slug>/notes.md` and `problems/<slug>/Solution.java` to see what the user has tried. Notes are the source of truth for "what level am I on" — they record prior hints given.

3. **Before giving the new hint:** ask the user to summarize, in one sentence, *what they've tried and where they're stuck.* This is not optional. Hints land badly when you skip this.

4. **Escalate one level** from whatever was last given. If no hints yet, give **L1**.

   - **L1 — Reframe / leading question.** Expose the bottleneck without naming any technique or data structure. Examples: *"What's the cost of the work you're repeating?"* / *"Is there a property of the input you haven't used yet?"*
   - **L2 — Category.** Point at a family of techniques. Examples: *"Think about data structures with O(1) lookup."* / *"This has a two-pointer flavor."* (Not naming the exact pattern.)
   - **L3 — Technique name.** Name the pattern explicitly. Examples: *"This is a hash-map pattern — what would your keys and values be?"* / *"Sliding window. What expands the window? What shrinks it?"* No algorithm sketch.

5. **Cap at L3.** If the user asks for more after L3, point them at `/spoil`.

6. **Update `problems/<slug>/notes.md`** with a line at the bottom:
   `[hint L<N>, YYYY-MM-DD]` — so future invocations know the level.

**Tone:** brief. One paragraph. Don't lecture about the pattern — just give the hint and stop. Make him take the next step.
