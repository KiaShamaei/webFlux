package com.springweb.flux.dto;


import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class MyResponse {
    private Date date=new Date();
    @NonNull
    private int output;
}
