# Giải Thích file Main3 (có hàm trong file: ShareData.java, ThreadRandom.java, ThreadSquare.java) 
***
```
T1 = file ThreadRandom.java
T2 = file ThreadSquare.java
```

T1 => sinh số ngẫu nhiên => lập số Share Data => hiển thị T1 => gọi tới notifyAll đánh thức T2 (wait) => T2 vẫn ở trạng thái chờ (queue) => T1 chạy tới hàm wait() => T2 chạy => T2 chạy tới notifyAll() => T1 sẵn sàng => khi T2 vào wait() => T1 bắt đầu chạy ...

- Khi chạy T1 và T2 chạy hết thì chương trình chưa được kết thúc.
=> thêm lệnh synchronized
```
// stop
synchronized (sharedData) {
    sharedData.notifyAll();
}
```