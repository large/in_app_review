package dev.britannio.in_app_review

import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import kotlin.test.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

internal class InAppReviewPluginTest {
    @Test
    fun onMethodCall_unknownMethod_isNotImplemented() {
        val result = mock(MethodChannel.Result::class.java)

        InAppReviewPlugin().onMethodCall(MethodCall("unknown", null), result)

        verify(result).notImplemented()
    }

    @Test
    fun onMethodCall_isAvailableWithoutActivity_returnsFalse() {
        val result = mock(MethodChannel.Result::class.java)

        InAppReviewPlugin().onMethodCall(MethodCall("isAvailable", null), result)

        verify(result).success(false)
    }

    @Test
    fun onMethodCall_requestReviewWithoutContext_returnsError() {
        val result = mock(MethodChannel.Result::class.java)

        InAppReviewPlugin().onMethodCall(MethodCall("requestReview", null), result)

        verify(result).error("error", "Android context not available", null)
    }
}
