/*
 * This Kotlin source file was generated by the Gradle "init" task.
 */
package multimoduleprojecttake1.app

import multimoduleprojecttake1.app.helloworld.MessageUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MessageUtilsTest {
  @Test
  fun testGetMessage() {
    assertEquals("Hello      World!", MessageUtils.getMessage())
  }
}
