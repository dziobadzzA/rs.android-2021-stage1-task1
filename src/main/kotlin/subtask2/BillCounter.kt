package subtask2

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {

        // сумма счета
        val summa = bill.sum()

        //создадим пустую строку для вывода
        var out = ""
        // сколько надо заплатить ей для счета
        // индекс в границах
        var resh = if ((k < bill.size) and (k >= 0)) {
            ((summa - bill[k])/2).toInt()
        } else {
            (summa/2).toInt()
        }

        if (resh == b) {out = "Bon Appetit"} else { resh = b - resh; out = "$resh"}

        return out
    }

}
