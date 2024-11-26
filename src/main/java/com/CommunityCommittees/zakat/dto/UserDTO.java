package com.CommunityCommittees.zakat.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String user_name;
    private String full_name;
    private Integer status;
    private String add_by;
    private String password;
    private LocalDateTime add_date;
}
