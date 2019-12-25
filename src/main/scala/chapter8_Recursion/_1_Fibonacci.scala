package chapter8_Recursion

object _1_Fibonacci {
  def fib(n: Int): Int = {
    if (n == 0)   0
    else if (n == 1)  1
    else fib(n - 1) + fib(n - 2)
  }

  def main(args: Array[String]): Unit = {
    println(fib(0))
    println(fib(1))
    println(fib(2))
    println(fib(5))
    println(fib(7))
  }
}
