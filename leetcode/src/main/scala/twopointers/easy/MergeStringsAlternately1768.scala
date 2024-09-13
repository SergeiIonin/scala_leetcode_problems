package io.github.sergeiionin.scalaleetcode
package twopointers.easy

// https://leetcode.com/problems/merge-strings-alternately
object MergeStringsAlternately1768:
  import scala.annotation.tailrec
  def mergeAlternately(word1: String, word2: String): String =
    @tailrec
    def iter(w1: List[Char], w2: List[Char], acc: List[Char], isFirst: Boolean): List[Char] =
      if (w1.isEmpty) {
        if (w2.isEmpty) {
          acc
        } else {
          acc ++ w2
        }
      } else if (w2.isEmpty) {
        acc ++ w1
      } else {
        if (isFirst) {
          val accUpd = acc :+ w1.head
          iter(w1.tail, w2, accUpd, !isFirst)
        } else {
          val accUpd = acc :+ w2.head
          iter(w1, w2.tail, accUpd, !isFirst)
        }
      }

    val res = iter(word1.toList, word2.toList, List.empty[Char], true)
    res.mkString("")