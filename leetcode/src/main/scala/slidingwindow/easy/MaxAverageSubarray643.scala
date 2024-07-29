package io.github.sergeiionin.scalaleetcode
package slidingwindow.easy

import annotation.tailrec

// https://leetcode.com/problems/maximum-average-subarray-i
object MaxAverageSubarray643 {
  def findMaxAverage(nums: Array[Int], k: Int): Double = {
       @tailrec
       def iter(maxSum: Int, from: Int, to: Int, prevSum: Int): Double = {
         if ((from >= nums.length) || (to >= nums.length)) {
           maxSum.toDouble / k
         } else {
           val sum = prevSum - nums(from - 1) + nums(to)
           val maxSumUpd =
             if (sum > maxSum) {
               sum
             } else {
               maxSum
             }
           iter(maxSumUpd, from + 1, to + 1, sum)
         }
       }
       if (nums.isEmpty || (nums.length < k)) {
         0.0
       } else {
         val sumInit = nums.slice(0, k).sum
         iter(sumInit, 1, k, sumInit)
       }
  }
}
