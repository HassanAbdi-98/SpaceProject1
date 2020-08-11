package com.space.services;

import com.space.domains.Address;
import com.space.domains.SpaceUser;
import com.space.repositories.AddressRepository;
import com.space.repositories.SpaceUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceUserServiceImpl implements SpaceUserService,AddressService {

    @Autowired
    private SpaceUserRepository spaceUserRepository;


    @Autowired
    private AddressRepository addressRepository;



    @Override
    public List<SpaceUser> getSpaceUsers() {
        return spaceUserRepository.findAll();
    }

    @Override
    public SpaceUser addSpaceUser(SpaceUser spaceUser) {
        return spaceUserRepository.save(spaceUser);
    }


    public Address storeAddressDetails(Address address){

        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }
}
