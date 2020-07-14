package acceleratehrms

import com.usermanagment.Role
import com.usermanagment.User
import com.usermanagment.UserRole


class BootStrap {

    def init = { servletContext ->

      def harishbabu = new User(username: "harishbabu",email: "babuamuda@gmail.com",mobile:"8667710055",country: "INDIA",state: "TAMIL NADU",password:"B@vana20",gender:"Male",bloodgroup:"O+ve",firstName: "Harish Babu",lastName: "Krishnan",dob: "1989-02-18").save()
      def admin = new Role(authority:"ROLE_ADMIN").save()
      def developer = new Role(authority:"ROLE_DEVELOPER").save()
      def finance = new Role(authority: "ROLE_FINANCE").save()

      UserRole.create(harishbabu,admin)
    }
    def destroy = {
    }
}
