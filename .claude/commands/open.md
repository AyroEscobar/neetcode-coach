---
description: Re-open the current problem's LeetCode URL in the browser
---

The user invoked `/open`.

**Behavior:**

1. Read `current.txt` for the active problem slug. If empty, ask which problem.
2. Look up the slug in `problems/index.json` and grab its `leetcode_url`.
3. Run `open "<leetcode_url>"` via Bash.
4. One-line confirmation: "opened <name>." Nothing else.
