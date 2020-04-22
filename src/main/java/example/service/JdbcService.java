package example.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class JdbcService {
    public void  getById(Long id){
        System.out.println("getById"+id+")");
    }
}
