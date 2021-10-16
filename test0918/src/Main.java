import java.io.BufferedReader;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.InputStreamReader;


class Main {

    public static void main(String args[]) throws Exception {
        Path p = Paths.get("");
        File file=new File(p.toAbsolutePath().toString()+"/img"+File.separator+"hello.txt");
        File file1=new File(p.toAbsolutePath()+"/img");
        if(!file1.exists()){
            file1.mkdirs();
        }

        System.out.println(file.createNewFile());
    }

}



