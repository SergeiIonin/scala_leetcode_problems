package io.github.sergeiionin.scalaleetcode
package hashtable.easy

// https://leetcode.com/problems/valid-anagram
object ValidAnagram242 {
  import annotation.tailrec
  def isAnagram(s: String, t: String): Boolean = {
    if (s.length != t.length) false
    else {
      val hashS = s.toList.groupBy(identity).map {
        case c -> list => c -> list.length
      }
      @tailrec
      def iter(hash: Map[Char, Int], other: List[Char]): Boolean = {
        other match {
          case head::tail =>
            if (hash contains head) {
              val current = hash(head)
              val hashUpd = if (current == 1) {
                hash.removed(head)
              } else {
                hash.updated(head, current-1)
              }
              iter(hashUpd, tail)
            } else {
              false
            }
          case Nil => 
            hash.isEmpty
        }
      }
      iter(hashS, t.toList)
    }
  }
}
