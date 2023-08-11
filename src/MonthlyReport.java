import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {

    ArrayList<Month> reportMonth = new ArrayList<>();
    HashMap<Integer, ArrayList<Month>> allReportMonth = new HashMap<>();
    HashMap<Integer, Integer> dohody = new HashMap<>();
    HashMap<Integer, Integer> rashody = new HashMap<>();


    /** loadReport - загружает объекты в лист allReportMonth */

    void loadReport(){
        for (int i = 1; i <= 3; i++) {
            reportMonth = new ArrayList<>();
            String m = "m.20210" + i + ".csv";
            FileReader fileReader = new FileReader();
            ArrayList <String> lines = fileReader.readFileContents(m);
                for (int j = 1; j < lines.size(); j++) {
                String line = lines.get(j);
                String[] part = line.split(",");
                String item_name = part[0];                         // название товара
                boolean is_expense = Boolean.parseBoolean(part[1]); // одно из двух значений: TRUE или FALSE. Обозначает, является ли запись тратой (TRUE) или доходом (FALSE);
                int quantity = Integer.parseInt(part[2]);           // количество закупленного или проданного товара;
                int unit_price = Integer.parseInt(part [3]);        // стоимость одной единицы товара. Целое число.

                Month month = new Month(item_name,is_expense,quantity,unit_price);
                reportMonth.add(month);
        }
            allReportMonth.put(i, reportMonth);
            System.out.println("Отчёт " + m + " успешно загружен.");
        }
    }

    /** monthReport - содержит все методы для вывода */

    void monthReport() {
        if(allReportMonth.size() == 0){
            System.out.println("Сначала загрузите месячные отчеты!");
        }
        for (Integer month : allReportMonth.keySet()) {
            if (month == 1){
                System.out.println("Январь");
                bestItemName(month);
                worstItemName(month);
            }
            if (month == 2){
                System.out.println("Февраль");
                bestItemName(month);
                worstItemName(month);
            }
            if (month == 3){
                System.out.println("Март");
                bestItemName(month);
                worstItemName(month);
            }
        }
    }

    /** bestItemName - ищет по кажому месяцу самый прибыльный товар */

    void bestItemName(Integer month) {
        int maxExpense = 0;
        String bestItem = "";
        if (allReportMonth.containsKey(month)) {
            ArrayList<Month> months = allReportMonth.get(month);
            for (Month traty : months) {
                int check = 0;
                if (!traty.is_expense) {
                    check = traty.quantity * traty.unit_price;
                    if (check > maxExpense) {
                        maxExpense = check;
                        bestItem = traty.item_name;
                    }
                }
            }
        }
        System.out.println("Самым прибыльным товаром в этом месяце является " + bestItem + "(" +maxExpense+ " рублей.)");
    }

    /** worstItemName - ищет по кажому месяцу самый дорогой товар */

    void worstItemName(Integer month) {
        int maxExpense = 0;
        String worstItem = "";
        if (allReportMonth.containsKey(month)) {
            ArrayList<Month> months = allReportMonth.get(month);
            for (Month traty : months) {
                int check = 0;
                if (traty.is_expense) {
                    check = traty.quantity * traty.unit_price;
                    if (check > maxExpense) {
                        maxExpense = check;
                        worstItem = traty.item_name;
                    }
                }
            }
        }
        System.out.println("Самой дорогой тратой в этом месяце является " + worstItem + "(" +maxExpense+ " рублей.)");
    }

    /** monthDohodIRashod - раскидывает по двум мапам расходы и доходы по месяцам
     * чтобы потом в Checker сравнить
     * */
    void monthDohodIRashod(){
        int dohod = 0;
        int rashod = 0;
        for (Integer month : allReportMonth.keySet()) {
            ArrayList<Month> moths = allReportMonth.get(month);{
                for (Month moth : moths) {
                    int sum = moth.quantity * moth.unit_price;
                    if(!moth.is_expense){
                        dohod += sum;
                        dohody.put(month, dohod);
                    } else {
                        rashod += sum;
                        rashody.put(month,rashod);
                    }
                }
            }
            dohod = 0;
            rashod = 0;
        }
    }
}
