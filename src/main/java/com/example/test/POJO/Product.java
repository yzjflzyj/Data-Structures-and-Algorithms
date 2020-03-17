package com.example.test.POJO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
public class Product {
   private int id;       //产品id
   private String name;  //产品名称
   private String brand; //产品品牌
}

