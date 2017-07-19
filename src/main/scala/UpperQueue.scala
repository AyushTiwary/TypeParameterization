class UpperBoundQueue[T] (
                           private val leading: List[T],
                           private val trailing: List[T]
                         ) {
  private def mirror =
    if (leading.isEmpty) {
      new UpperBoundQueue(trailing.reverse, Nil)
    }
    else {
      this
    }


  def tail : UpperBoundQueue[T] = {
    val q = mirror
    new UpperBoundQueue(q.leading.tail, q.trailing)
  }

  def enqueue[U <:T](x: T): UpperBoundQueue[T] = new UpperBoundQueue(leading, x :: trailing)

  override def toString: String = {
    val list = leading ::: trailing.reverse
    list.toString
  }

}

object Queue5 extends App{

  val fr1 = new State1

  val o1 = new City11

  val o2 = new City11

  val a1 = new City12

  val b1 = new ABC

  val q2 = new UpperBoundQueue[City11](List(o1, o2), Nil)

  val q3 = q2.enqueue(b1)

  print("\nQueue: " + q3)

}