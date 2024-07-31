package io.github.sergeiionin.scalaleetcode
package prefixsum

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import prefixsum.medium.ProductOfArrayExceptSelf238._


class ProductOfArrayExceptSelf238Spec extends AnyFlatSpec with Matchers {
  "productExceptSelf" should "correctly calculate the product of all the numbers in the array except for the number at the current index" in {
    productExceptSelf(Array(1, 2, 3, 4)) shouldEqual Array(24, 12, 8, 6)
    productExceptSelf(Array(0, 0)) shouldEqual Array(0, 0)
    productExceptSelf(Array(1, 0)) shouldEqual Array(0, 1)
  }
}
