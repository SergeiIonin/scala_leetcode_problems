package io.github.sergeiionin.scalaleetcode
package arrays.easy

// https://leetcode.com/problems/can-place-flowers
object CanPlaceFlowers605 {
  import scala.annotation.tailrec

  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
    def cond(slots: Array[Int], rem: Int): Boolean = {
      if (slots.length == 1) {
        rem == 1
      } else if (slots.length % 2 == 0) {
        slots.length / 2 >= rem
      } else {
        slots.length / 2 + 1 >= rem
      }
    }

    val size = flowerbed.length
    
    if (n == 0) {
      true
    } else if (!cond(flowerbed, n)) {
      false
    } else if (flowerbed.length == 1) {
      flowerbed(0) == 0 && n == 1
    } else {
      @tailrec
      def iter(index: Int, count: Int): Int = {
        if ((index < size) && count < n && cond(flowerbed.slice(index, size), n - count)) {
          if (flowerbed(index) == 0) {
            if (flowerbed(index - 1) == 0) {
              if (index == size - 1) {
                count + 1
              } else if (flowerbed(index + 1) == 0) {
                flowerbed(index) = 1
                iter(index + 2, count + 1)
              } else {
                iter(index + 3, count)
              }
            } else {
              iter(index + 1, count)
            }
          } else {
            iter(index + 2, count)
          }
        } else {
          count
        }
      }

      val count = if (flowerbed(0) == 0) {
        if (flowerbed(1) == 0) {
          flowerbed(0) = 1
          iter(2, 1)
        } else {
          iter(3, 0)
        }
      } else {
        iter(2, 0)
      }
      count == n
    }
  }
}
