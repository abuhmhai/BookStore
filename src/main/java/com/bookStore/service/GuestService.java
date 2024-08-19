package com.bookStore.service;

import com.bookStore.model.GuestDtls;

public interface GuestService {
    public GuestDtls createGuest(GuestDtls guest);
    public boolean checkEmail(String email);
}
