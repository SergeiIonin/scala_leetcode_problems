package io.github.sergeiionin.scalaleetcode
package hashtable.easy

//https://leetcode.com/problems/two-sum/
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
