package Dictionary;

import java.util.ArrayList;

public class LookupList {
    /**
     * tìm TỪ (trả về word) trong 1 list cho trước
     * dùng TÌM KIẾM NHỊ PHÂN với dữ liệu từ file dictionaries.txt
     * dùng tìm kiếm tuần tự đối với các list khác, do ưu tiên các từ được thêm vào gần đây trước.
     * @param target từ cần tìm
     * @param list list tìm kiếm từ.
     * @return word
     */
    public static Word Lookup(String target, ArrayList<Word> list) {
        if (list == Dictionary.listWord) {
            int left = 0;
            int right = list.size() - 1;
            int mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (list.get(mid).getTarget().compareTo(target) == 0) {
//                System.out.println("vi tri: " + mid);
                    return list.get(mid);
                } else if (list.get(mid).getTarget().compareTo(target) > 0) {
                    right = mid - 1;
                } else if (list.get(mid).getTarget().compareTo(target) < 0) {
                    left = mid + 1;
                }
            }
            return null;
        } else {
            for (Word word : list) {
                if (word.getTarget().equals(target.trim())) {
                    return word;
                }
            }
        }
        return null;
    }

    /**
     * tìm VỊ TRÍ từ trong 1 list cho trước , dùng tìm kiếm nhị phân.
     * nếu không có từ đó, trả về vị trí BÉ NHẤT chứa nó
     * nếu không có từ chữa nó, trả về từ gần đó.
     * @param target từ cần tìm
     * @param list list tìm kiếm từ.
     * @return vị trí
     */
    public static int findFlag(String target, ArrayList<Word> list) {
        int left = 0;
        int right = list.size() - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (list.get(mid).getTarget().startsWith(target)) {
                while (mid > 0) {
                    mid = mid - 1;
                    if (! list.get(mid).getTarget().startsWith(target)) {
                        return mid + 1;
                    }
                }
                if (mid == 0) return 0;
            } else if (list.get(mid).getTarget().compareTo(target) > 0) {
                right = mid - 1;
            } else if (list.get(mid).getTarget().compareTo(target) < 0) {
                left = mid + 1;
            }
        }
        return left > 1 ? left - 1 : 0;
    }
}
