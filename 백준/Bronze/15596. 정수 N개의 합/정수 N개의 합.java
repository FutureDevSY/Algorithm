public class Test {
    long sum(int[] a) {
        long ans = 0;
        int aLength = a.length;
        for (int i = 0; i < aLength; i++) {
            ans += a[i];
        }
        return ans;
    }
}
