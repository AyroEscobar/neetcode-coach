class Tests {
    static int passed = 0, failed = 0;
    static java.util.List<String> failedTags = new java.util.ArrayList<>();

    public static void main(String[] args) {
        Solution sol = new Solution();

        check("single",               sol.containsDuplicate(new int[]{7})                    == false);
        check("all-unique",            sol.containsDuplicate(new int[]{1, 2, 3, 4, 5})         == false);
        check("one-duplicate",         sol.containsDuplicate(new int[]{1, 2, 3, 1})            == true);
        check("all-same",              sol.containsDuplicate(new int[]{4, 4, 4, 4})            == true);
        check("duplicates-far-apart",  sol.containsDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 1}) == true);
        check("negative-duplicates",   sol.containsDuplicate(new int[]{-1, -2, -3, -2})        == true);
        check("two-distinct",          sol.containsDuplicate(new int[]{1, 2})                  == false);
        check("zero-dup",              sol.containsDuplicate(new int[]{0, 1, 0})               == true);

        System.out.println("passed: " + passed + " | failed: " + failed);
        if (!failedTags.isEmpty()) {
            System.out.println("failed tags: " + String.join(", ", failedTags));
        }
        System.exit(failed == 0 ? 0 : 1);
    }

    static void check(String tag, boolean cond) {
        if (cond) { passed++; }
        else      { failed++; failedTags.add(tag); }
    }
}
