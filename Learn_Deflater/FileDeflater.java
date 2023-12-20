package Learn_Deflater;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterInputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import java.util.zip.InflaterOutputStream;

public class FileDeflater {
    // main
    public static void main(String[] args) throws IOException {
        // Loại nén (Deflater) file
        FileDeflaterInput(); // Đây là loại 1
        FileDeflaterOutput(); // Đây là loại 2

        // Loại giải nén (Inflater) file
        FileInflaterInput(); // Đây là loại 1
        FileInflaterOutput(); // Đây là loại 2

        // đọc sự giống nhau và khác nhau bên file "DocsFlater.txt"
    }

    // Deflater 1
    public static void FileDeflaterInput() throws IOException {
        FileInputStream InFile = null;
        FileOutputStream OutFile = null;
        DeflaterInputStream FileDeflater = null;

        try {
            InFile = new FileInputStream(
                    "C:/Users/Admin/Desktop/baitap Java/Learn_Deflater/DocsFlater.txt");
            OutFile = new FileOutputStream(
                    "C:/Users/Admin/Desktop/baitap Java/Learn_Deflater/Docs_Delater1.zip");

            FileDeflater = new DeflaterInputStream(InFile);

            int code;
            while ((code = FileDeflater.read()) != -1) {
                OutFile.write(code);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                InFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                OutFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            FileDeflater.close();
        }
    }

    // Deflater 2
    public static void FileDeflaterOutput() throws IOException {
        FileInputStream InFile = null;
        FileOutputStream OutFile = null;
        DeflaterOutputStream FileDeflaterOut = null;

        try {
            InFile = new FileInputStream(
                    "C:/Users/Admin/Desktop/baitap Java/Learn_Deflater/DocsFlater.txt");
            OutFile = new FileOutputStream(
                    "C:/Users/Admin/Desktop/baitap Java/Learn_Deflater/Docs_Delater2.zip");

            FileDeflaterOut = new DeflaterOutputStream(OutFile);

            int code;
            while ((code = InFile.read()) != -1) {
                FileDeflaterOut.write(code);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (FileDeflaterOut != null) {
                try {
                    FileDeflaterOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    InFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    OutFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Inflater 1
    public static void FileInflaterInput() throws IOException {
        InflaterInputStream FileInflaterIn = null;
        FileInputStream InFile = null;
        FileOutputStream OutFile = null;

        try {
            InFile = new FileInputStream(
                    "C:/Users/Admin/Desktop/baitap Java/Learn_Deflater/Docs_Delater1.zip");
            OutFile = new FileOutputStream(
                    "C:/Users/Admin/Desktop/baitap Java/Learn_Deflater/Docs_Inlater1.txt");
            FileInflaterIn = new InflaterInputStream(InFile);

            int code;
            while ((code = FileInflaterIn.read()) != -1) {
                OutFile.write(code);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (FileInflaterIn != null) {
                try {
                    FileInflaterIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    InFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    OutFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // Inflater 2
    public static void FileInflaterOutput() throws IOException {
        InflaterOutputStream FileInflaterOut = null;
        FileInputStream InFile = null;
        FileOutputStream OutFile = null;

        try {
            InFile = new FileInputStream(
                    "C:/Users/Admin/Desktop/baitap Java/Learn_Deflater/Docs_Delater2.zip");
            OutFile = new FileOutputStream(
                    "C:/Users/Admin/Desktop/baitap Java/Learn_Deflater/Docs_Inlater2.txt");
            FileInflaterOut = new InflaterOutputStream(OutFile);

            int code;
            while ((code = InFile.read()) != -1) {
                FileInflaterOut.write(code);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (FileInflaterOut != null) {
                try {
                    FileInflaterOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    InFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    OutFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
