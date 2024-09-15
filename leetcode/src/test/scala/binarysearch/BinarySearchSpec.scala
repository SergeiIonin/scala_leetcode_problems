package io.github.sergeiionin.scalaleetcode
package binarysearch

import binarysearch.easy.IsPerfectSquare367.*
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BinarySearchSpec extends AnyFlatSpec with Matchers {
  "isPerfectSquare" should "correctly identify perfect squares" in {
    isPerfectSquare(16) shouldBe true
    isPerfectSquare(25) shouldBe true
    isPerfectSquare(1) shouldBe true
    isPerfectSquare(0) shouldBe true
    isPerfectSquare(14) shouldBe false
    isPerfectSquare(26) shouldBe false
    isPerfectSquare(400000000) shouldBe true
    isPerfectSquare(900000000) shouldBe true
    isPerfectSquare(2147395600) shouldBe true
    isPerfectSquare(2) shouldBe false
  }
}