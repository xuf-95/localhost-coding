package it.bigdata.sparkbasic

object WordCount {
  def main(args: Array[String]): Unit = {
    def mulBy(factor:Double) = (x:Double) => factor * x
    //开始调用
    val tripe = mulBy(3)
    val half = mulBy(0.5)
    println(tripe(14) + " " + half(14))
  }
}
