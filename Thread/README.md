# Chương Này Học Về Đa Luồng (Thread) 
- Có thể hiểu là trong một thời điểm có nhiều luồng chạy cùng lúc.
***

### Một số phương thức quan trọng có sẵn trong lớp Thread của ngôn ngữ Java.
`public void start()`: Bắt đầu thread trong một path riêng rẽ, sau đó triệu hồi phương thức run() trên đối tượng Thread này. 

`public void run()`: Nếu đối tượng Thread này được khởi tạo bởi sử dụng một đối tượng Runnable, phương thức run() sẽ được triệu hồi.

`public final void setName(String name)`: Thay đổi tên của đối tượng Thread. Cũng có một phương thức getName() để thu nhận tên này.

`public final void setPriority(int priority)`: Thiết lập quyền ưu tiên của đối tượng Thread này. Giá trị có thể có nằm trong khoảng từ 1 tới 10.

`public final void setDaemon(boolean in)`: Một tham số true chứng tỏ Thread này như là một Daemon thread.
==> Daemon thread (luồng daemon) là một loại luồng đặc biệt được thiết kế để chạy trong nền và tự động kết thúc khi tất cả các luồng không daemon đã kết thúc. Điều này có nghĩa là nếu không còn luồng không daemon nào còn sống, thì chương trình sẽ thoát mà không cần chờ đến khi tất cả các daemon thread cũng kết thúc.

`public final void join(long millis)`: Thread hiện tại triệu hồi phương thức này trên thread thứ hai, làm cho Thread hiện tại block tới khi thread thứ hai kết thúc hoặc sau một số lượng mili giây đã xác định.

`public void interrupt()`: Ngắt thread này, làm cho nó tiếp tục thực thi nếu nó bị block vì bất cứ lý do gì.

`public final boolean isAlive()`: Trả về true nếu thread này là còn sống (còn hoạt động), mà là bất cứ thời gian nào sau khi thread này đã được bắt đầu nhưng trước khi nó run tới khi kết thúc.

`public static void yield()`: Làm cho thread đang chạy hiện tại chuyển tới bất kỳ thread nào khác có cùng quyền ưu tiên mà đang đợi để được ghi lịch trình.

`public static void sleep(long millis)`: Làm cho thread đang chạy hiện tại block trong ít nhất một **số lượng mili giây** đã xác định.

`public static boolean holdsLock(Object x)`: Trả về **true** nếu thread giữ lock trên Object đã cho
=> Phương thức này kiểm tra xem luồng hiện tại có nắm giữ khóa (lock) cho đối tượng x hay không.

`public static Thread currentThread()`: Trả về một tham chiếu tới thread đang chạy hiện tại, mà là thread mà triệu hồi phương thức này.

`public static void dumpStack()`: In ra stack trace cho thread đang chạy hiện tại. Nó rất hữu ích khi debugging một ứng dụng đa luồng.