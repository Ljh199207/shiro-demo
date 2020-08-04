package com.example.service;

import com.example.config.UserOnline;

import java.util.List;

public interface SessionService {
    List<UserOnline> list();

    boolean forceLogout(String sessionId);
}
