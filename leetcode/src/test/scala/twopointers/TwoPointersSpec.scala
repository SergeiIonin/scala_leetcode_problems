package io.github.sergeiionin.scalaleetcode
package twopointers

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import twopointers.easy.MergeStringsAlternately1768.*
import twopointers.easy.ReverseVowelsOfString345.*
import twopointers.easy.ReverseVowelsOfString345.*
import twopointers.medium.StringCompression443.*

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
  "compress" should "correctly compress the string" in {
    val arr1 = Array('a', 'a', 'b', 'b', 'c', 'c', 'c')
    compress(arr1) shouldEqual 6
    arr1.slice(0, 6) shouldEqual Array('a', '2', 'b', '2', 'c', '3')

    val arr2 = Array('a')
    compress(arr2) shouldEqual 1
    arr2.slice(0, 1) shouldEqual Array('a')

    val arr3 = Array('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b')
    compress(arr3) shouldEqual 4
    arr3.slice(0, 4) shouldEqual Array('a', 'b', '1', '2')

    val arr4 = Array.empty[Char]
    compress(arr4) shouldEqual 0
    
    val arr5 = Array('a', 'b', 'c')
    compress(arr5) shouldEqual 3
    arr5.slice(0, 3) shouldEqual Array('a', 'b', 'c')
  }
}
