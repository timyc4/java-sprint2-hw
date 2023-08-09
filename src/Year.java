public class Year {
    int month;        // месяц, целое число, обозначается строго двумя цифрами, начиная с единицы, то есть 01 — «январь», а 11 — «ноябрь»;
    double amount;      // сумма
    boolean isEpense; // одно из двух значений: true или false. Обозначает, является ли запись тратой (true) или доходом (false).

    public Year(int month, double amount, boolean isEpense) {
        this.month = month;
        this.amount = amount;
        this.isEpense = isEpense;
    }
}
