package sort

import "testing"

func TestBubbleSort(t *testing.T) {
	array := GenerateRandomArray(10, 30)
	t.Logf("Original Array: %v", array)
	BubbleSort(array)
	t.Logf("Sorted Array: %v", array)
}

func TestSelectionSort(t *testing.T) {
	array := GenerateRandomArray(2, 30)
	t.Logf("Original Array: %v", array)
	SelectionSort(array)
	t.Logf("Sorted Array: %v", array)
}

func TestInsertSort(t *testing.T) {
	array := GenerateRandomArray(15, 30)
	t.Logf("Original Array: %v", array)
	InsertSort(array)
	t.Logf("Sorted Array: %v", array)
}

func TestMergeSort(t *testing.T) {
	array := GenerateRandomArray(15, 30)
	t.Logf("Original Array: %v", array)
	array = MergeSort(array)
	t.Logf("Sorted Array: %v", array)
}

func TestQuickSort(t *testing.T) {
	array := GenerateRandomArray(15, 30)
	t.Logf("Original Array: %v", array)
	QuickSort(array)
	t.Logf("Sorted Array: %v", array)
}

