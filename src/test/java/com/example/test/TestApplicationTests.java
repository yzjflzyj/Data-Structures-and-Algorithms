package com.example.test;

import com.example.test.POJO.Product;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.Cleanup;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@SpringBootTest
class TestApplicationTests {

    @Test
    void contextLoads() {
        //链式构造对象
        Product product = Product.builder().id(1).name("可乐").brand("百事").build();
    }

    @Test
    @SneakyThrows
    public void openTxt(String fileName) {
        FileReader fileReader = new FileReader(fileName);
    }

    @Test
    public void heap() {
        List<Product> productList = new ArrayList<>();
        while (true) {
            productList.add(Product.builder().build());
        }
    }

    @SneakyThrows
    @Test
    public void sparseArr() {
        //二维数组，转稀疏数组
            @Cleanup FileWriter fileWriter=null;
            fileWriter = new FileWriter("C:\\Users\\yamzh\\Desktop\\稀疏数组.txt");
            int sum = 0;
            //二维数组
            int[][] chaseArr = new int[11][11];
            chaseArr[1][1] = 7;
            chaseArr[2][3] = 8;
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 11; j++) {
                    System.out.printf("%d\t", chaseArr[i][j]);
                    fileWriter.write(chaseArr[i][j]+"\t");
                    if (chaseArr[i][j] != 0) {
                        sum++;
                    }
                }
                fileWriter.write("\n");
                System.out.println();
            }

            //稀疏数组
            int[][] sparseArr = new int[3][sum+1];
            sparseArr[0][0] = 11;
            sparseArr[0][1] = 11;
            sparseArr[0][2] = sum;
            int count = 0;
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 11; j++) {
                    System.out.printf("%d\t", chaseArr[i][j]);
                    if (chaseArr[i][j] != 0) {
                        count++;
                        sparseArr[count][0] = i;
                        sparseArr[count][1] = j;
                        sparseArr[count][2] = chaseArr[i][j];
                    }
                }
                System.out.println();
            }
            for (int i = 0; i <= sum; i++) {
                System.out.printf("%d\t%d\t%d\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
                fileWriter.write(sparseArr[i][0]+"\t"+sparseArr[i][1]+"\t"+sparseArr[i][2]);
                fileWriter.write("\n");
            }
    }

}
