import java.util.Stack;

public class Solution {


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // 如果栈为空就返回false
                if (stack.isEmpty()) {
                    return false;
                }
                // 获取栈顶元素{{[[(())]]}}
                char pop = stack.pop();
                if (c == ')' && pop != '(') {
                    return false;
                }

                if (c == '{' && pop != '}') {
                    return false;
                }

                if (c == '[' && pop != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums1.length];
        for (int i = nums1.length - 1; i >= 0; i--) {
            stack.push(nums1[i]);
        }
        //取出栈顶元素
        int k = 0;
        boolean flag = true;
        while (flag) {
            my:for (int i = 0; i < nums2.length; i++) {
                Integer pop = stack.peek();
                if (pop == nums2[i]) {
                    if (i + 1 == nums2.length) {
                        result[k] = -1;
                        k++;
                    } else {
                        for (int j = i + 1; j < nums2.length; j++) {
                            if (pop < nums2[j]) {
                                result[k] = nums2[j];
                                k++;
                                stack.pop();
                                break my;
                            } else {

                                continue;
                            }

                        }
                        result[k] = -1;
                        k++;

                    }
                    stack.pop();
                    break;
                }

            }
            if(stack.isEmpty()){
                flag = false;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,3};
        int[] nums2 = new int[]{1,3,2,4};
        int[] ints = new Solution().nextGreaterElement(nums1, nums2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);

        }
    }
}
