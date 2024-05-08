# My Dictionaty By Group 1-19

## Tên các thành viên:

- Lẻo Tiến Thắng
- Nguyễn Thị Liễu
- Ngô Đức Hiếu

## Demo

![Demo](https://github.com/hieu2642/Dictionary_Ui/assets/102776233/a9d7d7ef-ba21-468f-a24f-a5e34b080c81)
## Library

[Soure Lib](https://sourceforge.net/projects/freetts/files/)

![image](https://github.com/hieu2642/Dictionary_Ui/assets/102776233/53b4fa31-4e45-4792-bc83-f9ff141ceba6)

## Main features

- Thêm từ:
```sh
  Thêm từ vào trong listAdded:
   + Từ đã được thêm trước đây: sửa nghĩa
   + Từ chưa được thêm : thêm từ.
   + Từ trong listAdded khi tra cứu thì nghĩa sẽ được hiển thị cùng nghĩa của dữ liệu.
```
- Sửa từ:
```sh
  Điều chỉnh từ lần lượt theo các nguyên tắc:
    + Nếu từ đã chỉnh sửa trước đây (nằm trong listModified) thì chỉnh sửa phần giải thích trong listModified
    + Nếu từ chưa từng chỉnh sửa, thêm nghĩa mới cho từ và thêm từ đó vào trong listModified.
    + Nếu không có trong danh sách chỉnh sửa hoặc trong dữ liệu thì thông báo "Chưa có dữ liệu về từ này!"
```
- Xóa từ:
```sh
  Xóa từ theo nguyên tắc:
   + Nếu là từ đã xóa thì thông báo cho người dùng, kết thức hàm.
   + Nếu là từ trong danh sách chỉnh sửa thì xóa từ đó khỏi danh sách chỉnh sửa.
   + Nếu từ đó chỉ cỏ trong dữ liệu ( file dictionaries ) thì thêm từ đó vào danh sách từ đã xóa
   + Khi tìm kiếm dựa vào dánh sách này để không hiển thị nữa
```
- Tra từ:
```sh
  Tra từ lần lượt theo các nguyên tắc:
   + Nếu từ trong danh sách từ đã xóa, chỉ hiển thị nghĩa của tôi
   + Hiển thị từ trong danh sách "Từ của tôi" trước
   + Hiển thị nghĩa chỉnh sửa nếu có (được lưu trong listModified)
   + Nếu từ không được lưu trong listModified: hiển thị từ lưu trong dữ liệu - tức file dictionaries.
   + Nếu từ không có trong dữ liệu, đưa ra thông báo.
```
- Game
![image](https://github.com/hieu2642/Dictionary_Ui/assets/102776233/7cd7d0a8-88b9-4dff-b974-89307b3e5c08)

```sh
  Chơi game theo các nguyên tắc:
    + Nhấn Start để bắt đầu hiện gợi ý từ
    + Nhấn check để kiểm tra xem đã đúng hay
    + Nhấn Next để sang câu kế tiếp
    + Nếu đúng sẽ hiển thị "true" cùng đáp án
    + Nếu sai sẽ hiển thị "false" cùng đáp án
```
- Phát âm tiếng anh: Phát âm từ tiếng anh được chọn sử dụng thư viện phát âm của Java
- Giao đồ họa thân thiện và dễ sử dụng tích hợp các tính năng cơ bản trên, ngoài ra còn có thêm tính năng: Gợi ý từ đang tra, dịch văn bản bằng Google Translate API, lấy ví dụ cho từ bằng Google Oxford.
- Sử dụng thuật toán tìm kiếm nhị phân

## Used API

- Google Translate API: online translate [Soure API Translate](https://script.google.com/macros/s/AKfycbzzimSXyRhh4zy2rePQ-cTwisM1WdYZRVc1x1UVRj0-NCV2DHkprugTqvoOsh95APWy/exec)
- Google Oxford API

## Cây kế thừa 

![package](https://github.com/hieu2642/Dictionary_Ui/assets/102776233/4efde6bf-090e-4225-98e2-601dc926ce29)
