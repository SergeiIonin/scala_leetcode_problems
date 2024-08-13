package io.github.sergeiionin.scalaleetcode
package arrays

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import arrays.easy.CanPlaceFlowers605._

class ArraysSpec extends AnyFlatSpec with Matchers {
  "canPlaceFlowers605" should "return true if n flowers can be placed in the flowerbed without violating the no-adjacent-flowers rule" in {
    canPlaceFlowers(Array(1, 0, 0, 0, 1), 1) shouldBe true
    canPlaceFlowers(Array(1, 0, 0, 0, 1), 2) shouldBe false
    canPlaceFlowers(Array(0, 0, 1, 0, 1), 1) shouldBe true
    canPlaceFlowers(Array(0, 0, 1, 0, 0), 1) shouldBe true
    canPlaceFlowers(Array(0, 1, 0, 1, 0, 1, 0, 0), 1) shouldBe true
    canPlaceFlowers(Array(0, 0, 0, 0, 0), 3) shouldBe true
    canPlaceFlowers(Array(1, 0, 0, 0, 0, 1), 1) shouldBe true
    canPlaceFlowers(Array(1, 0, 0, 0, 0, 1), 2) shouldBe false
    canPlaceFlowers(Array(1, 0, 0, 0, 1, 0, 0), 2) shouldBe true
    canPlaceFlowers(Array(0, 0, 0, 0), 1) shouldBe true
    canPlaceFlowers(Array(1), 0) shouldBe true
    canPlaceFlowers(Array(0), 1) shouldBe true
    canPlaceFlowers(Array(1), 1) shouldBe false
  }
}