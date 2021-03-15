package it.bigdata.sparkbasic

object helloscala {
  def main(args: Array[String]): Unit = {
    val msg = "hello scala"
    val greetStrings = Array("i", "like", "scala")
    println(msg)
    println(greetStrings)
//    println(max(5, 6))
//    greet()
//    printargs(greetStrings)

    val oneTwo = List(1,2)
    val threeFour = List(3,4)
    val oneTwoThreeFour = oneTwo:::threeFour
    println(oneTwo + "and" + threeFour + " were not mutated.")
    println("Thus, " + oneTwoThreeFour + " is a new list")

    val pair = (7,"bread")
    println(pair._1)
    println(pair._2)

    var jetSet = Set("Boeing", "Airbus")
    jetSet += "Lear"
    println(jetSet.contains("Boeing"))


    val romanNumeral = Map(1 -> "I", 2 -> "II",
      3 -> "III", 4 -> "IV", 5 -> "V")
    println(romanNumeral(4))

    def max(x:Int ,y:Int):Int ={
      if (x>y) x
      else
        y
    }
  }
}
