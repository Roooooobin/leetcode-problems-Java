import java.util.Arrays;

public class MyHeap {

    //    int[] a = new int[] {50, 40, 100, 2, 1, 110, 888, 91, 3, 45};

    int[] a = new int[] {45, 50, 40, 3, 100};

    public int[] buildHeap() {

        int n = a.length;
        int[] heap = new int[n + 1];
        for (int i = 0; i < n; i++) {
            heap[i + 1] = a[i];
            int j = i + 1;
            while (j > 1) {
                int r = j / 2;
                if (heap[r] < heap[j]) {
                    int t = heap[r];
                    heap[r] = heap[j];
                    heap[j] = t;
                }
                j >>= 1;
            }
        }
        return heap;
    }

    public int[] heapSort(int[] heap) {

        int n = heap.length - 1;
        int t = 0;
        for (int idx = n; idx > 1; idx--) {
            t = heap[1];
            heap[1] = heap[idx];
            heap[idx] = t;
            int r = 1;
            while (r * 2 < idx) {

                int v = heap[r];
                int childMax = heap[r * 2];
                int childMaxIdx = r * 2;
                if (r * 2 + 1 < idx) {
                    if (childMax < heap[r * 2 + 1]) {
                        childMax = heap[r * 2 + 1];
                        childMaxIdx = r * 2 + 1;
                    }
                }
                if (v > childMax) {
                    break;
                } else {
                    heap[r] = heap[childMaxIdx];
                    heap[childMaxIdx] = v;
                }
                r = childMaxIdx;
            }
        }
        return heap;
    }

    public static void main(String[] args) {

        MyHeap h = new MyHeap();
        int[] heap = h.buildHeap();
        System.out.println(Arrays.toString(heap));
        System.out.println(Arrays.toString(h.heapSort(heap)));
    }
}

class Solution {

    int[] a;

    public int[] buildHeap() {

        int n = a.length;
        int[] heap = new int[n + 1];
        for (int i = 0; i < n; i++) {
            heap[i + 1] = a[i];
            int j = i + 1;
            while (j > 1) {
                int r = j / 2;
                if (heap[r] < heap[j]) {
                    int t = heap[r];
                    heap[r] = heap[j];
                    heap[j] = t;
                }
                j >>= 1;
            }
        }
        return heap;
    }

    public int[] heapSort(int[] heap) {

        int n = heap.length - 1;
        int t = 0;
        for (int idx = n; idx > 1; idx--) {
            t = heap[1];
            heap[1] = heap[idx];
            heap[idx] = t;
            int r = 1;
            while (r * 2 < idx) {

                int v = heap[r];
                int childMax = heap[r * 2];
                int childMaxIdx = r * 2;
                if (r * 2 + 1 < idx) {
                    if (childMax < heap[r * 2 + 1]) {
                        childMax = heap[r * 2 + 1];
                        childMaxIdx = r * 2 + 1;
                    }
                }
                if (v > childMax) {
                    break;
                } else {
                    heap[r] = heap[childMaxIdx];
                    heap[childMaxIdx] = v;
                }
                r = childMaxIdx;
            }
        }
        return heap;
    }

    public int[] sortArray(int[] nums) {

        a = nums;
        int[] tmp = heapSort(buildHeap());
        int[] res = new int[nums.length];
        System.arraycopy(tmp, 1, res, 0, nums.length);
        return res;
    }
}

class SolutionHeap {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    public void heapSort(int[] nums) {
        int len = nums.length - 1;
        buildMaxHeap(nums, len);
        for (int i = len; i >= 1; --i) {
            swap(nums, i, 0);
            len -= 1;
            maxHeapify(nums, 0, len);
        }
    }

    public void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; --i) {
            maxHeapify(nums, i, len);
        }
    }

    public void maxHeapify(int[] nums, int i, int len) {
        for (; (i << 1) + 1 <= len; ) {
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;
            int large;
            if (lson <= len && nums[lson] > nums[i]) {
                large = lson;
            } else {
                large = i;
            }
            if (rson <= len && nums[rson] > nums[large]) {
                large = rson;
            }
            if (large != i) {
                swap(nums, i, large);
                i = large;
            } else {
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
