import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] products = {"Молоко", "Хлеб", "Гречневая крупа"};
        int[] prices = {50, 14, 80};

        System.out.println("Доступны товары:");
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i] + " " + prices[i] + " руб. за шт." + "(код товара: " + (i + 1) + ").");
        }
        int[] cart = new int[products.length];

        while (true) {
            System.out.println("Введите код товара и количество (через пробел. Например: 1 2). Для завершения покупок введите end:");
            String input = scan.nextLine();
            if (input.equals("end")) {
                break;
            }
            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            int productCount = Integer.parseInt(parts[1]);
            cart[productNumber] += productCount;
        }

        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < cart.length; i++) {
            cnt += cart[i];
            sum += cart[i] * prices[i];
        }
        System.out.println("Ваша корзина:");
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] > 0) {

                System.out.println(i + 1 + ") " + products[i] + " по цене " + prices[i] + " руб. за единицу товара" + ", " +
                        "всего добавлено в корзину - " + cart[i] + " шт.");
            }
        }
        System.out.println("Всего товаров: " + cnt + " шт.");
        System.out.println("На общую сумму: " + sum + " руб.");
    }
}