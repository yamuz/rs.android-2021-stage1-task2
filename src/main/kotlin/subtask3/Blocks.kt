package subtask3

import java.time.LocalDate
import kotlin.reflect.KClass

class Blocks {
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        var result: Any = ""
        if (blockB.simpleName.equals("String")) {
            for (i in blockA.indices) {
                if (blockA[i] is String)
                    result =  result as String + blockA[i]
            }
            return result
        } else if (blockB.simpleName.equals("Int")) {
            result = 0
            for (i in blockA.indices) {
                if (blockA[i] is Int)
                    result = (result as Int).plus(blockA[i] as Int)
            }
            return result
        } else if (blockB.simpleName.equals("LocalDate")) {
            result = LocalDate.of(1, 1, 1)
            var date = LocalDate.of(1, 1, 1)

            for (i in blockA.indices) {
                if (blockA[i] is LocalDate) {
                    try {
                        date = blockA[i] as LocalDate
                        result = if (date.isAfter(result as LocalDate)) date else result
                    } catch (e: Exception) {
                        continue
                    }
                }
            }

            result = result as LocalDate
            result = "${result.dayOfMonth}.${result.month.value}.${result.year}"
        }
        return result
    }
}
