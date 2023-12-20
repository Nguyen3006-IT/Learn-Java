package Learn_Deflater;

import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Deflater_Test {

    public static void main(String[] args) throws UnsupportedEncodingException, DataFormatException {
        DeflaterTest(); // nén dữ liệu
        InflaterTest(); // Giải nén lại dữ liệu
    }

    static String str = "chuyện người con gái Nam Xương là thiên truyện thứ 16 trong tổng số 20 truyện của Truyền kỳ mạn lục (So với 11 trong 20 truyện về phụ nữ). Truyền kỳ mạn lục (ghi chép tản mạn những chuyện kỳ lạ được lưu truyền) là tác phẩm được viết bằng chữ Hán. Tác phẩm này có chịu ảnh hưởng của truyện truyền kỳ Trung Quốc - một thể loại truyện thường có yếu tố kỳ lạ, hoang đường. Nhưng điểm khác là Nguyễn Dữ đã biết khai thác các truyện cổ dân gian, các truyền thuyết lịch sử, dã sử của Việt Nam để sáng tạo ra tác phẩm của mình. Nguồn gốc của truyện Chuyện người con gái Nam Xương xuất phát từ một truyện cổ tích dân gian tên là Vợ chàng Trương. Nam Xương nữ tử truyện hoặc Nam Xương nữ tử lục được phiên âm từ Chuyện cô con gái Nam Xương cũng là nhan đề của câu chuyện thứ 16 trong 20 truyện được ghi lại trong tác phẩm Truyền kỳ mạn lục bản chữ Việt của danh sĩ Nguyễn Dữ viết vào khoảng cuối thời nhà lê cuối thế kỷ XVI nhà Lê Sơ và đầu thời nhà Trần. Căn cứ trên một câu chuyện dân gian phản ánh một sự oan khuất của một người thiếu phụ, Nguyễn Dữ đã kể về phẩm chất và số phận của người phụ nữ trong xã hội phong kiến trọng nam khinh nữ, mặt khác phê phán, lên án lễ giáo lạc hậu khắt khe đã không cho phép những phụ nữ được bảo vệ mình. Truyện được coi là một áng";

    public static void DeflaterTest() throws UnsupportedEncodingException {
        byte[] input = str.getBytes("utf8");
        byte[] ouput = new byte[1024];

        Deflater def = new Deflater(); // khai báo
        def.setInput(input); // nén
        def.finish(); // đóng/ kết thúc

        int len = def.deflate(ouput); // lấy kích thước
        // String newStr = new String(ouput, 0, len);
        // System.out.println("Len data deflater: " + newStr); // xem dữ liệu đã giải

        // nén
        System.out.println("len0 -> " + input.length); // kích thước cuối
        System.out.println("len -> " + len); // kích thước khi nén
    }

    public static void InflaterTest() throws UnsupportedEncodingException, DataFormatException {
        // deflater
        byte[] input = str.getBytes("utf-8");
        byte[] ouput = new byte[1000];

        Deflater def = new Deflater();
        def.setInput(input);
        def.finish();

        int len = def.deflate(ouput);
        // String newStr = new String(ouput, 0, len);

        // Inflater
        // code giải nén
        byte[] outData = new byte[1000];
        Inflater infl = new Inflater(); // khái báo
        infl.setInput(ouput, 0, len); // giải nén từ 0 đến cuối.
        int lenOut = infl.inflate(outData); // lấy kích thước khi nén ra
        infl.end(); // kết thúc giải nén

        String strOuString = new String(outData, 0, lenOut, "UTF-8"); // data khi giải nén xong
        System.out.println(strOuString);

    }

}