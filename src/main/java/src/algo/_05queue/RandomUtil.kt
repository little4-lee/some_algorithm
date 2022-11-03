package algo._05queue

class RandomUtil {

    companion object {

        fun toDo(): Boolean {
            var random = (1..3).shuffled().last()

            if (random != 1) return true
            else return false
        }

        fun ranString () : String {
            return "" + (0..9).shuffled().last()
        }
    }
}
