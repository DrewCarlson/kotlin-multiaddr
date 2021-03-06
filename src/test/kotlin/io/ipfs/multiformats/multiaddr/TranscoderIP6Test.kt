package io.ipfs.multiformats.multiaddr

import org.junit.Assert.*
import org.junit.Test
import java.util.*

/**
 * changjiashuai@gmail.com.
 *
 * Created by CJS on 2018/7/23.
 */
class TranscoderIP6Test {

    private val ipv6Str = "2601:9:4f81:9700:803e:ca65:66e8:c21"
    private val ipv4Bytes = byteArrayOf(14, -41, -79, 38)
    private val ipv6Bytes = byteArrayOf(38, 1, 0, 9, 79, -127, -105, 0, -128, 62, -54, 101, 102, -24, 12, 33)

    @Test
    fun stringToBytes() {
        val bytes = IPv6Transcoder().stringToBytes(ipv6Str)
        assertTrue(Arrays.equals(bytes, ipv6Bytes))
    }

    @Test
    fun bytesToString() {
        val str = IPv6Transcoder().bytesToString(ipv6Bytes)
        assertEquals(ipv6Str, str)
    }

    @Test
    fun validateBytes() {
        val iPv6Transcoder = IPv6Transcoder()
        assertTrue(iPv6Transcoder.isValidBytes(ipv6Bytes))
        assertFalse(iPv6Transcoder.isValidBytes(ipv4Bytes))
    }
}