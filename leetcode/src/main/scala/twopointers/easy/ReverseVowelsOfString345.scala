package io.github.sergeiionin.scalaleetcode
package twopointers.easy

//03:08
object ReverseVowelsOfString345:
  def reverseVowels(s: String): String =
    val vowelsLower = Set('a', 'e', 'i', 'o', 'u')
    val vowelsUpper = vowelsLower.map(s => s.toUpper)
    val vowels = vowelsLower ++ vowelsUpper
    
    def isVowel(c: Char) = vowels contains c

    def iter(left: List[Char], right: List[Char], accLeft: List[Char], accRight: List[Char]): List[Char] = {
      if (accLeft.size + accRight.size == s.length) accLeft.reverse ++ accRight
      else if ((left.head == right.head) && (accLeft.size + accRight.size == s.length-1)) {
         accLeft.reverse ++ (right.head :: accRight)
      }  
      else {
        if (isVowel(left.head)) {
          if (isVowel(right.head)) {
            val accLeftU = right.head :: accLeft
            val accRightU = left.head :: accRight
            iter(left.tail, right.tail, accLeftU, accRightU)
          } else {
            val accRightU = right.head :: accRight
            iter(left, right.tail, accLeft, accRightU)
          }
        } else {
          val accLeftU = left.head :: accLeft
          if (isVowel(right.head)) {
            iter(left.tail, right, accLeftU, accRight)
          } else {
            val accRightU = right.head :: accRight
            iter(left.tail, right.tail, accLeftU, accRightU)
          }
        }
      }
    }
    
    if (s.isEmpty) {
        s
    } else {
        iter(s.toList, s.reverse.toList, List.empty[Char], List.empty[Char]).mkString("")
    }
