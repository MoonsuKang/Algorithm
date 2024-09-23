import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i =0; i<T; i++) {
            String ps = br.readLine();
            System.out.println(isVPS(ps) ? "YES" : "NO");
        }
    }
    private static boolean isVPS(String ps){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<ps.length();i++){
            char ch = ps.charAt(i);
            if(ch == '('){
                stack.push(ch);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}