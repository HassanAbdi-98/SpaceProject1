package com.space.services;

import com.space.domains.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddress();

    Address storeAddressDetails(Address address);
}
