package com.bookStore.data.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookOrderRequest {


    private List<Integer> bookIdList;
    private String userName;
}
