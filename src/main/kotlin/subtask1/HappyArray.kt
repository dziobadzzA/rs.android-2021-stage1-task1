package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {

        // массив в виде листа - начальная установка
        var massiv_buffer: MutableList<Int> = sadArray.toMutableList()

        // смысл проверки только при больше 2
        if (massiv_buffer.size > 2) {
            var i = 1
            while (i <= massiv_buffer.size - 2) {
                if ((massiv_buffer[i - 1] + massiv_buffer[i + 1]) < massiv_buffer[i]) {
                    massiv_buffer.removeAt(i)
                    if (i!=1) i--
                }
                else {
                    i++
                }
            }
        }

        // вывод счастливого массива
        return  massiv_buffer.toIntArray()
    }

}
