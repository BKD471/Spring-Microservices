package com.example.Department.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {

    private Date timeStamp;

    private String message;

    private String details;
}
