package com.example.wajahat.acess.actuator.accessactuator.health;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by wajahat on 21/8/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiskSpace implements Serializable {
    private String status;
    private Long total;
    private Long free;
    private Long threshold;
}
