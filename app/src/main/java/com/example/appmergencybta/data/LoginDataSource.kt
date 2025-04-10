package com.example.appmergencybta.data

import com.example.appmergencybta.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

  /* fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }
*/
   fun login(username: String, password: String): Result<LoggedInUser> {
       return if (username == "demo" && password == "123456") {
           val fakeUser = LoggedInUser(userId = "1", displayName = "Usuario Demo")
           Result.Success(fakeUser)
       } else {
           Result.Error(Exception("Login fallido"))
       }
   }

    fun logout() {
        // TODO: revoke authentication
    }
}