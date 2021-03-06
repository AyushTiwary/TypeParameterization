class Queue[T](
                private val leading: List[T],
                private val trailing: List[T]
              ) {
  private def mirror =
    if (leading.isEmpty) {
      new Queue(trailing.reverse, Nil)
    }
    else {
      this
    }

  def head: T = mirror.leading.head

  def tail : Queue[T] = {
    val q = mirror
    new Queue(q.leading.tail, q.trailing)
  }

  def enqueue(x: T): Queue[T] = new Queue(leading, x :: trailing)

  override def toString: String = {
    val list = leading ::: trailing.reverse
    list.toString
  }
}


object Queue1 extends App{

  val f1 = new Country
  val f2 = new Country
  val f3 = new Country

  val v1 = new State2
  val v2 = new State2

  val q1 = new Queue[Country](List(f1, f2), Nil)
  print(q1.enqueue(f3))

  val q2 = new Queue[State2](List(v1, v2), Nil)
  print("\n Queue: " + q2)

 }