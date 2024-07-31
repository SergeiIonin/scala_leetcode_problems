package io.github.sergeiionin.scalaleetcode
package prefixsum.medium

object ProductOfArrayExceptSelf238 {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    import annotation.tailrec
    val res = Array.from(nums)
    @tailrec
    def iter(prod: Int, i: Int, isForward: Boolean): Array[Int] = {
      if (isForward) {
        if (i != nums.length - 1) {
          val prodUpd = nums(i) * prod
          res(i) = prod
          iter(prodUpd, i + 1, isForward)
        } else {
          val prodUpd = nums(i)
          res(i) = prod
          iter(prodUpd, i - 1, !isForward)
        }
      } else {
        res(i) = res(i)*prod
        val prodUpd = nums(i)*prod
        if (i == 0) {
          res
        } else {
          iter(prodUpd, i - 1, false)
        }
      }
    }
    iter(1, 0, true)
  }
}
