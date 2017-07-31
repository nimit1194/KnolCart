/*name := "Knolcart"
version := "1.0"
scalaVersion := "2.12.2"*/

lazy val commonSettings = Seq(
  name := "Knolcart",
  version := "1.0",
  scalaVersion := "2.12.2",
  libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.3" % "test"
)

lazy val inventory = (project in file("inventory"))
  .settings(
    commonSettings
  )

lazy val checkoutservice = (project in file("checkoutservice"))
  .settings(
    commonSettings
  )
lazy val inventorysdk = (project in file("inventorysdk"))
  .settings(
    commonSettings
  )
lazy val notificationservice = (project in file("notificationservice"))
  .settings(
    commonSettings
  )

