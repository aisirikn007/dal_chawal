import java.util.Scanner;

class Stack {
    int[] stack = new int[10];
    int top = -1;

    void push(int value) {
        if (top == 9) {
            System.out.println("stack overflow");
        } else {
            top++;
            stack[top] = value;
            System.out.println(value + " pushed into stack");
        }
    }

    void pop() {
        if (top == -1) {
            System.out.println("stack underflow");
        } else {
            int value = stack[top];
            top--;
            System.out.println(value + " popped from stack");
        }
    }

    void display() {
        if (top == -1) {
            System.out.println("stack is empty");
        } else {
            System.out.println("stack elements are:");

            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
}

class StackDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack s = new Stack();

        int choice, value;

        do {
            System.out.println("\n--- STACK MENU ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.println("Enter Your Choice:");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter Value To Push");
                    value = sc.nextInt();
                    s.push(value);
                    break;

                case 2:
                    s.pop();
                    break;

                case 3:
                    s.display();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 4);

        sc.close();
    }
}