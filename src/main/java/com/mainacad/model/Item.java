package com.mainacad.model;

import lombok.*;

@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Item {
    private String itemId;
    private String name;
    private String itemUrl;
    private Integer price;
    private Integer initPrice;
}
