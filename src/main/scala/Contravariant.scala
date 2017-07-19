class ContravariantQueue[-T] {

  def add(x: T): Unit = print("\n" + x)
}

object Queue3 extends App{

  val f1 = new Country

  val fr = new State1

  val v1 = new State2

  val q1 = new ContravariantQueue[Country]
  q1.add(f1)

  val q2 = new ContravariantQueue[State2]
  q2.add(v1)

  // val q3 : ContravariantQueue[Fruit] = q2
  // --- This won't work

  val q4: ContravariantQueue[State1] = q1
  //q4.add(f1)----This won't work
  q4.add(fr)
}