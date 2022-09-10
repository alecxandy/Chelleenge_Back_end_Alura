package br.com.alexandre.Desafio.Back.end.config;

import br.com.alexandre.Desafio.Back.end.domain.UserModel;
import br.com.alexandre.Desafio.Back.end.repository.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final UserModelRepository userModelRepository;

    public UserDetailsServiceImpl(UserModelRepository userModelRepository) {
        this.userModelRepository = userModelRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userModelRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found" + username));
        return userModel;
    }
}
