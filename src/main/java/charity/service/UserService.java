package charity.service;


import charity.entity.User;
import charity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void save(User user){
        userRepository.save(user);
    }

    public long getAllParticipantsAmount(){
        return userRepository.count();
    }
}
