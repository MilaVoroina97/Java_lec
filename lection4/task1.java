package lection4;

import java.util.Stack;

// Из инфиксной формы в постфиксную и префиксную
public class task1 {
    public static void main(String[] args) {
        String res = convertInfix("9 + ( 3 - 1 ) * 3 + 10 / 2");
        System.out.println(res);
        String calc = calculatePostFix(res);
        System.out.println(calc);
    }

    public static String convertInfix(String infix){
        boolean mayUnary = true;// определение может ли след. оператор быть унарным
        Stack<Character> stack = new Stack<Character>(); //стэк операторов и символов
        StringBuilder psb = new StringBuilder();//билдер выходной строки
        int length = infix.length();
        for(int i = 0 ; i < length; i++){
            char ch = infix.charAt(i);
            if(Character.isDigit(ch)){
                String number = gatherNumber(ch, infix, i);
                i += number.length() - 1;
                psb.append(number);
                psb.append(' ');
                mayUnary = false;
            }else if(ch == '('){
                stack.push(ch);
                mayUnary = true;
            }else if(ch == ')'){
                char temp = '\n';
                while((temp = stack.pop())!= '('){
                    psb.append(temp);
                    psb.append(' ');
                }
                mayUnary = false;
            }else if(isOperator(ch)){
                if(mayUnary &&(ch == '+' || ch == '-')){
                    if(ch == '-'){
                        psb.append('±');
                    }else{
                        continue;
                    }
                }else{
                    while(stack.size() > 0 && getPriority(ch) <= getPriority(stack.peek())){ //пока приоритет оператора меньше или равен приоритету оператора
                                                                                            // на верщине стека, выталкиваем символы из стека в строку
                        psb.append(stack.pop()); 
                        psb.append(' ');
                    }
                    stack.push(ch);

                }

                mayUnary = true;
            }
        }
        while (stack.size() > 0){
            psb.append(stack.pop());
            psb.append(' ');
        }
        return psb.toString().trim();
    }

    public static String calculatePostFix(String postfix){
        Stack<Double> stack = new Stack<Double>();//стэк для вычисления 
        int len = postfix.length();
        for(int i = 0; i < len; i++){
            char ch = postfix.charAt(i);
            if(ch == ' '){

            }else if(Character.isDigit(ch) || ch == '±'){
                String number = gatherNumber(ch, postfix, i);
                i += number.length() - 1;
                double num = parseNumber(number);
                stack.push(num);
            }else if(isOperator(ch)){
                double x = stack.pop();
                double y = stack.pop();
                if(ch == '+'){
                    y  = x + y;
                }else if(ch == '-'){
                    y = y - x;
                }else if(ch == '*'){
                    y = x * y;
                }else if(ch == '/'){
                    y = y / x;
                }else if(ch == '^'){
                    y = Math.pow(y,x);
                }
                stack.push(y);
            }else{
                return null;
            }
        }

        double result = stack.pop();
        int intRes = (int) result;
        if(intRes == result){
            return Integer.toString(intRes);
        }else{
            return Double.toString(result);
        }

    }
// функция, которая собирает последовательность символов, представляющих одно число, в одну строчку
// ch - первый символ числа, str - строка, из которой будут собирать символы, index - индекс символа в строке
    public static String gatherNumber(char ch, String str, int index){

        StringBuilder sb = new StringBuilder();
        while(Character.isDigit(ch) || ch == ',' || ch == '.' || ch == '±'){
            sb.append(ch);
            index++;
            if(index >= str.length()) break;
            ch = str.charAt(index);

        }
        return sb.toString();
    }

    public static boolean isOperator(char ch){
        return (ch == '/'|| ch == '*' || ch =='+' || ch == '-');
    }

    public static int getPriority(char ch){
        if(ch == '+' || ch == '-') return 1;
        else if(ch == '*' || ch == '/') return 2;
        else if(ch == '^') return 3;
        else return -1;
    }
// функция для перевода строки в число double, если в начале строки стоят унарные знаки, то учитываем знак числа, в соответствии с количеством унарных знаков

    public static double parseNumber(String number){
        int sign = 1;
        char ch = number.charAt(0);
        while(ch == '±'){
            sign *= -1;
            number = number.substring(1);
            ch = number.charAt(0);
        }

        double num = Double.parseDouble(number);
        num *= sign;
        return num;

    }
    
}
