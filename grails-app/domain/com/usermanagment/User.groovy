package com.usermanagment

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String firstName
    String lastName
    String gender
    Date dob
    String email
    String mobile
    String country
    String state
    String bloodgroup
    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {

        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        firstName nullable: false, blank: false
        lastName nullable: false, blank: false
        gender nullable: false, blank: false
        dob nullable: false, blank: false
        email nullable: false, blank: false, unique: true,email:true
        mobile nullable: false, blank: false, unique: true
        bloodgroup nullable: false, blank: false
        country nullable: false, blank: false
        state nullable: false, blank: false

    }

    static mapping = {
	    password column: '`password`'
    }
}
