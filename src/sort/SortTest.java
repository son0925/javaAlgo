package sort;

import java.util.Arrays;

public class SortTest {

	public static void main(String[] args) {
		int[] arr = {5,3,2,7,4,8,1,10,9,6};
//		bubbleSort(arr);
//		optimizedBubbleSort(arr);
//		insertionSort(arr);
//		selectionSort(arr);
//		shellSort(arr);
		mergeSort(arr,0,arr.length-1);
		System.out.println("결과 : " + Arrays.toString(arr));

	}
	
	// 시간 복잡도
	// worst: O(n^2)
	// best : O(n^2)
	// average: O(n^2)
	public static int[] bubbleSort(int[] arr) {
		// 정렬 과정이 거품이 수면으로 올라오는 모습과 흡사하여 지어진 이름
		// 라운드별 i 번째가 제일 큰 숫자 다음 라운드는 i--
		for (int i = arr.length-1; i>=0; i--) {
			for (int j = 0; j < i; j++) {
				// j, j+1을 비교하여 더 큰 숫자를 뒤에 놔두며 한바퀴를 돈다
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
		// 장점
		// 1. 추가적인 메모리 소비가 적다
		// 2. 구현이 매우 쉽다.
		// 3. 안정정렬이 가능하다
		// 단점
		// 교환 과정이 많아 많은 시간이 소비된다
	}
	
	public static int[] optimizedBubbleSort(int[] arr) {
		// 버블 정렬 최적화
		boolean swapped;
		for (int i = arr.length-1; i >= 0; i--) {
			swapped = false;
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			// 바뀌지 않았다면 종료하기
			if (!swapped) {
				break;
			}
		}
		
		return arr;
	}
	
	// 시간 복잡도
	// worst: O(N^2)
	// best : O(N)
	// average: O(N^2) <평균 시간복잡도가 O(N^2)중에서는 가장 빠르다
	public static int[] insertionSort(int[] arr) {
		// 현재 비교하는 타겟(i)와 비교(j,j-1...0)하는 원소들을 정렬하는 알고리즘이다
		// 현재 i -1 부터 비교를 하기 때문에 1부터 시작
		for (int i = 1; i < arr.length; i++) {
			int target = arr[i];
			int j = i - 1;
			// j >= 0가 먼저 앞에 와야함 - j = -1 일 때 arr[j]를 확인했을 때 오류가 생김
			while (j >= 0 && arr[j] > target) {
				// j + 1은 현재 타겟이 있는 위치
				arr[j+1] = arr[j];
				j--;
			}
			// 반복문을 탈출 했을 때는 j번째 값보다 크기 때문에 j+1위치에 target값을 저장한다
			arr[j+1] = target;
		}
		return arr;
		// 장점
		// 추가적인 메모리 소비가 작다
		// 거의 정렬된 경우 매우 효율적이다 최선의 경우 O(N)의 시간복잡도
		// 안정정렬이 가능하다
		// 단점
		// 배열 크기가 역순에 가까울 수록 비효율적이다 최악의 경우 O(N^2)의 시간 복잡도를 가진다
		// 데이터의 상태에 따라 편차가 매우 크다
	}
	
	// 시간 복잡도
	// worst: O(n^2)
	// best : O(n^2)
	// average O(N^2)
	public static int[] selectionSort(int[] arr) {
		// 삽입정렬
		// 주어진 리스트의 최소값을 찾는다
		// 현재 라운드 i번째의 위치의 값과 최소값의 위치를 바꾼다
		// i는 최소값을 놔둘 위치
		for (int i = 0; i < arr.length; i++) {
			// j는 최소값을 찾는 for문
			int minIdx = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			// swap하기
			int temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;
		}
		return arr;
		// 장점
		// 추가적인 메모리 소비가 작다
		// 단점
		// 시간복잡도가 O(N^2)
		// 안정 정렬이 아니다
		// [B2,B1,A,C] => A < B1 , B2 < C라고 할 때 정렬을 하면 A, B2, B1, C로 정렬이 된다 같은 값일 때 이름 순서로 정렬을 하지 못한다는 단점이 있다
		// 이러한 상태를 불안정정렬이라고 한다
	}
	
	public static int[] shellSort(int[] arr) {
		// 쉘 정렬이란 삽입 정렬의 장점을 극대화하고 단점을 최소화 하는 정렬이다
		// 간격을 설정하고 간격별로 분류된 서브 리스트에 대해 삽입정렬을 한다
		// 정렬이 끝나면 간격을 줄인다
		// 간격이 1이 될 때까지 계속 반복한다
		
		// 간격 구하기
		for (int gap = arr.length; gap > 0; gap/=2) {
			for (int i = gap; i < arr.length; i++) {
				int temp = arr[i];
				int j = i - gap;
				System.out.println("temp : " + temp + " arr[j] : " + arr[j] + " gap : " + gap);
				while (j >= 0 && arr[j] > temp) {
					arr[j+gap] = arr[j];
					j-=gap;
				}
				arr[j+gap] = temp;
			}
		}
		return arr;
	}
	
	// 합병 정렬
	// 안정정렬의 하나이며 분할 정복 알고리즘의 하나이다
	// 문제를 작은 2개로 분리하고 각각 해결한 다음 결과를 모아서 원래 문제를 해결하는 알고리즘이다
	
	// 풀이 과정
	// 리스트 길이가 0 혹은 1이면 정렬된 것으로 본다
	// 그렇지 않은 경우 리스트를 절반으로 잘라서 비슷한 길이의 두 부분의 리스토로 나눈다
	// 각 부분 리스트를 제귀적으로 합병 정렬을 이용해 정렬한다
	// 두 부분 리스트를 하나의 리스트로 합친다
	
	// 추가 지식
	// 추가적인 리스트가 필요하다
	// 각 부분 배열을 정렬할 때도 합병 정렬을 순환적으로 호출하여 적용해야 한다
	// 실제로 정렬이 이루어지는 부분은 2개의 리스트를 합병하는 단계이다 -> 합병할 때 정렬이 이루어진다
	
	public static void merge(int[] list, int left, int mid, int right) {
		// i,j List의 0번째, right = len
		// k sortList의 담는 변수
		int i,j,k;
		i = left;
		j = mid+1;
		k = left;
		int[] sortList = new int[list.length];
		
		// 리스트를 2분할해서 a리스트의 0번이 list의 mid까지 가고 b리스트의 j번이 length가 되기 전까지
		while (i<=mid && j<=right) {
			// 만약 a리스트 i번째가 b리스트 j번째보다 낮거나 같을 때 sortList에 넣어라
			if(list[i] <= list[j]) {
				sortList[k++] = list[i++];
			}
			else {
				sortList[k++] = list[j++];
			}
		}
		
		
		// 반복문 종료 후 남은 리스트 정렬 리스트에 넣기
		if (i > mid) {
			for(int idx = j; idx <= right; idx++) {
				sortList[k++] = list[idx];
			}
		}
		
		else {
			for (int idx = i; idx <= mid; idx++) {
				sortList[k++] = list[idx];
			}
		}
		
		// 다시 list 배열에 담기
		// 처음 index를 left로 설정하는 이유는 해당 배열의 최대로 작을 때 위치이다
		for (int idx = left; idx <= right; idx++) {
			list[idx] = sortList[idx];
		}
		System.out.println(Arrays.toString(list));
	}
	
	public static void mergeSort(int[] list, int left, int right) {
		int mid;
		
		// 리스트 크기가 1이 될때까지 재귀함수 호출
		if (left < right) {
			mid = (left + right) / 2;
			mergeSort(list,left,mid);
			mergeSort(list,mid+1,right);
			merge(list,left,mid,right);
		}
	}
	
	

}
