package com.indatacore.reast_api_indatacore.dto;

import com.indatacore.reast_api_indatacore.enumeration.GenderEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private GenderEnum gender;
}
