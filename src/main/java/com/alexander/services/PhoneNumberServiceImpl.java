package com.alexander.services;

import com.alexander.entities.PhoneNumber;
import com.alexander.repositories.PhoneNumberRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by alex on 07.01.2017.
 */
@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

    @Inject
    private PhoneNumberRepository phoneNumberRepository;

    @Override
    public void updatePhoneNumbers(List<PhoneNumber> phones) {
        for(PhoneNumber phoneNumber : phones)
            phoneNumberRepository.save(phoneNumber);
    }
}
