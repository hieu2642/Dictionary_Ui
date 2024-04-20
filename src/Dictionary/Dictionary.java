package Dictionary;

import java.util.ArrayList;

public class Dictionary {
    public static final String fileListModified = "listModified.txt";
    public static final String fileListDeleted = "listDeleted.txt";
    public static final String fileListAdded = "listAdded.txt";
    public static final String fileListRecentWord = "listRecentWord.txt";

    public static final String fileData = "dictionaries.txt";
    /**
     * listWord: lưu danh sách các từ trong file dữ liệu chuẩn.
     */
    public static ArrayList<Word> listWord = new ArrayList<>();

    /**
     * listModified: lưu danh sách các từ đã chỉnh sửa.
     */
    public static ArrayList<Word> listModified = new ArrayList<>();

    /**
     * listDeleted: lưu danh sách từ đã xóa.
     */
    public static ArrayList<Word> listDeleted = new ArrayList<>();

    /**
     * listAdded: lưu danh sách nghĩa của tôi.
     */
    public static ArrayList<Word> listAdded = new ArrayList<>();

    /**
     * Lưu danh sách các từ đã tra gần đây.
     */
    public static  ArrayList<Word> listRecentWord = new ArrayList<>();

    /**
     * lưu tối đa 30 từ gần nhất cho listRecentWord.
     * @param word Từ muốn thêm vào danh sách từ đã tra gần đây.
     */
    public static void addWordToListRecent(Word word) {
        // Check if the word already exists in the list
        for (int i = 0; i < listRecentWord.size(); i++) {
            if (listRecentWord.get(i).getTarget().equals(word.getTarget())) {
                // If it exists, remove the old entry
                listRecentWord.remove(i);
                break;
            }
        }
        // Add the new word to the beginning of the list
        listRecentWord.addFirst(word);
        // If the list exceeds 30 words, remove the oldest entry
        if (listRecentWord.size() > 30) {
            listRecentWord.removeLast();
        }
    }


    public static String listRecentToString() {
        if (listRecentWord.isEmpty()) {
            return "Bạn chưa tra từ nào!";
        }
        StringBuilder s = new StringBuilder();
        for (Word e: listRecentWord) {
            s.append(e.getTarget()).append("\n").append("-> ").append(e.getExplain().replaceAll("=", "    • ").replaceAll("\\+", ":")).append("\n\n");
        }
        return s.toString();
    }

    /**
     * trả về bản ghi danh sách từ đã chỉnh sửa.
     * @return .
     */
    public static String listModifiedToString() {
        if (listModified.isEmpty()) {
            return "Chưa có từ đã sửa";
        }
        StringBuilder s = new StringBuilder();
        for (Word e: listModified) {
            s.append(e.getTarget()).append("\n").append("-> ").append(e.getExplain()).append("\n\n");
        }
        return s.toString();
    }

    /**
     * bản ghi danh sách từ đã xóa.
     * @return .
     */
    public static String listDeletedToString() {
        if (listDeleted.isEmpty()) {
            return "Bạn chưa xóa từ nào!";
        }
        StringBuilder s = new StringBuilder();
        for (Word e: listDeleted) {
            s.append(e.getTarget()).append("\n").append("-> ").append(e.getExplain()).append("\n\n");
        }
        return s.toString();
    }

    /**
     * bản ghi danh sách từ đã thêm.
     * @return .
     */
    public static String listAddedToString() {
        if (listAdded.isEmpty()) {
            return "Bạn chưa thêm từ nào!";
        }
        StringBuilder s = new StringBuilder();
        for (Word e: listAdded) {
            s.append(e.getTarget()).append("\n").append("-> ").append(e.getExplain()).append("\n\n");
        }
        return s.toString();
    }

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
     * nếu không có từ chữa nó, trả về -1.
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
                // Find the first word that starts with the target
                while (mid > 0 && list.get(mid - 1).getTarget().startsWith(target)) {
                    mid--;
                }
                return mid;
            } else if (list.get(mid).getTarget().compareTo(target) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1; // Return -1 if the target is not found
    }

}