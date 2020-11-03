package sort

//归并排序
//思想：采用分治法，将现有序列一分为二，分别排序两个子序列再合并进行排序，递归解决
//时间复杂度：O(nlog2n)
//空间复杂度：O(1)
func MergeSort(array []int) []int {
	size := len(array)
	if size < 2 {
		return array
	}
	midIndex := size/2
	return merge(MergeSort(array[:midIndex]), MergeSort(array[midIndex:]))
}

//将两个有序序列排序整合
func merge(leftArr, rightArr []int) []int {
	leftSize := len(leftArr)
	rightSize := len(rightArr)
	leftIndex := 0
	rightIndex := 0
	result := make([]int, 0, leftSize+rightSize)
	for leftIndex < leftSize && rightIndex < rightSize {
		if leftArr[leftIndex] < rightArr[rightIndex] {
			result = append(result, leftArr[leftIndex])
			leftIndex++
		} else {
			result = append(result, rightArr[rightIndex])
			rightIndex++
		}
	}
	if leftSize - leftIndex > 0 {
		result = append(result, leftArr[leftIndex:]...)
	} else {
		result = append(result, rightArr[rightIndex:]...)
	}
	return result
}