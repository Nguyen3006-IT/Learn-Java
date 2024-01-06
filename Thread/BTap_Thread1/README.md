# Tóm Tắt Bài Tập
***
### Bài này nói về 1 ví dụ như sau:
    - Cho 10 người tới 1 ngân hàng rút tiền (trong tài ngân hàng này hiện tại có 10 triệu). Nếu 10 người này, mỗi người rút ra 10 triệu cùng 1 lúc nếu ngân hàng xử lý 1 lúc rút 10 lần thì ngân hàng sẽ bị mất tiền. Vì thế trong bài tập này muốn nói tới vấn đề đồng bộ.
***
### Tạo file MyBank.java:
    - Khởi tạo đối tượng **money** (integer) 
    - Tạo hàm **withDraw** và truyền 2 tham số. Hàm này thực hiện rút tiền. 
    => Nếu hàm này không báo **synchronized** thì sẽ xảy ra trường hợp trên là ngân hàng sẽ bị mất tiền.

### Tạo file WithDrawThread.java:
    - Khởi tạo đối tượng **name** (String) và **mybank** (MyBank) 
    - Tạo hàm run() để 5 đối tượng và thực hiện rút 800đ. Thực hiện đa luồng.

=> Nếu ta khai báo **synchronized** trong hàm đang thực hiện cần đồng bộ thì tất cả đối tượng khi trỏ tới hàm này phải vào hàng đợi.
