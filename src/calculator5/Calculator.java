package calculator5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    Scanner sc = new Scanner(System.in);
    Calculator calculator = new Calculator();
    private List<Double> calculateStore = new ArrayList<>();

    double a = 0, b = 0;
    char opr = 0;
    String end = "";
    boolean running = true;


    public double caculator(double a, char opr, double b) {
        double result = 0;
        switch (opr) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> {
                if (b == 0) throw new ArithmeticException("분모에 0을 넣을 수 없습니다!");
                else {
                    result = a / b;
                }
            }
            default -> System.out.println("실행 가능한 연산이 아닙니다.");
        }
        return result;
    }






    public String store(String end, double result) {


        calculateStore.add(result);
        boolean running = true;

        System.out.println("계산 결과를 조회 하거나 삭제 하시겠습니까?(조회 : 1, 삭제 : 2, 건너뛰기 : 3)");
        end = sc.next();

        while (running != false) {
            if (end.equals("1")) {
                if (calculateStore.size() > 3) {
                    calculateStore.remove(0);
                }
                System.out.println(calculateStore);
                System.out.println("계산 결과를 다시 조회 하거나 삭제 하시겠습니까?(조회 : 1, 삭제 : 2, 건너뛰기 : 3)");
                end = sc.next();
            } else if (end.equals("2")) {
                calculateStore.clear();
                System.out.println("삭제 되었습니다! 다시 계산을 시작하시겠습니까?(조회 : 1, 삭제 : 2, 건너뛰기 : 3)");
                end = sc.next();
            } else if (end.equals("3")) {
                running = false;
            } else {
                System.out.println("1, 2, 3번 중에 다시 입력해주세요!");
                end = sc.next();
            }
        }
        return "결과 조회를 마칩니다.";
    }










        while (!end.equals("exit")) {


        System.out.println("양의 정수를 입력하세요!");
        a = inpputNumber("첫번째", sc);

        System.out.println("기호를 입력하세요!");
        running = true;
        while (running) {
            opr = sc.next().charAt(0);
            if (opr == '+' || opr == '-' || opr == '*' || opr == '/') {
                running = false;
            } else {
                System.out.println("+, -, *, / 중 해당하는 연산자를 입력해주세요!");
            }
        }


        System.out.println("양의 정수를 입력하세요!");
        b = inpputNumber("두번째", sc);


        double result = calculator.caculator(a, opr, b);
        System.out.println("정답은 " + result + "입니다!");



        System.out.println(calculator.store(end, result));



        System.out.println("프로그램을 종료하시려면 exit을 입력하세요! 계속 하려면 아무 키나 입력하세요!");
        end = sc.next();
    }

}





public static double inpputNumber(String positiveInteger, Scanner sc) {
    boolean running = true;
    double result = 1;
    while (running) {
        try {
            result = sc.nextInt();
            if (result >= 0) {
                running = false;
            } else {
                System.out.println("음수는 입력할 수 없습니다. 다시 " + positiveInteger + " 값을 양수로 입력해주세요!");
            }
        } catch (InputMismatchException e) {
            System.out.println("숫자로 입력해주세요!");
        }
        sc.nextLine();
    }

    return result;
}

}


