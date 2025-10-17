package br.com.brunorodrigues.app_bancario_teste.ui.extensions

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidationExtensionsTest {

    @Test
    fun `isValidEmail returns true for valid emails`() {
        assertTrue("test@example.com".isValidEmail())
        assertTrue("user.name@domain.co".isValidEmail())
    }

    @Test
    fun `isValidEmail returns false for invalid emails`() {
        assertFalse("email.co".isValidEmail())
        assertFalse("user.com".isValidEmail())
    }

    @Test
    fun `isValidPassword returns true for valid passwords`() {
        assertTrue("pass1234".isValidPassword())
        assertTrue("abcde1fg".isValidPassword())
    }

    @Test
    fun `isValidPassword returns false for invalid passwords`() {
        assertFalse("pass".isValidPassword())
        assertFalse("123456".isValidPassword())
    }
}
