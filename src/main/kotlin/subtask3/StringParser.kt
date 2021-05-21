package subtask3

class StringParser {

    fun getResult(inputString: String): Array<String> {

        val out_buf: MutableList<String> = mutableListOf<String>()

        // длина выходного массива строк
        var length = 0
        // проверяемый индекс
        var i = 0

        val provstartmassiv: CharArray = charArrayOf('[', '<', '(')
        val provstopmassiv: CharArray = charArrayOf(']', '>', ')')

        while (i < inputString.length) {

            // буферный массив поисковых индексов и сначала ищем стартовый индекс
            var massivindex: IntArray = IntArray(3)

            for (h in provstartmassiv.indices) {
                if (inputString.indexOf(provstartmassiv[h], i) != -1)
                     massivindex[h] = inputString.indexOf(provstartmassiv[h], i)
                else
                     massivindex[h] = inputString.length
            }

            // наш индекс в массиве стартов
            var p =  massivindex.min()?.let { massivindex.indexOf(it) }

            if (p != null) {

                i = massivindex[p] + 1
                var massivindex_stop = inputString.indexOf(provstopmassiv[p], massivindex[p]+ 1)

                var okej_stop = true
                var okej_length = 0
                var start = massivindex[p] + 1

                while(okej_stop) {

                    if ((inputString.indexOf(provstartmassiv[p], start) < massivindex_stop) and (inputString.indexOf(provstartmassiv[p], start) != -1)) {
                        okej_length++
                        start = inputString.indexOf(provstartmassiv[p], start) + 1
                    }
                    else
                        okej_stop= false

                }

                start = massivindex[p] + 1

                for( k in 0..okej_length) {
                    massivindex_stop = inputString.indexOf(provstopmassiv[p], start)
                    start = massivindex_stop + 1
                }

                if ((massivindex_stop != null) and (massivindex_stop != -1)) {
                    out_buf.add(inputString.substring(massivindex[p]+1, massivindex_stop))
                    length++
                }

            }
            else
                break;
            // стартовые индексы не найдены, значит они закончились
        }

        return out_buf.toTypedArray()
    }

}
