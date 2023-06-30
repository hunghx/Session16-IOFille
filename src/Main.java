import java.io.*;

public class Main {
    public static void main(String[] args)  {
       // File

        File file = new File("text.docx");
        File file2 = new File("F:\\demo.txt");
        System.out.println(file.exists());
        System.out.println(file2.exists());
        System.out.println(file2.length());
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        File directory = new File("resource");
        if(!directory.exists()){
//          directory.delete();
            directory.mkdir();
        }
        if (directory.exists()){
//            String[] list = directory.list();
//            for (String name: list
//                 ) {
//                System.out.println(name);
//            }
            File[] listFile = directory.listFiles();
            for (File f: listFile) {
                System.out.println(f.delete());
            }
            // ghi ra file
            // text
            char[] chars = {'a','b','c'};
            FileWriter fw = null;
            BufferedWriter bw = null;
            try {
                File fileWrite = new File("text.txt");
                if (!fileWrite.exists()){
                    fileWrite.createNewFile();
                }
                fw = new FileWriter(fileWrite,true);
                bw = new BufferedWriter(fw);
                bw.write(chars);
                bw.newLine();
                bw.flush();// Đẩy dữ liệu từ bộ nhớ đẹm sang bộ nhớ chính
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                if(fw!=null){
                    try {
                        fw.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(bw!=null){
                    try {
                        bw.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }
        // đọc file
        // text
        FileReader fr =null;
        try {
            fr =  new FileReader("text.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line=br.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
    }
}