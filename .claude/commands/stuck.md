---
description: Ask diagnostic questions about the current approach without escalating hint level
---

The user invoked `/stuck`.

**Behavior:**

1. **Read** `current.txt`, `problems/<slug>/Solution.java`, and `problems/<slug>/notes.md`.

2. **Diagnose, don't hint.** Look at the code and notes for the actual bottleneck:
   - Wrong data structure choice → ask what operations they need and what those operations cost.
   - Off-by-one suspected → ask what their loop invariant is and where they think it breaks.
   - Edge case unhandled → ask about empty / single-element / all-equal / negative inputs without naming which one matters.
   - Conceptual confusion → ask them to walk a small example by hand and tell you what `dp[2]` (or whichever state) means *in English*.

3. **Pick 1–2 diagnostic questions, not a list of 5.** Force a single focus.

4. **Do not escalate hint level** — that's what `/hint` is for. `/stuck` should produce *better questions about what they've already tried*, not new information about the algorithm.

5. **If they truly haven't started yet** (empty notes, empty Solution body), don't diagnose — point them at `/hint` instead.

**Tone:** clinical. Like a senior engineer at a whiteboard going "okay, walk me through line 14."
