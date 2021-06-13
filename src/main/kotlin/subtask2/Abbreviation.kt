package subtask2

import java.util.*

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {

        val ss = a.toUpperCase().toMutableList()
        //var copySS = ss.toMutableList()
        //val iter = copySS.iterator().withIndex()

        for (index in ss.size-1 downTo 0) {
            if (ss[index] !in b)
                ss.removeAt(index)
        }

        val result = if (ss.equals(b.subSequence(0, b.length).toMutableList())) "YES" else "NO"
        return result
    }
}
