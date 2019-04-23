package pl.cms.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cms.post.Post;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean save(User user) {
        String email = user.getEmail();
        user = userRepository.findUserByEmail(email);
        if (user == null) {
            userRepository.save(user);
            return true;

        }
        return false;
    }

    public void setEmail(String email) {

    }

}
