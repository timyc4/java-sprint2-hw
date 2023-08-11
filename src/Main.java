import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Поехали!
        Scanner scanner = new Scanner(System.in);
        YearlyReport yearlyReport = new YearlyReport();
        MonthlyReport monthlyReport = new MonthlyReport();
        Checker checker = new Checker(yearlyReport, monthlyReport);

        while (true) {
            printMenu();
            byte i = scanner.nextByte();
            switch (i) {
                case 1:
                    monthlyReport.loadReport();
                    break;
                case 2:
                    yearlyReport.loadReport("y.2021.csv");
                    break;
                case 3:
                    checker.checkReport();
                    break;
                case 4:
                    monthlyReport.monthReport();
                    break;
                case 5:
                    yearlyReport.yearReport();
                    break;
                case 0:
                    System.out.println("Выход из программы");
                    scanner.close();
                    return;

                default:
                    System.out.println("Такой команды нет");
            }
        }
    }

    static void printMenu() {
        System.out.println("Выберите действие: ");
        System.out.println("1 - Считать месячные отчеты");
        System.out.println("2 - Считать годовой отчет");
        System.out.println("3 - Сверить отчеты");
        System.out.println("4 - Вывести информацию обо всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выйти из программы");

    }

}

