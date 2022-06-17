/* https://leetcode.cn/problems/duplicate-zeros/ */
public class s44 {
//    public void duplicateZeros(int[] arr) {
//        int n = arr.length;
//        int offset = 0;
//        for (int i = 0; i < n; i++) {
//            if (arr[i] == 0 && i + offset < n - 1) {
//                offset++;
//            }
//        }
//        System.out.println(offset);
//        for (int i = n - 1; i >= 0; i--) {
//            arr[i] = arr[i - offset];
//            if (arr[i] == 0 && offset > 0) {
//                if(i < n - 1) {
//                    arr[--i] = 0;
//                }
//                offset--;
//            }
//        }
//
//    }
public void duplicateZeros(int[] arr) {
    int n = arr.length;
    int top = 0;
    int i = -1;
    while (top < n) {
        i++;
        if (arr[i] != 0) {
            top++;
        } else {
            top += 2;
        }
    }
    int j = n - 1;
    if (top == n + 1) {
        arr[j] = 0;
        j--;
        i--;
    }
    while (j >= 0) {
        arr[j] = arr[i];
        j--;
        if (arr[i] == 0) {
            arr[j] = arr[i];
            j--;
        }
        i--;
    }
}
}
