package chapter7_OO._2_call_center

object CallCenterTester {
  def main(args: Array[String]): Unit = {
    val f1 = new Fresher("F1234", "John Doe")
    val f2 = new Fresher("F224", "Larissa Meyer")
    val f3 = new Fresher("F2456", "Xin Qing")
    val tl = new TechnicalLead("TL222", "Abdallah Mohammed")
    val pm = new ProductManager("PM25", "Yoko Matsumoto")

    val callHandler = new CallHandler
    callHandler.addFresher(f1)
    callHandler.addFresher(f2)
    callHandler.addFresher(f3)
    callHandler.addTechnicalLead(tl)
    callHandler.addProductManager(pm)

    val tc1 = TelephoneCall("T11112", "Neverland, District 9, Block 3, House 22", "Nokia MXX3")
    val tc2 = TelephoneCall("T11115", "Neverland, District 7, Block 1, House 6", "Samsung SS9")

    val getEmployeeResult = callHandler.getCallHandler(tc1).getOrElse("No operators are available now")
    println(getEmployeeResult)
    getEmployeeResult match {
      case employee: Employee => callHandler.dispatchCallToEmployee(employee)
      case _ =>
    }

    f2.available = false
    f3.available = false

    val getEmployeeResult2 = callHandler.getCallHandler(tc2).getOrElse("No operators are available now")
    println(getEmployeeResult2)
  }
}
