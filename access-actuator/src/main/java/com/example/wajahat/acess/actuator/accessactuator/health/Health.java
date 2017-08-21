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
public class Health implements Serializable {
    private String status;
    private DiskSpace diskSpace;
}
