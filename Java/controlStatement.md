## **목표**

자바가 제공하는 제어문을 학습하세요.

## **학습할 것**

 \- 선택문

 \- 반복문

# 제어문이란

프로그램 순서를 제어하거나 수행 횟수를 결정하는 키워드

# 1. 선택문

> ## if ~else if ~ else

```java
① if(조건)           => 조건이 참(true)이면 "처리 스택"을 실행한다.	
    처리 스택;	
 	
② if(조건)           => 조건이 참(true)이면 "처리 스택 1"을 실행한다.	
    처리 스택 1;	
  else              => 거짓(false)이면 "처리 스택 2"를 실행한다.	
    처리 스택 2;	
 	
 	
③ if(조건1)          => 조건1이 참(true)이면 "처리 스택 1"을 실행한다.	
    처리 스택 1;      	
  else if(조건2)     => 조건1이 거짓(false)이고 조건2가 참(true)이면 "처리 스택 2"를 실행한다.	
    처리 스택 2;	
  else              => 조건1과 조건2가 둘 다 거짓이면 "처리 스택 3"을 실행하라.	
    처리 스택 3;
```





> ## switch ~case

```java
switch(조건 변수) {	
  case 값1:	
    처리 1;	
    break;	
  case 값2:	
    처리 2;	
    break;	
  case 값3:	
    처리 3;	
    break;	
  ...	
  default:	
    처리;	
    break;	
}
```

If 문과 switch 문의 차이는 break입니다. switch의 조건 변수에 해당하는 값을 찾아 case로 찾아가는 데 break가 없으면 해당 case만 처리하는 것이 아니라 선택되어 있는 case의 아래 스탭도 모두 처리가 되어버립니다!

---

---

# 2. 반복문

> ## while

해당 조건이 만족할 때 까지 코드를 반복하여 실행한다. 반복 횟수가 고정되지 않은 경우 while 루프를 사용하는 것이 좋다.



~~~java
public class Exam07 {

    public static void main(String[] args) {
        int index = 0;

        while (index != 10) {
            System.out.println(index);
            ++index;
        }
    }
}
~~~



조건이 true이면 해당 loop를 계속 반복한다. loop를 실행하던 도중 break를 만나거나 조건이 false가 되면 즉시 loop를 탈출한다. loop를 멈출 수 있는 flag가 없다면 무한루프에 빠질 수 있다.





~~~java
public class Exam08 {

    public static void main(String[] args) {
        int index = 0;

        while (true) {
            System.out.println(index);
            ++index;

            if (index == 10) break; // while 탈출을 위한 flag
        }
    }
}
~~~



 위 코드는 조건에 true를 넣었기 때문에 무한으로 루프를 돈다. 하지만 index == 10 일 때 break를 만나 while 문을 탈출한다.



> ## do while

~~~java
public class Exam09 {

    public static void main(String[] args) {
        int index = 0;

        do {
            System.out.println(index);
            ++index;

        } while (index != 10);
    }
}
~~~

 일반적인 while문과 상당부분 유사하지만 do-while문은 적어도 한번의 loop를 실행한다. 초기 조건을 비교하기 전에 처리해야 될 코드가 있을 때 혹은 무조건 한번 이상 실행시켜야 할 경우 유용하게 사용된다.



> ## for

~~~java
public class Exam10 {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
~~~

 

 초기의 값을 선언하여 해당 값이 조건에 충족되는 동안 loop를 반복한다. for은 loop의 횟수가 정해져 있을 때 유용하게 사용될 수 있다.

 

 for문은 for ( 1; 2; 3) 이러한 형태와 코드가 있는 바디 부분이 있다.

 

1. 초기화를 진행하는 공간이다. 변수를 초기화할 때 주로 사용된다. 루프를 시작하면 한 번만 실행되는 공간이다.

2. 조건이 들어간다. 반환값이 true, false 즉 boolean 값 이어야 한다. 해당 조건은 루프를 한 번 돌 때 마다 실행된다.

3. 증가 및 감소 연산이다. 초기화 구문에서 생성한 변수의 index 값을 증가시키거나 감소시킨다.

   

> ## for each

iterate 객체에서 하나씩 순차적으로 값에 대입되어 loop를 수행한다. list나 map등의 모든 항목들을 탐색할 때 매우 직관적이고 유용하게 사용할 수 있다. 하지만 기존의 for문 자체에서 횟수를 제어할 수는 없다.

~~~java
public class Exam11 {

    public static void main(String[] args) {
        String[] seasons = {"봄", "여름", "가을", "겨울"};

        for (String season : seasons) {
            System.out.println(season);
        }
    }
}
~~~

---

### **과제 0. JUnit 5 학습하세요.**



---



### **과제 3. Stack을 구현하세요.**

- int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
- void push(int data)를 구현하세요.
- int pop()을 구현하세요.

 

```java
public class Homework03 {

    static class Stack {
        private int[] stack;
        private int size;
        private int index;

        public Stack(int size) {
            stack = new int[size];
            this.size = size;
            index = 0;
        }

        public void push(int data) {
            if (indexValidation(index, "push")) {
                stack[index] = data;
                ++index;
            } else {
                System.out.println("stack이 가득 찼습니다.");
            }
        }

        public int pop() {
            if (indexValidation(index, "pop")) {
                int result = stack[index - 1];
                stack[index - 1] = 0;
                --index;
                return result;
            } else {
                System.out.println("stack이 비어있습니다.");
                return 0;
            }
        }

        public void print() {
            for (int i = size - 1; i >= 0; i--) {
                System.out.println(i + " : " + stack[i]);
            }
        }

        private boolean indexValidation(int index, String method) {
            if (index == this.size - 1 && method.equals("push")) {
                return false;
            } else if (index == 0 && method.equals("pop")) {
                return false;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        int size = 7;
        Stack arrStack = new Stack(size);
        arrStack.push(1);
        arrStack.push(2);
        arrStack.push(3);
        arrStack.print();

        System.out.println();

        arrStack.push(4);
        arrStack.push(5);
        arrStack.print();

        System.out.println();

        System.out.println("pop : " + arrStack.pop());
        System.out.println("pop : " + arrStack.pop());
        arrStack.print();
    }
} 
```

 

 

 

