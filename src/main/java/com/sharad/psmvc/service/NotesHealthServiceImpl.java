package com.sharad.psmvc.service;

import org.springframework.stereotype.Service;

@Service
public class NotesHealthServiceImpl implements NotesHealthService {
  @Override public boolean isHealthy() {
    return true;
  }
}
