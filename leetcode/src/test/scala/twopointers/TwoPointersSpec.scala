package io.github.sergeiionin.scalaleetcode
package twopointers

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import twopointers.easy.MergeStringsAlternately1768.*
import twopointers.easy.ReverseVowelsOfString345.*

import scala.io.Source

class TwoPointersSpec extends AnyFlatSpec with Matchers {
  "mergeAlternately" should "correctly merge two strings alternately" in {
    mergeAlternately("abc", "def") shouldEqual "adbecf"
    mergeAlternately("abc", "de") shouldEqual "adbec"
    mergeAlternately("ab", "def") shouldEqual "adbef"
    mergeAlternately("a", "def") shouldEqual "adef"
    mergeAlternately("abc", "") shouldEqual "abc"
    mergeAlternately("", "def") shouldEqual "def"
  }
  "reverseVowels" should "correctly reverse vowels in a string" in {
    reverseVowels("hello") shouldEqual "holle"
    reverseVowels("leetcode") shouldEqual "leotcede"
    reverseVowels("aA") shouldEqual "Aa"
    reverseVowels("aeiou") shouldEqual "uoiea"
    reverseVowels("AEIOU") shouldEqual "UOIEA"
    reverseVowels("y") shouldEqual "y"
    reverseVowels("") shouldEqual ""
    reverseVowels("ab") shouldEqual "ab"
    reverseVowels("a.") shouldEqual "a."
    reverseVowels("Yo! Bottoms up, U.S. Motto, boy!") shouldEqual "Yo! Bottoms Up, u.S. Motto, boy!"
  }
}
