public class S38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        StringBuilder ans = new StringBuilder("1");
        for (int x = 1; x < n; x++) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < ans.length(); ) {
                int j = i;
                while (j < ans.length() && ans.charAt(i) == ans.charAt(j)) {
                    j++;
                }
                s.append(j - i).append(ans.charAt(i));
                i = j;
            }
            ans = s;
        }
        return ans.toString();
    }
}
