package io.github.sergeiionin.scalaleetcode
package hashtable

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import hashtable.easy.ValidAnagram242.*
import hashtable.easy.TwoSum1.*

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
}
