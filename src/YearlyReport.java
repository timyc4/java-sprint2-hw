import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    public ArrayList<Year> years = new ArrayList<>();       //все объекты


    /** loadReport - загружает объекты в лист years*/
    void loadReport (String path){
        if(years.size() == 0) {
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
            }
        }
    }
    void printYearReport (){
        if (years.size() == 0){
            System.out.println("Данные не загружены");
        } else
            for (Year month : years) {
                if(!month.isEpense)
                    System.out.println("Доход за " + month.month + " месяц составила " + month.amount + " рублей.");
                if(month.isEpense)
                    System.out.println("Траты за " + month.month + " месяц составила " + month.amount + " рублей.");
            }
    }

    void printPribil(){
        HashMap<Integer,Double> pribil = new HashMap<>();
        if (years.size() == 0){
            System.out.println("Данные не загружены");
        } else
            for (Year month : years) {
                if(!pribil.containsKey(month.month)) {
                    if (!month.isEpense){
                        pribil.put(month.month, month.amount);
                    } else
                        pribil.put(month.month, - month.amount);

                } else {
                    double wer = pribil.get(month.month);
                    if (month.isEpense){
                        pribil.put(month.month, wer - month.amount);
                    } else
                        pribil.put(month.month, month.amount + wer);
                }
            }
        for (Integer month : pribil.keySet()) {
            String key = month.toString();
            String value = pribil.get(month).toString();
            System.out.println("За " + key + " месяц выручка составила " + value);
        }

    }

    Double printMiddleRashodYear(){
        int count = 0;
        double sum = 0;
        if (years.size() == 0){
            System.out.println("Данные не загружены");
        } else
            for (Year month : years) {
                if(month.isEpense){
                    count++;
                    sum += month.amount;
                }
            }
            return sum/count;
    }

    Double printMiddleDohodYear(){
        int count = 0;
        double sum = 0;
        if (years.size() == 0){
            System.out.println("Данные не загружены");
        } else
            for (Year month : years) {
                if(!month.isEpense){
                    count++;
                    sum += month.amount;
                }
            }
        return sum/count;
    }

}