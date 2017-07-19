class CovariantQueue[+T] (
                           private val leading: List[T],
                           private val trailing: List[T]
                         ) {
  private def mirror =
    if (leading.isEmpty) {
      new CovariantQueue(trailing.reverse, Nil)
    }
    else {
      this
    }

  def head: T = mirror.leading.head

  def tail : CovariantQueue[T] = {
    val q = mirror
    new CovariantQueue(q.leading.tail, q.trailing)
  }

  // def enqueue(x: T): Queue[T] = new Queue(leading, x :: trailing)

  override def toString: String = {
    val list = leading ::: trailing.reverse
    list.toString
  }

}

object Queue2 extends App{

  val f1 = new Country
  val f2 = new Country
  val f3 = new Country

  val v1 = new State2
  val v2 = new State2

  val q1 = new CovariantQueue[Country](List(f1, f2), Nil)
  print("\n  Queue: " + q1)

  val q2 = new CovariantQueue[State2](List(v1, v2), Nil)
  print("\n  Queue: " + q2)


  val q3 : CovariantQueue[Country] = q2
  print("\n  Queue: " + q3)

  // val q4: CovariantQueue[Fruit] = q1
  // --- This won't work

}