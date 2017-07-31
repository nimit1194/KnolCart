package models


case class Item(id:Int,name:String,
                photo:String,
                category:String,
                price:Price,
                itemCount:Int
                ,vendor:Vendor)



