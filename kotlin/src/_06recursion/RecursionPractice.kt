package _06recursion

class RecursionPractice {

    fun findLine(line: Int) : Int{
        if (line == 1) return 1

        else return findLine(line-1) + 1
    }

    fun upstartsWay (level: Int) : Int{

        if (level == 1) return 1
        if (level == 2) return 2

        return upstartsWay(level - 1) + upstartsWay(level - 2)
    }


}