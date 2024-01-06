# Bài Tập Xét Số
***
### Đề Bài:
- Chạy 3 luồng.
- Sinh các số ngẫu nhiên và thực hiện xem số đó có chia hết cho 3 hay không. Nếu chia hết cho 3 thì đẩy qua luồng 2 và thực hiện bình phương số đó lên. Còn nếu như số đó chia hết cho 2 thì đẩy qua luồng 3 và xem số đó có chia hết cho 4 không.

***
### File Main.java:
- Thực hiện chạy, khỏi tạo các luông...

### File SharedData.java:
- Khởi tạo các các đối tượng **rad, total, index** (integer). 
=> total cho bắt đầu đếm tại 0 -> 2000, index nằm trong khoảng (1-3) vì chỉ có 3 luồng.

### File Thread1.java:
- Khởi tạo sharedData (SharedData)
- Tạo biến rad (int) random trong khoảng (0-100) + 1. cho biến total cộng thêm số rad vừa random. Thực hiện xét điều kiện và set index tương ứng với luồng muốn đẩy.
- Sau khi thực hiện xong thì nhắc các thread (phương thức `sharedData.notifyAll()`) đang trong hàng đợi (phương thức `sharedData.wait()`). Và khi đó Thread 1 sẽ nằm trong hàng đợi...

### File Thread2.java:
- Khi được thread 1 đánh thức và setIndex thành 2 thì lệnh `sharedData.wait()` nằm trong while sẽ bị vỡ và thực hiện lệnh dưới thread2 và setIndex thành 1 và tiếp tục quay lại hàm đợi...

### File Thread2.java: 
- Khi được thread 1 đánh thức và setIndex thành 3 thì lệnh `sharedData.wait()` nằm trong while sẽ bị vỡ và thực hiện lệnh dưới thread3 và setIndex thành 1 và tiếp tục quay lại hàm đợi...


=> Sau khi tất cả thread nằm stop thì chương trình chua được kết thúc vì thế ta vẫn dùng dòng lệnh cuối vào mỗi thread đang chạy.

```
synchronized (sharedData) {
    sharedData.notifyAll();
}
```