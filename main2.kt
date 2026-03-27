/**
 * Project: DevToolkit
 * File: main.kt
 * Description: Entry point demonstrating clean Kotlin architecture.
 */

package devtoolkit

// Data class representing a User
data class User(
    val id: Int,
    val name: String,
    val email: String
)

// Service class handling business logic
class UserService {

    private val users = mutableListOf<User>()

    fun addUser(user: User) {
        users.add(user)
        println("User added: ${user.name}")
    }

    fun getUserById(id: Int): User? {
        return users.find { it.id == id }
    }

    fun listUsers(): List<User> {
        return users
    }
}

// Utility object
object Logger {
    fun info(message: String) {
        println("[INFO] $message")
    }

    fun error(message: String) {
        println("[ERROR] $message")
    }
}

// Main entry point
fun main() {
    Logger.info("Application started")

    val userService = UserService()

    val user1 = User(1, "Nicholas", "nicholas@example.com")
    val user2 = User(2, "Alex", "alex@example.com")

    userService.addUser(user1)
    userService.addUser(user2)

    Logger.info("Fetching all users...")
    val users = userService.listUsers()

    users.forEach {
        println("User: ${it.id} - ${it.name} (${it.email})")
    }

    val searchId = 1
    val foundUser = userService.getUserById(searchId)

    if (foundUser != null) {
        Logger.info("User found: ${foundUser.name}")
    } else {
        Logger.error("User not found with ID $searchId")
    }

    Logger.info("Application finished")
}