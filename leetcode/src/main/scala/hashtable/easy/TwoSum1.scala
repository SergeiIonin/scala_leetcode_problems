package io.github.sergeiionin.scalaleetcode
package hashtable.easy

//https://leetcode.com/problems/two-sum/
/**
 Given an array of integers nums and an integer target,
 return indices of the two numbers such that they add up to target .

 You may assume that each input would have exactly one solution,
 and you may not use the same element twice.

 You can return the answer in any order.

 Constraints:

 2 <= nums.length <= 104
 -109 <= nums[i] <= 109
 -109 <= target <= 109
 Only one valid answer exists.
 */
object TwoSum1 {
  import annotation.tailrec
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    @tailrec 
    def iter(numToIndex: Map[Int, Int], index: Int): Array[Int] = {
       if (index == nums.length) {
         Array.empty[Int]
       }
       else if (numToIndex.contains(target - nums(index))) {
        Array(numToIndex(target - nums(index)), index)
      } else {
        iter(numToIndex + (nums(index) -> index), index+1)
      }
     }
     iter(Map(nums.head -> 0), 1)
  }
}
