package io.deusaquilus

import io.exoquery.sql.jdbc.Sql
import io.exoquery.sql.jdbc.TerpalContext
import io.exoquery.sql.jdbc.fromConfig
import io.exoquery.sql.jdbc.runOn
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable

@Serializable
data class Person(val id: Int, val firstName: String, val lastName: String, val age: Int)

@Serializable
data class Address(val ownerId: Int, val street: String, val zip: String)

fun main() = runBlocking {
  val ctx = TerpalContext.SqlServer.fromConfig("testPostgresDB")
  Sql("DELETE FROM Person").action().runOn(ctx)
  Sql("DELETE FROM Address").action().runOn(ctx)

  Sql("INSERT INTO Person (id, firstName, lastName, age) VALUES (1, 'Joe', 'Blogs', 123)").action().runOn(ctx)
  Sql("INSERT INTO Address (ownerId, street, zip) VALUES (1, '123 Main St', '62701')").action().runOn(ctx)


  val result = Sql("SELECT * FROM Person").queryOf<Person>().runOn(ctx)
  println("Simple Query Result: $result")

  val joined = Sql("SELECT Person.*, Address.* FROM Person JOIN Address ON Person.id = Address.ownerId").queryOf<Pair<Person, Address>>().runOn(ctx)
  println("Joined Query Result: $joined")
}
