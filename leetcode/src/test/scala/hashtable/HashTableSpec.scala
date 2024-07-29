package io.github.sergeiionin.scalaleetcode
package hashtable

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import hashtable.easy.ValidAnagram242.*

class HashTableSpec extends AnyFlatSpec with Matchers {
  "isAnagram" should "correctly identify anagrams" in {
    isAnagram("anagram", "nagaram") shouldBe true
    isAnagram("rat", "car") shouldBe false
    isAnagram("a", "a") shouldBe true
    isAnagram("ab", "a") shouldBe false
  }
}
