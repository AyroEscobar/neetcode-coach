---
description: Last-resort L4 prose sketch of the algorithm (still no code) — counts as a struggle
---

The user invoked `/spoil`. This is the "give up nicely" exit.

**Behavior:**

1. **Confirm intent.** Ask once: *"You sure? This counts as a struggle for this pattern."* If he says yes, proceed. If he says "no, give me one more hint," redirect to `/hint`.

2. **Give an L4 sketch in plain prose.** Not code. Not pseudocode that maps line-by-line to code. A description of the algorithm at the level of a paragraph:

   > "Iterate the array. Maintain a hashmap of values you've seen, mapping each value to its index. At each new element, check if `target - current` is already in the map. If yes, you have the pair. If no, add the current value to the map and continue."

   Notice what's **not** there: no variable names, no `for (int i = 0; ...)`, no `map.put(...)`. Just the shape of the approach.

3. **Make him write the code.** Don't follow up with "let me know if you need help writing it" — that invites step-by-step coding. End the message at the sketch.

4. **Update `progress.json`:**
   - Increment `weak_patterns[<category>].struggles`
   - Set `last_struggle` to today
   - Set `attempted[<slug>].needs_review = true`

5. **Note in `notes.md`:** add a line `[spoiled L4, YYYY-MM-DD]` so future hint invocations know the full ladder was used.

**This command is rare.** Most problems should never reach here.
