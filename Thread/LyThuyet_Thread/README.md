# Lý Thuyết Về Đa Luồng - MultiThreading (Java)
***

### File Main.java:
- Có hết 3 cách viết Thread. Nhưng phổ biến nhất là cách 1 khi làm dự án, cách 2 và cách 3 tùy vào các dạng dự án.

### File Thread2.java:
- Được file này (cách 2) được tạo ra để phát triển dự án khi dự án có có nhiều luồng xử lý và cần đồng bộ. 
    + Trong file này được kế thừa từ lớp Thread (mới có thể .start()). Hàm run() (nhớ đầu hàm khai báo **@Override**) được tạo khi có lắng nghe thread.start() thì sẽ trỏ tới hàm này và thực hiện.  

* Có thể xem thực hành tại Folder phần **BTap_Thread1** 

### File Thread3.java:
- Cách này như cách 1 và cách 2 hợp lại thành 1. Có thể tham khảo thêm cách này.

