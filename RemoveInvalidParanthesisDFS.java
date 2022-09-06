// Time Complexity : O(n^n)
// Space Complexity : O(n) size of recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class RemoveInvalidParanthesisDFS {
    Set<String> set = new HashSet<>();
    List<String> result = new ArrayList<>();
    int max =0;

    public List<String> removeInvalidParentheses(String s) {
        dfs(s);
        return result;
    }

    public void dfs(String s) {
        //base case
        if(set.contains(s) || s.length() < max) return;

        //logic
        set.add(s);

        //check if the string contains valid paranthesis
        if(isValid(s)) {
            //check for the max length of the valid paranthesis
            //only if the string length is greater than or equal to max, add the string to result
            if(s.length() > max) {
                max = s.length();
                result = new ArrayList<>();
                result.add(s);
            }
            else if(max == s.length()){
                result.add(s);
            }
        } else {
            //For the given string, drop a character one by one and check if any of them forms valid paranthesis
            for(int i = 0; i < s.length(); i++) {
                //ignore characters
                if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') continue;
                //drop a character and check if it forms a valid paranthesis
                String subStr = s.substring(0, i) + s.substring(i+1);
                dfs(subStr);
            }
        }
    }

    public boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                count++;
            }
            else if (c == ')') {
                count--;
                if(count < 0) return false;
            }
        }
        return count == 0;
    }
}