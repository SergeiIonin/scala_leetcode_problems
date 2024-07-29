package io.github.sergeiionin.scalaleetcode
package twopointers.medium
import annotation.tailrec

// https://leetcode.com/problems/string-compression
object StringCompression443 {
  def compress(chars: Array[Char]): Int = {
    def getDigitsForOccurence(occ: Int): Array[Char] = {
      occ.toString.toList.toArray
    }
    def updateChars(chars: Array[Char], current: Char, hash: Map[Char, Int], lastIndex: Int): Int = {
      val occurrences = hash(current)
      val digitsForOccurrence = getDigitsForOccurence(occurrences)
      val charsUpdate = if (occurrences == 1) {
        chars(lastIndex) = current
        Array.apply(current)
      } else {
        val updates = Array.emptyCharArray.appended(current).appendedAll(digitsForOccurrence)
        for (i <- updates.indices) {
          chars(i + lastIndex) = updates(i)
        }
        updates
      }
      lastIndex + charsUpdate.length
    }
    @tailrec
    def iter(hash: Map[Char, Int], current: Char, lastIndex: Int, nextIndex: Int): Int = {
      if (nextIndex == chars.length) {
        lastIndex
      }
      else if (current == chars(nextIndex)) {
        val hashUpd = hash.updated(current, hash(current) + 1)
        
        if (nextIndex == chars.length-1) {
          val lastIndexUpd = updateChars(chars, current, hashUpd, lastIndex)
          iter(hash, current, lastIndexUpd, nextIndex+1)
        } else {
          iter(hashUpd, current, lastIndex, nextIndex+1)
        }
      } else {
        val currentUpd = chars(nextIndex)
        val lastIndexUpd = updateChars(chars, current, hash, lastIndex)
        val hashUpd = hash.removed(current).updated(currentUpd, 1)
        
        if (nextIndex == chars.length - 1) {
          chars(lastIndexUpd) = currentUpd
          iter(hashUpd, currentUpd, lastIndexUpd+1, nextIndex+1)
        } else {
          iter(hashUpd, currentUpd, lastIndexUpd, nextIndex + 1)
        }
      }
    }
    if (chars.isEmpty) {
      0
    } else if (chars.length == 1) {
      1
    } else {
      iter(Map(chars.head -> 1), chars.head, 0, 1)
    }
  }
}
