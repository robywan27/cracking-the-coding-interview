package chapter7_OO._2_call_center

import scala.collection.mutable.ListBuffer

class CallHandler(var freshers: ListBuffer[Fresher] = ListBuffer(),
                  var technicalLeads: ListBuffer[TechnicalLead] = ListBuffer(),
                  var productManagers: ListBuffer[ProductManager] = ListBuffer()) {

  def addFresher(fresher: Fresher): Unit = freshers += fresher
  def addTechnicalLead(technicalLead: TechnicalLead): Unit = technicalLeads += technicalLead
  def addProductManager(productManager: ProductManager): Unit = productManagers += productManager

  def removeFresher(fresher: Fresher): Unit = freshers -= fresher
  def removeTechnicalLead(technicalLead: TechnicalLead): Unit = technicalLeads -= technicalLead
  def removeProductManager(productManager: ProductManager): Unit = productManagers -= productManager

  def getCallHandler(telephoneCall: TelephoneCall): Option[Employee] = {
    for (fresher <- freshers)
      if (fresher.available)
        return Some(fresher)
    for (technicalLead <- technicalLeads)
      if (technicalLead.available)
        return Some(technicalLead)
    for (productManager <- productManagers)
      if (productManager.available)
        return Some(productManager)
    None
  }

  def dispatchCallToEmployee(employee: Employee): Unit = employee.available = false
}
