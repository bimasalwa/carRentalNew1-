package com.example.demo.response;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Users;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAdminResponse {
    private Long user_id;
    private String username;
    private String email;

    public static GetAdminResponse toResponse(Users user) {
        GetAdminResponse response = new GetAdminResponse();
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setUser_id(user.getUser_id());
        return response;
    }

    public static List<GetAdminResponse> toListResponse(List<Users> user) {
        List<GetAdminResponse> list = new ArrayList<GetAdminResponse>();
        user.forEach((x) -> list.add(toResponse(x)));
        return list;
    }
}
