# Patterns reference

Quick map of DSA patterns covered by NeetCode 150. Use this to:
- Recognize what pattern a new problem likely needs
- Drill weak areas (surface from `progress.json.weak_patterns`)
- Build the "when I see X, I reach for Y" intuition

For each pattern: **signal** (what to look for in the problem statement), **technique** (one-line essence), **typical complexity**, **gotchas**.

---

## arrays-hashing

**Signal:** Lookups by value, frequency counts, deduplication, "find pair / triple summing to X."
**Technique:** Trade space for time — store seen values/counts in a `HashMap<K,V>` or `HashSet<T>`. Pay O(n) space to drop a nested loop.
**Complexity:** Usually O(n) time, O(n) space.
**Gotchas:** Hashing custom objects requires `equals`/`hashCode`. Iteration order of `HashMap` is not insertion order — use `LinkedHashMap` if order matters.

---

## two-pointers

**Signal:** Sorted (or sortable) array, looking for a pair/triple, palindrome check, in-place compaction, "without extra space."
**Technique:** Two indices moving toward each other (or both forward) with deterministic rules — never both back up.
**Complexity:** O(n) after sort; sort itself is O(n log n).
**Gotchas:** Off-by-one on `left < right` vs `<=`. After moving a pointer past a duplicate, skip all equal neighbors.

---

## sliding-window

**Signal:** "Longest / shortest substring or subarray with property P," "at most K of something," contiguous range.
**Technique:** Two indices (`l`, `r`) defining a window. `r` always advances. `l` advances when the window violates P. Maintain a summary (count, max, hashmap) of the current window's contents.
**Complexity:** O(n) — each element is touched at most twice.
**Gotchas:** Fixed-size vs variable. When shrinking, remember to update the summary (decrement counts). Empty window edge case.

---

## stack

**Signal:** Matching pairs (parens, brackets), "next greater / smaller element," monotonic property, parsing nested structure.
**Technique:** Push/pop with a single linear scan. Monotonic stack maintains a sorted invariant on the way in.
**Complexity:** O(n) — each element pushed and popped once.
**Gotchas:** Don't forget to drain the stack at the end. Off-by-one when popping for "next greater" type problems.

---

## binary-search

**Signal:** Sorted (or has a monotonic property), "find min/max satisfying P," "smallest valid X," logarithmic time required.
**Technique:** `lo` and `hi` bounds, `mid = lo + (hi - lo) / 2`, narrow the range based on whether `mid` satisfies the predicate.
**Complexity:** O(log n).
**Gotchas:** Integer overflow on `(lo + hi) / 2` — use `lo + (hi - lo) / 2`. Termination: `lo < hi` vs `lo <= hi` depends on what you're returning. Off-by-one when narrowing (`hi = mid` vs `hi = mid - 1`).

---

## linked-list

**Signal:** Traversal, in-place reversal/reordering, cycle detection, k-th from end.
**Technique:** Dummy node for head edge cases. Two-pointer (slow + fast) for cycles, midpoint, k-th from end.
**Complexity:** O(n).
**Gotchas:** Lose the next pointer before you reassign. Always check `cur != null` AND `cur.next != null` for two-pointer.

---

## trees

**Signal:** Hierarchical structure, ancestor/descendant queries, "BST property," level-order anything, recursion-friendly definition.
**Technique:** Pick traversal: pre/in/post-order (recursive), level-order (BFS with queue). For BSTs, exploit ordering.
**Complexity:** O(n) for full traversal; O(log n) for BST search on balanced.
**Gotchas:** `null` left/right children. Recursion depth on skewed trees. BST validation: check entire subtree bounds, not just immediate child.

---

## heap-priority-queue

**Signal:** "Top K" / "K smallest" / "K largest," streaming median, scheduling with priorities.
**Technique:** `PriorityQueue` (min-heap by default in Java). For top-K, keep a heap of size K. For streaming median, two heaps (max-heap on smaller half, min-heap on larger).
**Complexity:** O(n log k) for top-K; O(log n) per insertion.
**Gotchas:** Java's `PriorityQueue` is min-heap. For max-heap: `new PriorityQueue<>(Collections.reverseOrder())`. `peek()` doesn't remove; `poll()` does.

---

## backtracking

**Signal:** "All combinations / permutations / subsets," "find any valid arrangement," constraint satisfaction.
**Technique:** Recursive choose-explore-unchoose. Build state, recurse, undo. Use index/start parameter to avoid duplicate orderings.
**Complexity:** Often exponential — O(2^n) for subsets, O(n!) for permutations. Prune aggressively.
**Gotchas:** Don't forget to undo the choice after recursing (`list.remove(list.size()-1)`). For "no duplicates" variants, sort + skip equal siblings.

---

## tries

**Signal:** Prefix queries, autocomplete, dictionary search, "starts with."
**Technique:** Tree of characters, each node = one char, terminal flag for end of word. Children typically a `Map<Character, TrieNode>` or `TrieNode[26]` for lowercase a-z.
**Complexity:** O(L) per insert/search where L = word length.
**Gotchas:** Array vs map trade-off (memory vs flexibility). Don't confuse "prefix exists" with "word exists."

---

## graphs

**Signal:** Connectivity, shortest path, cycle detection, "can reach," islands in a grid, dependency ordering.
**Technique:** DFS (recursion or stack) for exploration / cycle detection; BFS (queue) for shortest unweighted path; Union-Find for connected components.
**Complexity:** O(V + E).
**Gotchas:** Mark visited BEFORE recursing/enqueueing, not after. Directed vs undirected — affects cycle detection. Grid problems: 4-directional vs 8-directional neighbors.

---

## advanced-graphs

**Signal:** Weighted shortest path (Dijkstra), MST (Kruskal/Prim), topological sort with constraints, network flow.
**Technique:** Dijkstra (min-heap of `(dist, node)`), Prim/Kruskal (sort edges or use heap), Bellman-Ford (if negative weights).
**Complexity:** Dijkstra: O((V + E) log V). MST: O(E log E).
**Gotchas:** Dijkstra doesn't handle negative edges. Don't add a node to the heap multiple times if you can avoid it (or check on pop).

---

## 1d-dp

**Signal:** "Number of ways," "minimum cost / longest length up to position i," overlapping subproblems on a sequence.
**Technique:** Recurrence on `dp[i]` from prior indices. Bottom-up table or top-down memoized recursion. Often optimizable to O(1) space (only last 1-2 values needed).
**Complexity:** O(n) or O(n × k) depending on transitions.
**Gotchas:** Base cases. What does `dp[i]` represent? Write that down before transitioning.

---

## 2d-dp

**Signal:** Two strings/sequences, grid paths, "matching" problems, knapsack variants.
**Technique:** `dp[i][j]` with two indices, transitions from neighbors `(i-1, j)`, `(i, j-1)`, `(i-1, j-1)`.
**Complexity:** O(n × m).
**Gotchas:** Row/column zero base cases. Space optimization to O(min(n,m)) using two rows. Confusing "subsequence" (non-contiguous) with "substring" (contiguous).

---

## greedy

**Signal:** "Minimum number of," local choices that build the optimum, scheduling, intervals.
**Technique:** Sort by a clever key, then make the locally optimal choice at each step. The hard part is proving the greedy choice is globally optimal.
**Complexity:** Often O(n log n) due to the sort.
**Gotchas:** Greedy isn't always right — if a counterexample exists, fall back to DP. Always sanity-check the greedy invariant.

---

## intervals

**Signal:** Schedules, meetings, time ranges, overlapping segments.
**Technique:** Sort by start (or end) time. Sweep linearly. For "minimum rooms" / overlap counting, sweep events: +1 on start, -1 on end.
**Complexity:** O(n log n).
**Gotchas:** Inclusive vs exclusive endpoints. Ties: end before start? Depends on the problem.

---

## math-geometry

**Signal:** Matrix transforms, modular arithmetic, fast exponentiation, geometric properties.
**Technique:** Specific algebraic identities (Pow: fast exponentiation O(log n); Multiply Strings: digit-by-digit + carry). Matrix rotation = transpose then reverse rows.
**Complexity:** Varies — log for Pow, n² for matrix ops, n for digit-by-digit.
**Gotchas:** Integer overflow on multiplication. Sign handling in `Pow(x, n)` for negative `n`. In-place matrix ops: do you have temp space?

---

## bit-manipulation

**Signal:** "Find single number among pairs," counting set bits, "without using arithmetic operators," space-tight integer encoding.
**Technique:** XOR pairs cancel. `x & (x-1)` clears the lowest set bit. `x & -x` isolates the lowest set bit. Shifts for power-of-2 work.
**Complexity:** O(1) per op; O(32) or O(64) per integer.
**Gotchas:** Signed vs unsigned shifts (`>>` vs `>>>` in Java). Don't mix bitwise and logical operators. Bit counting via `Integer.bitCount(x)` exists.

---

## Cross-pattern combinations

Real problems often blend patterns:

- **arrays-hashing + sliding-window** — Longest Substring Without Repeating Characters
- **two-pointers + sorting** — 3Sum
- **stack + monotonic** — Daily Temperatures, Largest Rectangle in Histogram
- **trees + DFS + DP** — Binary Tree Maximum Path Sum
- **graphs + BFS + memo** — Word Ladder
- **heap + hashmap** — Top K Frequent Elements, LRU Cache (hashmap + linked list)
- **DP + binary search** — Longest Increasing Subsequence (O(n log n) approach)

When you see hybrid signals, list the patterns first, then ask: which one drives the outer loop? The other is usually inside it.
