import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Поехали!
        Scanner scanner = new Scanner(System.in);

        while (true){
            printMenu();
            byte i = scanner.nextByte();
            switch (i){
                case 1:

                case 2:

                case 3:

                case 4:

                case 5:

                case 0:
                    System.out.println("Выход из программы");
                    scanner.close();
                    return;

                default:
                    System.out.println("Такой команды нет");
            }
        }
    }

    static void printMenu(){
        System.out.println("Выберите действие: ");
        System.out.println("1 - Считать месячные отчеты");
        System.out.println("2 - Считать годовой отчет");
        System.out.println("3 - Сверить отчеты");
        System.out.println("4 - Вывести информацию обо всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");

    }
}

