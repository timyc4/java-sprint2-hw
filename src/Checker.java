import java.util.HashMap;

public class Checker {
    public YearlyReport yearlyReport;
    public MonthlyReport monthlyReport;

    public Checker(YearlyReport yearlyReport, MonthlyReport monthlyReport) {
        this.yearlyReport = yearlyReport;
        this.monthlyReport = monthlyReport;
    }


    void checkReport() {
        if (yearlyReport.years.size() == 0 || monthlyReport.allReportMonth.size() == 0) {
            System.out.println("Сначала загрузите отчеты!");
            return;
        }
        monthlyReport.monthDohodIRashod();
        checkReportsDohody();

    }

    void checkReportsDohody() {
        if (yearlyReport.dohodyYear.equals(monthlyReport.dohody)) {
            System.out.println("Отчеты по месячным доходам сошлись с годовым");
        } else {
            HashMap<Integer, Integer> compareDohody = monthlyReport.dohody;
            for (Integer monthYear : yearlyReport.dohodyYear.keySet()) {
                if (compareDohody.containsKey(monthYear)) {
                    if (!compareDohody.get(monthYear).equals(yearlyReport.dohodyYear.get(monthYear)))
                        System.out.println("Месячный отчет по доходам за " + monthYear + " месяц НЕ сошелся");
                }
            }
        }
        if (yearlyReport.rashodyYear.equals(monthlyReport.rashody)) {
            System.out.println("Отчеты по месячным расходам сошлись с годовым");
        } else {
            HashMap<Integer, Integer> compareRashody = monthlyReport.rashody;
            for (Integer monthYear : yearlyReport.rashodyYear.keySet()) {
                if (compareRashody.containsKey(monthYear)) {
                    if (!compareRashody.get(monthYear).equals(yearlyReport.rashodyYear.get(monthYear)))
                        System.out.println("Месячный отчет по расходам за " + monthYear + " месяц НЕ сошелся");
                }
            }
        }
    }
}
