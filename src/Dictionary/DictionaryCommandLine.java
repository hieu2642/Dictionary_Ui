package Dictionary;
import java.util.NoSuchElementException;

public class DictionaryCommandLine {
    /**
     * In danh sách các từ.
     */
    public static void showAllWords() {
        if (Dictionary.listWord == null || Dictionary.listWord.isEmpty()) {
            System.out.println("Chưa có dữ liệu");
            return;
        }
        int count = 1;
        for (Word s : Dictionary.listWord) {
            System.out.println(count++ + ". " + s);
        }
    }
    /**
     * In danh sách các từ đã chỉnh sửa.
     */
    public static void dictionaryStart() {
        DictionaryManagement.insertFromFile();
    }

    public static void dictionaryFinish() throws NoSuchElementException {
        DictionaryManagement.updateData();
    }
}
