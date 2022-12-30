package lection4;
import java.util.Stack;


public class task2 {

    public static boolean isOperator(char ch){
        return(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '(' || ch == ')');
    }
    public static int getPriority(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;         
        }
        return -1;
    }

    public static boolean isOperand(char ch){
        return (ch >= '0' && ch <= '9');
    }

    public static String convertToPrefix(String infix){
        Stack<Character> stack = new Stack<Character>();
        StringBuffer postfix = new StringBuffer();
        char ch;
        for(int i = 0; i < infix.length(); i++){
            ch = infix.charAt(i);
            if(isOperand(ch)){
                postfix.append(ch);
            }else if (ch == '('){
                stack.push(ch);
            }else if(ch == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    postfix.append(stack.pop());
                }
                if(!stack.isEmpty() && stack.peek() != '('){
                    return null;
                }else if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(isOperator(ch)){
                if(!stack.isEmpty() && getPriority(ch)<= getPriority(stack.peek())){
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    public static void main(String[] args) {
        String res = convertToPrefix("9 + ( 3 - 1 ) * 3 + 9 / 2");
        System.out.println(res);
    }

}
