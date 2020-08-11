package com.space.services;

import com.space.domains.SpaceUser;

import java.util.List;

public interface SpaceUserService {

    List<SpaceUser> getSpaceUsers();
    SpaceUser addSpaceUser(SpaceUser spaceUser);


}
