class LowerQueue[T] (
                           private val leading: List[T],
                           private val trailing: List[T]
                         ) {
  private def mirror =
    if (leading.isEmpty) {
      new LowerQueue(trailing.reverse, Nil)
    }
    else {
      this
    }

  def head: T = mirror.leading.head

  def tail : LowerQueue[T] = {
    val q = mirror
    new LowerQueue(q.leading.tail, q.trailing)
  }

  def enqueue[U >:T](x: U): LowerQueue[U] = new LowerQueue(leading, x :: trailing)

  override def toString: String = {
    val list = leading ::: trailing.reverse
    list.toString
  }

}

object Queue4 extends App{

  val fr1 = new State1

  val o1 = new City11
  val o2 = new City11

  val a1 = new City12


  val q2 = new LowerQueue[City11](List(o1, o2), Nil)


  print("\n" + q2.enqueue(a1))
  print("\n" + q2.enqueue(fr1))

}