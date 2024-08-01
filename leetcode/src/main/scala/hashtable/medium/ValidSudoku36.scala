package io.github.sergeiionin.scalaleetcode
package hashtable.medium

// https: //leetcode.com/problems/valid-sudoku
object ValidSudoku36 {
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    import scala.annotation.tailrec

    def getBlockIndex(i: Int, j: Int) =
      i / 3 + (j / 3) * 3

    def updateColsAndBlocks(cols: Map[Int, Set[Char]],
                           blocks: Map[Int, Set[Char]],
                           row: Array[Char],
                           i: Int, j: Int = 0): (Boolean, Map[Int, Set[Char]], Map[Int, Set[Char]]) = {
      if (row.isEmpty) {
        (true, cols, blocks)
      } else if (row.head == '.') {
        updateColsAndBlocks(
          cols,
          blocks,
          row.tail,
          i,
          j + 1
        )
      } else {
          val col = cols.getOrElse(j, Set.empty[Char])
          val k = getBlockIndex(i, j)
          val block = blocks.getOrElse(k, Set.empty[Char])

          if ((col contains row.head) || (block contains row.head)) {
            (false, cols, blocks)
          } else {
            updateColsAndBlocks(
              cols.updated(j, col + row.head),
              blocks.updated(k, block + row.head),
              row.tail,
              i,
              j+1
            )
          }
        }
      }

    def validateRow(i: Int): (Boolean, Array[Char]) =
      val row = board(i).filterNot(_ == '.')
      val rowUnique = row.toSet
      if (row.length != rowUnique.size) {
        false -> Array.empty[Char]
      } else {
        true -> board(i)
      }

    @tailrec
    def iter(i: Int, colsMap: Map[Int, Set[Char]], blocksMap: Map[Int, Set[Char]]): Boolean = {
      if (i == 9) {
        true
      } else {
        val (flag, row) = validateRow(i)
        if (!flag) {
          false
        } else {
          val (flag, cols, blocks) = updateColsAndBlocks(colsMap, blocksMap, row, i)
          if (!flag) {
            false
          } else {
            iter(i + 1, cols, blocks)
          }
        }
      }
    }

    iter(0, Map.empty[Int, Set[Char]], Map.empty[Int, Set[Char]])
  }
}
