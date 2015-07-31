package tut9

/**
 * Created by usezer on 31.07.2015.
 */
/**
 * Chapter 18 --> Stateful Objects
 */
class BankAccount {

  private var bal: Int = 0

  def balance: Int = bal

  def deposit(amount: Int) {
    require(amount > 0)
    bal += amount
  }


  def withDraw(amount: Int): Boolean = {
    if (amount > bal)
      false
    else {
      bal -= amount
      true
    }
  }
}


object BankAccount {

  def main(args: Array[String]) {

    val bankAccount = new BankAccount
    bankAccount.deposit(100)
    bankAccount.deposit(10)
    println(bankAccount.withDraw(80))
    println(bankAccount.withDraw(80))
    println(bankAccount.balance)


  }

}