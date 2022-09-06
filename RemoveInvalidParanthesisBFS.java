// Time Complexity : O(n^n)
// Space Complexity : O(n) size of queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//i/p : ()(()
//queue : 1st iteration : ()(()
// 2nd iteration (drop a character one by one from first element and add it to queue and check if it forms valid parenthesis): )((), (((), ()(), ()(), ()(( - 2 valid
class RemoveInvalidParanthesisBFS {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        //add the first element to the queue
        q.add(s);
        boolean found = false;

        //if the queue is not empty
        while(!q.isEmpty()) {

            String curr = q.poll();

            //check if the current string is valid or not
            if(isValid(curr)) {

                found = true;
                result.add(curr);

            } //if the valid string is not already found, drop characters one by one in the string and check if it forms valid parenthesis or not
            else if(found == false) {

                for(int i = 0; i < curr.length(); i++) {

                    //Ignore characters
                    if(curr.charAt(i) >= 'a' && curr.charAt(i) <= 'z') continue;

                    String subStr = curr.substring(0, i) + curr.substring(i+1);

                    //use hashset to avoid duplicates
                    if(!set.contains(subStr)) {
                        set.add(subStr);
                        q.add(subStr);
                    }
                }
            }
        }
        return result;
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
