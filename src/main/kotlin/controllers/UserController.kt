package controllers

import entities.User
import org.springframework.web.bind.annotation.*
import repositories.UserRepository

@RestController
@RequestMapping("/users")
class UserController(private val users: UserRepository.UserRepository) {

    @PostMapping
    fun addUser(@RequestBody user: User): User {
        users.save(user);
        return user;
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): User? = users.getReferenceById(id)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): String {
        return if (users.existsById(id)) {
            users.deleteById(id)
            "User removed successfully"
        } else {
            "User not found"
        }
    }
}