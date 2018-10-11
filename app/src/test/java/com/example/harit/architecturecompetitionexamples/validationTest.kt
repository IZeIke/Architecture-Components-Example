package com.example.harit.architecturecompetitionexamples

import com.example.harit.architecturecompetitionexamples.extension.checkName
import com.example.harit.architecturecompetitionexamples.extension.checkPassword
import com.example.harit.architecturecompetitionexamples.extension.checkUsername
import org.junit.Assert.*
import org.junit.Test

class ValidationTest {

    @Test
    fun testUsernameShouldFalse(){
        assertEquals(false,"qwerty".checkUsername())
    }

    @Test
    fun testUsernameShouldTrue(){
        assertEquals(true,"ice123456".checkUsername())
    }

    @Test
    fun testNameShouldFalse(){
        assertEquals(false,"ice123456*".checkName())
    }

    @Test
    fun testNameShouldTrue(){
        assertEquals(true,"Harit20451".checkName())
    }

    @Test
    fun testPasswordShouldFalse(){
        assertEquals(false,"1q2w3e4r".checkPassword())
    }

    @Test
    fun testPasswordShouldTrue(){
        assertEquals(true,"1q2w3e4rq".checkPassword())
    }
}