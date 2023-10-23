package ru.itmo.hls1.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.booking.playground.model.entity.User;
import ru.booking.playground.repository.UserRepository;

@Service
public class LoggedInUser {

        private final UserRepository userRepository;

        public LoggedInUser(UserRepository userRepository) {
                this.userRepository = userRepository;
        }

        public User getUser() {

                Authentication principal = SecurityContextHolder.getContext().getAuthentication();
                String username = principal.getName();
                return userRepository.findByUsername(username).orElseThrow();

        }

}
