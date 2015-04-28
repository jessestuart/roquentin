import com.roquentin.Role
import com.roquentin.User
import com.roquentin.UserRole

class BootStrap {

    def init = { servletContext ->
        if (!Role.count()) {
            new Role(authority: 'ROLE_USER').save(flush:true, failOnError:true)
            new Role(authority: 'ROLE_ADMIN').save(flush:true, failOnError:true)
        }

        if (!User.count()) {
            def roleUser = Role.findByAuthority('ROLE_USER')
            def roleAdmin = Role.findByAuthority('ROLE_ADMIN')
            assert roleUser
            assert roleAdmin

            def users = [
                sartre: ['Jean-Paul', 'Sartre', 'jeanpaulsartre@asdf.com'],
                camus: ['Albert', 'Camus', 'albertcamus@asdf.com']
            ]

            users.each { username, data ->
                def user = new User(
                    username: username,
                    password: 'admin',
                    firstName: data[0],
                    lastName: data[1],
                    email: data[2]
                )
                user.save(flush:true, failOnError:true)
                UserRole.create user, (username == 'sartre' ? roleAdmin : roleUser), true
            }

        }
    }

    def destroy = {
    }
}
