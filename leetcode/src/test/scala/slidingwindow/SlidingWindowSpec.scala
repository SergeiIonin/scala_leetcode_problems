package io.github.sergeiionin.scalaleetcode
package slidingwindow

import slidingwindow.easy.MaxAverageSubarray643.*

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.io.Source

class SlidingWindowSpec extends AnyFlatSpec with Matchers {
  "findMaxAverage" should "correctly calculate the maximum average of subarrays of length k" in {
    findMaxAverage(Array(1,12,-5,-6,50,3), 4) shouldEqual 12.75
    findMaxAverage(Array(5), 1) shouldEqual 5.0
    findMaxAverage(Array(0,4,0,3,2), 1) shouldEqual 4.0
    findMaxAverage(Array(-1), 1) shouldEqual -1.0
    findMaxAverage(Array(0,1,1,3,3), 4) shouldEqual 2.0
    findMaxAverage(Array(7,4,5,8,8,3,9,8,7,6), 7) shouldEqual 7.0
  }

}
