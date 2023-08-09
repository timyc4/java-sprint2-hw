public class Month {

    String item_name;   // название товара
    boolean is_expense; // одно из двух значений: TRUE или FALSE. Обозначает, является ли запись тратой (TRUE) или доходом (FALSE);
    int quantity;       // количество закупленного или проданного товара;
    int unit_price;  // стоимость одной единицы товара. Целое число.

    public Month(String item_name, boolean is_expense, int quantity, int unit_price) {
        this.item_name = item_name;
        this.is_expense = is_expense;
        this.quantity = quantity;
        this.unit_price = unit_price;
    }
}
