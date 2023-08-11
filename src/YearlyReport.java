import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    ArrayList<Year> years = new ArrayList<>();//все объекты
    HashMap<Integer, Integer> pribil = new HashMap<>();
    HashMap<Integer, Integer> dohodyYear = new HashMap<>();
    HashMap<Integer, Integer> rashodyYear = new HashMap<>();


    /**
     * loadReport - загружает объекты в лист years*
     * и раскидывает отчет (TRUE или FALSE) в мапы dohodyYear и rashodyYear
     * чтобы потом в Checker сравнить
     */

    void loadReport(String path) {
            FileReader fileReader = new FileReader();
            ArrayList<String> lines = fileReader.readFileContents(path);
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split(",");
                int month = Integer.parseInt(parts[0]);
                int amount = Integer.parseInt(parts[1]);
                boolean isExpense = Boolean.parseBoolean(parts[2]);

                Year year = new Year(month, amount, isExpense);
                years.add(year);
                if (year.isEpense) {
                    rashodyYear.put(year.month, year.amount);           //чтобы проще было сравнивать с месячными отчетами по расходам
                } else {
                    dohodyYear.put(year.month, year.amount);            //чтобы проще было сравнивать с месячными отчетами по тратам
                }
            }
        System.out.println("Отчёт " + path + " успешно загружен.");
    }

    /**
     * yearReport - содержит все методы для вывода
     */

    void yearReport() {
        if (years.size() == 0) {
            System.out.println("Сначала загрузите отчет за год!");
        } else {
            printYearReport();
            printPribil();
            printMiddleRashodYear();
            printMiddleDohodYear();
        }

    }

    /**
     * printYearReport - печатает доходы и траты за каждый месяц
     */

    void printYearReport() {

        for (Year month : years) {
            if (!month.isEpense)
                System.out.println("Доход за " + month.month + " месяц составила " + month.amount + " рублей.");
            if (month.isEpense)
                System.out.println("Траты за " + month.month + " месяц составила " + month.amount + " рублей.");
        }
    }

    /**
     * printPribil - высчитывает выручку по кажому месяцу по формуле (прибыль-траты)
     */

    void printPribil() {
        for (Year month : years) {
            if (!pribil.containsKey(month.month)) {
                if (!month.isEpense) {
                    pribil.put(month.month, month.amount);
                } else
                    pribil.put(month.month, -month.amount);

            } else {
                int wer = pribil.get(month.month);
                if (month.isEpense) {
                    pribil.put(month.month, wer - month.amount);
                } else
                    pribil.put(month.month, month.amount + wer);
            }
        }
        for (Integer month : pribil.keySet()) {
            String key = month.toString();
            String value = pribil.get(month).toString();
            System.out.println("За " + key + " месяц прибыль составила " + value);
        }

    }

    /**
     * printMiddleRashodYear - ситает среднюю трату в месяц за все месяцы из отчета
     */

    void printMiddleRashodYear() {
        int count = 0;
        double sum = 0;
        if (years.size() == 0) {
            System.out.println("Данные не загружены");
        } else
            for (Year month : years) {
                if (month.isEpense) {
                    count++;
                    sum += month.amount;
                }
            }
        System.out.println("Средний расоход в месяц: " + sum / count);
    }

    /**
     * printMiddleDohodYear - ситает среднюю выручку в месяц за все месяцы из отчета
     */

    void printMiddleDohodYear() {
        int count = 0;
        double sum = 0;
        if (years.size() == 0) {
            System.out.println("Данные не загружены");
        } else
            for (Year month : years) {
                if (!month.isEpense) {
                    count++;
                    sum += month.amount;
                }
            }
        System.out.println("Средний доход в месяц: " + sum / count);
    }

}