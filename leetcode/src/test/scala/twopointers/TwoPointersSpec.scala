package io.github.sergeiionin.scalaleetcode
package twopointers

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import twopointers.easy.MergeStringsAlternately1768._

class TwoPointersSpec extends AnyFlatSpec with Matchers {
  "mergeAlternately" should "correctly merge two strings alternately" in {
    mergeAlternately("abc", "def") shouldEqual "adbecf"
    mergeAlternately("abc", "de") shouldEqual "adbec"
    mergeAlternately("ab", "def") shouldEqual "adbef"
    mergeAlternately("a", "def") shouldEqual "adef"
    mergeAlternately("abc", "") shouldEqual "abc"
    mergeAlternately("", "def") shouldEqual "def"
  }
}
