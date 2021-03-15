package scala_basic

/**
 *  todo:每个类都有主构造器，参数写在类名后面
 */
class student (val name:String, val age:Int ){
  //主构造器会执行类中的所有定义
  println("run main constructor")
  private var gender = "male"

  def this (name:String ,age:Int ,gender:String) {
    //每个辅助构造器的执行必须以柱构造器或者是其他辅助构造器的调用开始
    this(name,age)
    println("run auxiliary constructor")
    this.gender = gender
  }
}

object student{
  def main(args: Array[String]): Unit = {
    val s1 = new student("zhangsan",18)
    val s2 = new student("zhangsan",18,"male")
    println(s1.toString)
    println(s2)
  }
}
