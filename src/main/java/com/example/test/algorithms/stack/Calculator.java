package com.example.test.algorithms.stack;

public class Calculator {

    public static void main(String[] args) {
        String expression = "7*2*2-5+1-5+3-4";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        //入栈
        while(true) {
            ch = expression.substring(index, index+1).charAt(0);
            //扫描表达式,并按数字和运算符分别入栈,考虑到数字的多位问题,数字要在扫描到符号时将之前的一起作为一个数字入栈
            if(operStack.isOper(ch)) {
                /*
                入栈规则:空栈直接入;非空栈,比较此运算符栈中前一个运算符,优先级低,则将前一个运算符弹出,并弹出
                数栈的两个数字,进行运算(因为是从左往右入栈的,因此这两个数在减和除的时候要调换位置),运算结果入数栈,运算符入
                符号栈;此运算符比前一个运算符优先级高,则直接将数字入数栈,此符号入符号栈
                *
                * */
                if(!operStack.isEmpty()) {
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                }else {
                    operStack.push(ch);
                }
            } else {

                keepNum += ch;
                //到表达式末尾或者遇到符号,说明数字扫描完整,可以入栈了
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //弹栈
        while(true) {
            if(operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        int res2 = numStack.pop();
        System.out.printf("表达式 %s = %d", expression, res2);
    }

}


class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    //构造
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //获取栈顶元素(但是不弹栈)
    public int peek() {
        return stack[top];
    }

    //判满
    public boolean isFull() {
        return top == maxSize - 1;
    }
    //判空
    public boolean isEmpty() {
        return top == -1;
    }
    //入栈
    public void push(int value) {
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //弹栈
    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //展示栈元素
    public void list() {
        if(isEmpty()) {
            System.out.println("Õ»¿Õ£¬Ã»ÓÐÊý¾Ý~~");
            return;
        }
        for(int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
    //规定运算符的等级
    public int priority(int oper) {
        if(oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }
    //判断字符是否为运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    //运算单位表达式(从左往右扫描入栈,因此出栈后的减和除要注意和弹栈顺序相反)
    public int cal(int num1, int num2, int oper) {
        int res = 0; //
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}

