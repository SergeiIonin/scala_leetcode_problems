package io.github.sergeiionin.scalaleetcode
package hashtable.easy

/***
  Given an array of integers arr, return true if the number of occurrences of
  each value in the array is unique or false otherwise.
  
  Constraints:

  1 <= arr.length <= 1000
  -1000 <= arr[i] <= 1000
*/

object UniqueOccurrences1207 {
  def uniqueOccurrences(arr: Array[Int]): Boolean = {
    import scala.annotation.tailrec
    val elemOccurrences = arr.toList.groupBy(identity).values.map(_.length).toList

    @tailrec
    def iter(list: List[Int], acc: Set[Int]): Boolean = {
      list match {
        case head :: tail =>
          if (acc contains head) {
            false
          } else {
            iter(tail, acc + head)
          }
        case Nil => true
      }
    }

    iter(elemOccurrences, Set.empty[Int])
  }
}
