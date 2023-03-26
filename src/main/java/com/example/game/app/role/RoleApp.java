package com.example.game.app.role;

import com.example.game.app.role.entity.Role;
import com.example.game.common.Result;

public interface RoleApp {
    /**
     * 创建角色
     * @param token
     * @param roleName
     * @return
     */
    Result<Role> create(String token, String roleName);
}
