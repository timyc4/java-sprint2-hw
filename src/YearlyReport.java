public class YearlyReport {
    byte month;        // месяц, целое число, обозначается строго двумя цифрами, начиная с единицы, то есть 01 — «январь», а 11 — «ноябрь»;
    double amount;      // сумма
    boolean is_expense; // одно из двух значений: true или false. Обозначает, является ли запись тратой (true) или доходом (false).

    public YearlyReport(byte month, double amount, boolean is_expense) {
        this.month = month;
        this.amount = amount;
        this.is_expense = is_expense;
    }


}