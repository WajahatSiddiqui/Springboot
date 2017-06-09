package com.wajahat.learn.springboot.lombok.springbootlombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by wajahat on 9/6/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerAge {
    private Long id;
    private String name;
}
