package io.github.sergeiionin.scalaleetcode
package hashtable

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import hashtable.easy.ValidAnagram242.*
import hashtable.easy.TwoSum1.*
import hashtable.easy.UniqueOccurrences1207.*
import hashtable.medium.ValidSudoku36.*

class HashTableSpec extends AnyFlatSpec with Matchers {
  "isAnagram" should "correctly identify anagrams" in {
    isAnagram("anagram", "nagaram") shouldBe true
    isAnagram("rat", "car") shouldBe false
    isAnagram("a", "a") shouldBe true
    isAnagram("ab", "a") shouldBe false
  }
  "twoSum" should "correctly identify the indices of the two numbers such that they add up to a specific target" in {
      twoSum(Array(2, 7, 11, 15), 9).toSet shouldEqual Set(0, 1)
      twoSum(Array(3, 2, 4), 6).toSet shouldEqual Set(1, 2)
      twoSum(Array(3, 3), 6).toSet shouldEqual Set(0, 1)
      twoSum(Array(2, 5, 5, 11), 10).toSet shouldEqual Set(1, 2)
  }

  "isValidSudoku" should "correctly validate a Sudoku board" in {
    isValidSudoku(
      Array(
        Array('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        Array('.', '.', '.', '.', '8', '.', '.', '7', '9')
      )
    ) shouldBe true

    isValidSudoku(
      Array(
        Array('8', '3', '.', '.', '7', '.', '.', '.', '.'),
        Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        Array('.', '.', '.', '.', '8', '.', '.', '7', '9')
      )
    ) shouldBe false
  }
  "uniqueOccurrences" should "return unique occurrences" in {
    val arr0 = Array(1, 2, 2, 1, 1, 3)
    uniqueOccurrences(arr0) shouldBe true
    
    val arr1 = Array(1, 2, 2, 1, 1, 2)
    uniqueOccurrences(arr1) shouldBe false

    val arr2 = Array.empty[Int]
    uniqueOccurrences(arr2) shouldBe true
    
    val arr3 = Array(1)
    uniqueOccurrences(arr3) shouldBe true
    
    val arr4 = Array(1, 1, 1, 1)
    uniqueOccurrences(arr4) shouldBe true
  }
}
