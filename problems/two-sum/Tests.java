import java.util.Arrays;

class Tests {
    static int passed = 0, failed = 0;
    static java.util.List<String> failedTags = new java.util.ArrayList<>();

    public static void main(String[] args) {
        Solution sol = new Solution();

        check("basic",       eq(sol.twoSum(new int[]{2, 7, 11, 15}, 9),         new int[]{0, 1}));
        check("end-pair",    eq(sol.twoSum(new int[]{3, 2, 4}, 6),               new int[]{1, 2}));
        check("duplicates",  eq(sol.twoSum(new int[]{3, 3}, 6),                  new int[]{0, 1}));
        check("negative",    eq(sol.twoSum(new int[]{-1, -2, -3, -4, -5}, -8),  new int[]{2, 4}));
        check("single-pair", eq(sol.twoSum(new int[]{1, 5}, 6),                  new int[]{0, 1}));
        check("trailing",    eq(sol.twoSum(new int[]{1, 2, 3, 4, 5}, 9),         new int[]{3, 4}));
        check("zero-target", eq(sol.twoSum(new int[]{-3, 4, 3, 90}, 0),          new int[]{0, 2}));

        System.out.println("passed: " + passed + " | failed: " + failed);
        if (!failedTags.isEmpty()) {
            System.out.println("failed tags: " + String.join(", ", failedTags));
        }
        System.exit(failed == 0 ? 0 : 1);
    }

    // Order-insensitive int[] equality.
    static boolean eq(int[] a, int[] b) {
        if (a == null || b == null) return false;
        if (a.length != b.length) return false;
        int[] aa = a.clone(); int[] bb = b.clone();
        Arrays.sort(aa); Arrays.sort(bb);
        return Arrays.equals(aa, bb);
    }

    static void check(String tag, boolean cond) {
        if (cond) { passed++; }
        else      { failed++; failedTags.add(tag); }
    }
}
