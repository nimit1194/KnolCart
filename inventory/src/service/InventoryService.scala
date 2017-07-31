package services

import models._

import scala.concurrent.Future

trait InventoryService {

  def searchItems (inventory: Inventory,
                   category: String,
                   itemName: String,
                   sortingParameter: String): Future[List[Item]] = {
    Future {
      sortingParameter.toUpperCase match {

        case "LOW TO HIGH" => inventory.itemsList.filter(_.category == category)
          .sortBy(_.price.value)

        case "HIGH TO LOW" => inventory.itemsList.filter(_.category == category)
          .sortBy(_.price.value).reverse

        case "DEFAULT" => inventory.itemsList.filter(_.category == category)
      }
    }
  }inventory.itemsList


  def getPriceInfo (inventory: Inventory,
                    itemID: Int): Future[Price] = Future {
    inventory.itemsList.filter(_.id == itemID).head.price
  }


  def updateItemCount (inventory: Inventory,
                       itemID: Int,
                       updateBy: Int)
                      (f: (Int, Int) => Int): Future[Option[Item]] = {
    Future {
      val itemPreviousCount = inventory.itemsList.filter(_.id == itemID).head
      if (updateBy == 0) {
        val itemNewCount = itemPreviousCount.copy(itemCount = f(itemPreviousCount.itemCount, updateBy))
        Some(itemNewCount)
      }
      else None
    }
  }
  def addItems(item : Item ,
                          inventory: Inventory): (Inventory, Int) ={


    val newInventory= Inventory(item :: inventory.itemsList)

    (newInventory, item.itemId)
  }



}

