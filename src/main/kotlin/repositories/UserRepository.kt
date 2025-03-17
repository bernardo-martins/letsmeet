package repositories

import entities.User
import org.springframework.data.jpa.repository.JpaRepository

class UserRepository {

    interface UserRepository : JpaRepository<User, Long>

}