package com.example.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data 

@Getter 
@Setter 
public class MemberDTO {
    private String email_id;
    private String password; 
    private String name; 
    private String tel;
    private String type_code; 
}
/*    public MemberDTO() {
    } 

    public MemberDTO(String email_id, String hashedPassword, String tel, String name) {
        this.email_id = email_id;
        this.password = hashedPassword; 
        this.tel = tel;
        this.name = name;
    }  
 
    @Override
    public String toString() {
        return "{\"email_id\":\"" + email_id + "\", \"password\":\"[HIDDEN]\", \"tel\":\"" + tel + "\", \"name\":\""
                + name + "\"}";
    } 
}
*/