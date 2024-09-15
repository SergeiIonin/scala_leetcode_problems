package io.github.sergeiionin.scalaleetcode
package binarysearch.easy


object IsPerfectSquare367 {
  import scala.annotation.tailrec
  
  def isPerfectSquare(num: Int): Boolean = {

    def orderOfMagnitude(n: Int): Int = {
      if (n == 0) 0
      else {
        var count = 0
        var num = n
        while (num >= 10) {
          num /= 10
          count += 1
        }
        count
      }
    }
    
    def pow(n: Int, p: Int) = {
      @tailrec
      def iter(accum: Int, rem: Int): Int = {
        if (rem == 0) {
          accum
        } else {
          iter(accum * n, rem - 1)
        }
      }
      iter(n, p-1)
    }

    @tailrec
    def iter(left: Int, right: Int): Boolean = {
      val elem = (left + right) / 2
      if (elem == left) {
        false
      } else {
        val square = elem * elem
        if (square < 0) {
          iter(left, right / 2)
        } else if (square > num) {
          iter(left, elem)
        } else if (square < num) {
          iter(elem, right)
        } else true
      }
    }

    if (num == 0 || num == 1) {
      true
    } else {
      val oom = orderOfMagnitude(num)
      val right = if (oom >= 3) {
        val denom = pow(10, (oom - 1)/2)  
        num / denom
      } else num
      iter(0, right)
    }
  }
  
}
