package sort

import (
	"sync"
)

//快速排序
//思想：采用分治法，将当前未排序的序列，选择一个基准值，使其左边为全部较小的数，右边为全部较大的数
//在一个排序过程中，设置两个指针（左/右），两边查找交替进行，直到两个指针相遇为结束
//时间复杂度：O(nlog2n)
//空间复杂度：O(1)
func QuickSort(array []int)  {
	wg := &sync.WaitGroup{}
	wg.Add(1)
	go quickSort(wg, array, 0, len(array)-1)
	wg.Wait()
}

//将一段序列按照快排的方式排序
func quickSort(wg *sync.WaitGroup, array []int, leftIndex, rightIndex int) {
	defer wg.Done()
	if leftIndex >= rightIndex {
		return
	}
	//基准值
	key := array[leftIndex]
	tempLeftIndex := leftIndex
	tempRightIndex := rightIndex
	//当两个指针相遇时，结束
	for tempLeftIndex < tempRightIndex {
		//从右往左
		for tempLeftIndex < tempRightIndex {
			//如果遇到比标准值小的数 交换
			if array[tempRightIndex] < key {
				SwapElement(array, tempLeftIndex, tempRightIndex)
				break
			} else {
				tempRightIndex--
			}
		}
		//再从左往右
		for tempLeftIndex < tempRightIndex {
			//如果遇到比标准值大的数 交换
			if array[tempLeftIndex] > key {
				SwapElement(array, tempLeftIndex, tempRightIndex)
				break
			} else {
				tempLeftIndex++
			}
		}
	}
	//分别对两边进行排序
	wg.Add(2)
	go quickSort(wg, array, leftIndex, tempLeftIndex-1)
	go quickSort(wg, array, tempLeftIndex+1, rightIndex)
}
