package lab1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyArrayLinearList list = new MyArrayLinearList();

        while (true) {
            System.out.println("\n===== MyArrayLinearList Console Test =====");
            System.out.println("1. Add element");
            System.out.println("2. Display list");
            System.out.println("3. Find max");
            System.out.println("4. Find min");
            System.out.println("5. Sum");
            System.out.println("6. Average");
            System.out.println("7. Remove odd numbers");
            System.out.println("8. Sort list");
            System.out.println("9. Remove by index");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    int val = sc.nextInt();
                    list.add(list.size(), val);
                    break;

                case 2:
                    System.out.print("List: ");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.print(list.get(i) + " ");
                    }
                    System.out.println();
                    break;

                case 3:
                    if (list.size() > 0)
                        System.out.println("Max: " + list.max());
                    else
                        System.out.println("List is empty!");
                    break;

                case 4:
                    if (list.size() > 0)
                        System.out.println("Min: " + list.min());
                    else
                        System.out.println("List is empty!");
                    break;

                case 5:
                    System.out.println("Sum: " + list.sum());
                    break;

                case 6:
                    if (list.size() > 0)
                        System.out.println("Average: " + list.average());
                    else
                        System.out.println("List is empty!");
                    break;

                case 7:
                    list.removeOdd();
                    System.out.println("Odd numbers removed.");
                    break;

                case 8:
                    list.sort();
                    System.out.println("List sorted.");
                    break;

                case 9:
                    System.out.print("Enter index to remove: ");
                    int idx = sc.nextInt();
                    if (idx >= 0 && idx < list.size()) {
                        list.remove(idx);
                        System.out.println("Element removed.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
