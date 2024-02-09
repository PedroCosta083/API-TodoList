package pedro.costa.TaskManagerAPI.controller;

import org.springframework.web.bind.annotation.*;
import pedro.costa.TaskManagerAPI.entities.UserEntitie;
import pedro.costa.TaskManagerAPI.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    List<UserEntitie> create(@RequestBody UserEntitie user){
        return userService.create(user);
    }
    @GetMapping
    List<UserEntitie>list(){
        return userService.list();

    }
    @PutMapping
    List<UserEntitie>update(@RequestBody UserEntitie user){
        return userService.update(user);

    }
    @DeleteMapping("{id}")
    List<UserEntitie> delete(@PathVariable("id") Long id){
        return userService.delete(id);
    }
}
